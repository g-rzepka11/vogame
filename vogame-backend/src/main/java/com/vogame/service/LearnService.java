package com.vogame.service;

import com.vogame.dto.*;
import com.vogame.entity.LearnUser;
import com.vogame.entity.LearnUserWord;
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

    public LearnUserWordDTO save(SaveLearnUserWordsRequest request) {
        LearnUserWord word;
        if(request.getLearnUserWordId() == null) {
            word = new LearnUserWord();
            word.setCreateDate(new Date());
            word.setStatus(0);
            word.setLearnUser(learnUserRepository.findFirstByUser_Id(request.getUserId()));
        } else {
            word = learnUserWordRepository.getOne(request.getLearnUserWordId());
        }

        word.setWord(request.getWord());
        word.setTranslation(request.getTranslation());
        LearnUserWord saveLearnUserWord = learnUserWordRepository.save(word);
        return modelMapper.map(saveLearnUserWord, LearnUserWordDTO.class);
    }

    public void delete(Long id) {
        learnUserWordRepository.deleteById(id);
    }

    public List<LearnUserWordDTO> startLearning(Long userId) {
        LearnUser learnUser = learnUserRepository.findFirstByUser_Id(userId);

        Date startOfToday = DateUtil.startOfTodayUTC();

        if(learnUser.getLastLearningDate() == null
                || startOfToday.after(learnUser.getLastLearningDate())) {
            learnUser.setLastLearningDate(startOfToday);
            LearnUser savedLearnUser = learnUserRepository.save(learnUser);
            Pageable limit = PageRequest.of(0, savedLearnUser.getDailyNewWordsCount().intValue());
            List<LearnUserWord> words = learnUserWordRepository
                    .findByLearnUser_User_IdAndStatusOrderByCreateDateAsc(userId, 0, limit);
            words.stream().forEach(word -> {
                word.setKnowledgeLevel(0);
                word.setCheckWordDate(startOfToday);
                word.setStatus(1);
            });
            learnUserWordRepository.saveAll(words);
        }

        return learnUserWordRepository
                .findByCheckWordDateAndLearnUser_User_IdAndStatus(startOfToday, userId, 1)
                .stream()
                .map(invitation -> modelMapper.map(invitation, LearnUserWordDTO.class))
                .collect(Collectors.toList());

    }

    public void know(Long learnUserWordId) {
        LearnUserWord word = learnUserWordRepository.getOne(learnUserWordId);
        if(word.getKnowledgeLevel() > 5) {
            word.setStatus(2);
        } else {
            word.setKnowledgeLevel(word.getKnowledgeLevel() + 1);
            int daysNumberToAdd = getDaysNumberToAdd(word.getKnowledgeLevel());
            word.setCheckWordDate(
                    DateUtil.localDateTimeToDateUTC(
                            DateUtil.startOfDayLocalDateTime().plusDays(daysNumberToAdd)));
        }
        learnUserWordRepository.save(word);
    }

    public void dontKnow(Long learnUserWordId) {
        LearnUserWord word = learnUserWordRepository.getOne(learnUserWordId);
        word.setKnowledgeLevel(0);
        learnUserWordRepository.save(word);
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

    public LearnStatsDTO getStats(Long userId) {
        LearnStatsDTO learnStatsDTO = new LearnStatsDTO();

        LearnUser learnUser = learnUserRepository.findFirstByUser_Id(userId);

        learnStatsDTO.setStatsForDate(learnUser.getLastLearningDate());

        learnStatsDTO.setTotalWords(learnUserWordRepository.countByLearnUser_User_Id(userId));

        learnStatsDTO.setLearnedWords(learnUserWordRepository
                .countByLearnUser_User_IdAndStatus(userId, 2));

        learnStatsDTO.setPendingWords(learnUserWordRepository
                .countByCheckWordDateAndLearnUser_User_IdAndStatus(null, userId, 0));

        learnStatsDTO.setRemainingWordsForDay(learnUserWordRepository
                .countByCheckWordDateAndLearnUser_User_IdAndStatus(
                        DateUtil.startOfTodayUTC(),
                        userId, 1));

        return learnStatsDTO;
    }

    public LearnUserWordsPageResponse getByUserId(Long userId, Integer pageNumber) {
        Integer count = learnUserWordRepository.countByLearnUser_User_Id(userId);
        if(pageNumber == null) {
            pageNumber = (count-1)/pageSize;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page<LearnUserWord> result = learnUserWordRepository
                .findByLearnUser_User_IdOrderByCreateDateAsc(userId, pageable);

        LearnUserWordsPageResponse response = new LearnUserWordsPageResponse();
        response.setLearnUserWordDTOS(result.getContent().stream()
                .map(invitation -> modelMapper.map(invitation, LearnUserWordDTO.class))
                .collect(Collectors.toList()));
        response.setPageNumber(result.getNumber());
        response.setTotalPages(result.getTotalPages());
        return response;
    }

    public LearnConfigDTO getConfig(Long userId) {
        LearnUser learnUser = learnUserRepository.findFirstByUser_Id(userId);
        LearnConfigDTO learnConfigDTO = new LearnConfigDTO();
        learnConfigDTO.setWordsPerDay(learnUser.getDailyNewWordsCount());
        return learnConfigDTO;
    }

    public void saveConfig(Long userId, LearnConfigDTO learnConfigDTO) {
        LearnUser learnUser = learnUserRepository.findFirstByUser_Id(userId);
        learnUser.setDailyNewWordsCount(learnConfigDTO.getWordsPerDay());
        learnUserRepository.save(learnUser);
    }
}
