package com.vogame.service;

import com.vogame.dto.common.AbstractVogameResponse;
import com.vogame.dto.learn.*;
import com.vogame.dto.learn.response.*;
import com.vogame.entity.LearnUser;
import com.vogame.entity.LearnUserWord;
import com.vogame.exception.LearnUserNotExistsException;
import com.vogame.repository.LearnUserRepository;
import com.vogame.repository.LearnUserWordRepository;
import com.vogame.util.DateUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LearnService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LearnUserWordRepository learnUserWordRepository;

    @Autowired
    private LearnUserRepository learnUserRepository;

    private static final Integer pageSize = 10;

    private static final Integer dailyLimit = 50;

    public SaveLearnUserWordResponse save(SaveLearnUserWordsRequest request) {
        LearnUserWord word;
        if(request.getLearnUserWordId() == null) {
            word = new LearnUserWord();
            word.setCreateDate(new Date());
            word.setStatus(0);
            word.setReverseStatus(0);
            word.setLearnUser(learnUserRepository.findFirstByUser_Id(request.getUserId()));
        } else {
            word = learnUserWordRepository.getOne(request.getLearnUserWordId());
        }

        word.setWord(request.getWord());
        word.setTranslation(request.getTranslation());
        LearnUserWord saveLearnUserWord = learnUserWordRepository.save(word);
        return SaveLearnUserWordResponse.builder()
                .payload(modelMapper.map(saveLearnUserWord, LearnUserWordDTO.class)).build();
    }

    public AbstractVogameResponse delete(Long id) {
        learnUserWordRepository.deleteById(id);
        return AbstractVogameResponse.AbstractVogameResponseBuilder().build();
    }

    public StartLearningResponse startLearning(Long userId) {
        LearnUser learnUser = learnUserRepository.findFirstByUser_Id(userId);

        Date startOfToday = DateUtil.startOfTodayUTC();

        if(learnUser.getLastLearningDate() == null
                || startOfToday.after(learnUser.getLastLearningDate())) {
            learnUser.setLastLearningDate(startOfToday);
            LearnUser savedLearnUser = learnUserRepository.save(learnUser);
            addNewWords(userId, startOfToday, savedLearnUser);
        }

        List<LearnUserWordDTO> words = learnUserWordRepository
                .findByCheckWordDateLessThanEqualAndLearnUser_User_IdAndStatus(startOfToday, userId, 1)
                .stream()
                .map(invitation -> modelMapper.map(invitation, LearnUserWordDTO.class))
                .collect(Collectors.toList());
        return StartLearningResponse.builder().payload(words).build();

    }

    private void addNewWords(Long userId, Date startOfToday, LearnUser savedLearnUser) {
        Integer wordsForTodayWithoutNewWords = learnUserWordRepository
                .countByCheckWordDateLessThanEqualAndLearnUser_User_IdAndStatus(startOfToday, userId, 1);

        int wordsLessThanLimitCount = dailyLimit - wordsForTodayWithoutNewWords;
        if(wordsLessThanLimitCount > 0) {
            Integer newWordsCount = Integer.min(wordsLessThanLimitCount, savedLearnUser.getDailyNewWordsCount().intValue());
            Pageable limit = PageRequest.of(0, newWordsCount);
            List<LearnUserWord> words = learnUserWordRepository
                    .findByLearnUser_User_IdAndStatusOrderByCreateDateAsc(userId, 0, limit);
            words.stream().forEach(word -> {
                word.setKnowledgeLevel(0);
                word.setCheckWordDate(startOfToday);
                word.setStatus(1);
            });
            learnUserWordRepository.saveAll(words);
        }
    }

    public StartLearningResponse reverseStartLearning(Long userId) {
        LearnUser learnUser = learnUserRepository.findFirstByUser_Id(userId);

        Date startOfToday = DateUtil.startOfTodayUTC();

        if(learnUser.getReverseLastLearningDate() == null
                || startOfToday.after(learnUser.getReverseLastLearningDate())) {
            learnUser.setReverseLastLearningDate(startOfToday);
            LearnUser savedLearnUser = learnUserRepository.save(learnUser);
            addNewWordsReverse(userId, startOfToday, savedLearnUser);
        }

        List<LearnUserWordDTO> words = learnUserWordRepository
                .findByReverseCheckWordDateLessThanEqualAndLearnUser_User_IdAndReverseStatus(startOfToday, userId, 1)
                .stream()
                .map(invitation -> modelMapper.map(invitation, LearnUserWordDTO.class))
                .collect(Collectors.toList());
        return StartLearningResponse.builder().payload(words).build();

    }

    private void addNewWordsReverse(Long userId, Date startOfToday, LearnUser savedLearnUser) {
        Integer wordsForTodayWithoutNewWords = learnUserWordRepository
                .countByReverseCheckWordDateLessThanEqualAndLearnUser_User_IdAndReverseStatus(startOfToday, userId, 1);

        int wordsLessThanLimitCount = dailyLimit - wordsForTodayWithoutNewWords;
        if(wordsLessThanLimitCount > 0) {
            Integer newWordsCount = Integer.min(wordsLessThanLimitCount, savedLearnUser.getReverseDailyNewWordsCount().intValue());
            Pageable limit = PageRequest.of(0, newWordsCount);
            List<LearnUserWord> words = learnUserWordRepository
                    .findByLearnUser_User_IdAndReverseStatusOrderByCreateDateAsc(userId, 0, limit);
            words.stream().forEach(word -> {
                word.setReverseKnowledgeLevel(0);
                word.setReverseCheckWordDate(startOfToday);
                word.setReverseStatus(1);
            });
            learnUserWordRepository.saveAll(words);
        }
    }

    public AbstractVogameResponse know(Long learnUserWordId) {
        LearnUserWord word = learnUserWordRepository.getOne(learnUserWordId);
        if(word.getKnowledgeLevel() == 5) {
            word.setStatus(2);
        } else {
            word.setKnowledgeLevel(word.getKnowledgeLevel() + 1);
            int daysNumberToAdd = getDaysNumberToAdd(word.getKnowledgeLevel());
            word.setCheckWordDate(
                    DateUtil.localDateTimeToDateUTC(
                            DateUtil.startOfDayLocalDateTime().plusDays(daysNumberToAdd)));
        }
        learnUserWordRepository.save(word);
        return AbstractVogameResponse.AbstractVogameResponseBuilder().build();
    }

    public AbstractVogameResponse reverseKnow(Long learnUserWordId) {
        LearnUserWord word = learnUserWordRepository.getOne(learnUserWordId);
        if(word.getReverseKnowledgeLevel() == 5) {
            word.setReverseStatus(2);
        } else {
            word.setReverseKnowledgeLevel(word.getReverseKnowledgeLevel() + 1);
            int daysNumberToAdd = getDaysNumberToAdd(word.getReverseKnowledgeLevel());
            word.setReverseCheckWordDate(
                    DateUtil.localDateTimeToDateUTC(
                            DateUtil.startOfDayLocalDateTime().plusDays(daysNumberToAdd)));
        }
        learnUserWordRepository.save(word);
        return AbstractVogameResponse.AbstractVogameResponseBuilder().build();
    }

    public AbstractVogameResponse dontKnow(Long learnUserWordId) {
        LearnUserWord word = learnUserWordRepository.getOne(learnUserWordId);
        word.setKnowledgeLevel(0);
        learnUserWordRepository.save(word);
        return AbstractVogameResponse.AbstractVogameResponseBuilder().build();
    }

    public AbstractVogameResponse reverseDontKnow(Long learnUserWordId) {
        LearnUserWord word = learnUserWordRepository.getOne(learnUserWordId);
        word.setReverseKnowledgeLevel(0);
        learnUserWordRepository.save(word);
        return AbstractVogameResponse.AbstractVogameResponseBuilder().build();
    }

    private int getDaysNumberToAdd(Integer knowledgeLevel) {
        switch (knowledgeLevel) {
            case 0:
                return 0;//never used? to del?
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 5;
            case 4:
                return 9;
            case 5:
                return 15;
            default:
                throw new RuntimeException("Unknown level");

        }
    }

    public GetLearnStatsResponse getStats(Long userId) {
        LearnStatsDTO learnStatsDTO = new LearnStatsDTO();

        LearnUser learnUser = learnUserRepository.findFirstByUser_Id(userId);

        learnStatsDTO.setStatsForDate(learnUser.getLastLearningDate());

        learnStatsDTO.setTotalWords(learnUserWordRepository.countByLearnUser_User_Id(userId));

        learnStatsDTO.setLearnedWords(learnUserWordRepository
                .countByLearnUser_User_IdAndStatus(userId, 2));

        learnStatsDTO.setPendingWords(learnUserWordRepository
                .countByCheckWordDateIsNullAndLearnUser_User_IdAndStatus(userId, 0));

        learnStatsDTO.setRemainingWordsForDay(learnUserWordRepository
                .countByCheckWordDateLessThanEqualAndLearnUser_User_IdAndStatus(
                        DateUtil.startOfTodayUTC(),
                        userId, 1));

        learnStatsDTO.setReverseLearnedWords(learnUserWordRepository
                .countByLearnUser_User_IdAndReverseStatus(userId, 2));

        learnStatsDTO.setReversePendingWords(learnUserWordRepository
                .countByReverseCheckWordDateIsNullAndLearnUser_User_IdAndReverseStatus(userId, 0));

        learnStatsDTO.setReverseRemainingWordsForDay(learnUserWordRepository
                .countByReverseCheckWordDateLessThanEqualAndLearnUser_User_IdAndReverseStatus(
                        DateUtil.startOfTodayUTC(),
                        userId, 1));

        return GetLearnStatsResponse.builder().payload(learnStatsDTO).build();
    }

    public GetLearnUserWordsPageResponse getByUserId(Long userId, Integer pageNumber) {
        Integer count = learnUserWordRepository.countByLearnUser_User_Id(userId);
        if(pageNumber == null) {
            pageNumber = (count-1)/pageSize;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page<LearnUserWord> result = learnUserWordRepository
                .findByLearnUser_User_IdOrderByCreateDateAsc(userId, pageable);

        LearnUserWordsPageDTO response = new LearnUserWordsPageDTO();
        response.setLearnUserWordDTOS(result.getContent().stream()
                .map(invitation -> modelMapper.map(invitation, LearnUserWordDTO.class))
                .collect(Collectors.toList()));
        response.setPageNumber(result.getNumber());
        response.setTotalPages(result.getTotalPages());
        return GetLearnUserWordsPageResponse.builder().payload(response).build();
    }

    public GetLearnConfigResponse getConfig(Long userId) throws LearnUserNotExistsException {
        LearnUser learnUser = learnUserRepository.findFirstByUser_Id(userId);
        if(learnUser == null) {
            throw new LearnUserNotExistsException("LearnUser not found");
        }
        LearnConfigDTO learnConfigDTO = new LearnConfigDTO();
        learnConfigDTO.setWordsPerDay(learnUser.getDailyNewWordsCount());
        return GetLearnConfigResponse.builder().payload(learnConfigDTO).build();
    }

    public AbstractVogameResponse saveConfig(Long userId, LearnConfigDTO learnConfigDTO) throws LearnUserNotExistsException {
        LearnUser learnUser = learnUserRepository.findFirstByUser_Id(userId);
        if(learnUser == null) {
            throw new LearnUserNotExistsException("LearnUser not found");
        }
        learnUser.setDailyNewWordsCount(learnConfigDTO.getWordsPerDay());
        learnUserRepository.save(learnUser);
        return AbstractVogameResponse.AbstractVogameResponseBuilder().build();
    }
}
