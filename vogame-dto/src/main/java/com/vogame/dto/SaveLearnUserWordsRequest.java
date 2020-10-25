package com.vogame.dto;

public class SaveLearnUserWordsRequest {
    private Long learnUserWordId;
    private String word;
    private String translation;
    private Long userId;

    public SaveLearnUserWordsRequest() {
    }

    public SaveLearnUserWordsRequest(Long learnUserWordId, String word, String translation, Long userId) {
        this.learnUserWordId = learnUserWordId;
        this.word = word;
        this.translation = translation;
        this.userId = userId;
    }

    public Long getLearnUserWordId() {
        return learnUserWordId;
    }

    public void setLearnUserWordId(Long learnUserWordId) {
        this.learnUserWordId = learnUserWordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
