package com.vogame.service;

import com.vogame.dto.LearnUserWordDTO;
import com.vogame.dto.SaveLearnUserWordsRequest;
import com.vogame.entity.LearnUserWord;
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

    public List<LearnUserWordDTO> getByUserId(Long userId) {
        return learnUserWordRepository.findByUserId(userId).stream()
                .map(invitation -> modelMapper.map(invitation, LearnUserWordDTO.class))
                .collect(Collectors.toList());
    }

    public LearnUserWordDTO save(SaveLearnUserWordsRequest request) {
        LearnUserWord word = null;
        if(request.getLearnUserWordId() == null) {
            word = new LearnUserWord();
            word.setCreateDate(new Date());
            word.setStatus(0L);
            word.setUserId(request.getUserId());
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
