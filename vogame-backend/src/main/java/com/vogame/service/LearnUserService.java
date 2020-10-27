package com.vogame.service;

import com.vogame.dto.LearnUserWordDTO;
import com.vogame.entity.LearnUser;
import com.vogame.entity.LearnUserWord;
import com.vogame.repository.LearnUserRepository;
import com.vogame.repository.LearnUserWordRepository;
import com.vogame.util.DateUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LearnUserService {

    @Autowired
    private LearnUserRepository learnUserRepository;

    @Autowired
    private LearnUserWordRepository learnUserWordRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<LearnUserWordDTO> startLearning(Long userId) {
        LearnUser learnUser = learnUserRepository.findFirstByUser_Id(userId);

        Date startOfToday = DateUtil.localDateToDate(LocalDate.now());

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
            word.setCheckWordDate(DateUtil.localDateToDate(LocalDate.now().plusDays(daysNumberToAdd)));
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
}
