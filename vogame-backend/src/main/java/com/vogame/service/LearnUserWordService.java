package com.vogame.service;

import com.vogame.dto.LearnUserWordDTO;
import com.vogame.dto.SaveLearnUserWordsRequest;
import com.vogame.entity.LearnUserWord;
import com.vogame.repository.LearnUserRepository;
import com.vogame.repository.LearnUserWordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LearnUserWordService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LearnUserWordRepository learnUserWordRepository;

    @Autowired
    private LearnUserRepository learnUserRepository;

    public List<LearnUserWordDTO> getByUserId(Long userId) {
        return learnUserWordRepository.findByLearnUser_User_Id(userId).stream()
                .map(invitation -> modelMapper.map(invitation, LearnUserWordDTO.class))
                .collect(Collectors.toList());
    }

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
}
