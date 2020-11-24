package com.vogame.dto.learn;

public class LearnConfigDTO {
    private Integer wordsPerDay;

    public LearnConfigDTO() {
    }

    public LearnConfigDTO(Integer wordsPerDay) {
        this.wordsPerDay = wordsPerDay;
    }

    public Integer getWordsPerDay() {
        return wordsPerDay;
    }

    public void setWordsPerDay(Integer wordsPerDay) {
        this.wordsPerDay = wordsPerDay;
    }
}
