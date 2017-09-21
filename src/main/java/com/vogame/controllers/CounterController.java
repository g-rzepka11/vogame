package com.vogame.controllers;

import com.vogame.beans.Counter;
import com.vogame.beans.Word;
import com.vogame.entities.WordEntity;
import com.vogame.repositories.WordRepository;
import com.vogame.services.LongmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CounterController {

    @Autowired
    private LongmanService longmanService;

    @Autowired
    private WordRepository wordRepository;

    private AtomicInteger counter = new AtomicInteger(10);

    private List<WordEntity> wordsList;

    private String currentWord = "";

    private String hashedWord = "";

    private String definition = "";

    @Autowired
    private SimpMessagingTemplate template;

    @PostConstruct
    public void init(){
        wordsList = wordRepository.findAll();

    }

    @Scheduled(fixedDelay = 1000)
    public void sendCounterUpdate() {
        if(counter.get() == 0) {
            counter.set(11);
            if(StringUtils.countOccurrencesOf(hashedWord, "_") == 0) {
                resetWord();
            } else {
                hashedWord = updateHash(hashedWord, currentWord);
            }
            template.convertAndSend("/topic/word",
                    new Word(hashedWord, definition));
        }
        template.convertAndSend("/topic/counter",
                new Counter(Integer.toString(counter.decrementAndGet())));
    }

    private String updateHash(String hashedWord, final String currentWord) {
        List<Integer> indexesOfCharacter = new ArrayList<>();

        for(int i=0; i<hashedWord.length(); i++) {
            if(hashedWord.charAt(i) == '_') {
                indexesOfCharacter.add(i);
            }
        }

        Integer randomInteger = (int) Math.floor(Math.random() * indexesOfCharacter.size());

        StringBuilder sb = new StringBuilder(hashedWord);
        sb.setCharAt(indexesOfCharacter.get(randomInteger), currentWord.charAt(indexesOfCharacter.get(randomInteger)));

        return sb.toString();
    }

    private String getHashOfWord(String currentWord) {
        return currentWord.replaceAll("\\S", "_");
    }

    private void resetWord() {
        currentWord = wordsList.get((int) Math.floor(Math.random() * wordsList.size())).getWord();
        definition = longmanService.getLongmanDefinition(currentWord);
        hashedWord = getHashOfWord(currentWord);
    }

    public void success() {
        resetWord();
        counter.set(10);
        template.convertAndSend("/topic/word",
                new Word(hashedWord, definition));
    }

    public String getCurrentWord() {
        return currentWord;
    }
}
