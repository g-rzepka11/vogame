package com.vogame.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HashUtils {

    public String updateHash(String hashedWord, final String currentWord) {
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

    public String getHashOfWord(String currentWord) {
        return currentWord.replaceAll("\\S", "_");
    }
}
