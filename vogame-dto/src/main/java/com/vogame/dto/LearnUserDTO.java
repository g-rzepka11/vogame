package com.vogame.dto;

public class LearnUserDTO {

    private Long id;

    private UserDTO user;

    private Long dailyNewWordsCount;

    private Long lastLearningDate;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Long getDailyNewWordsCount() {
        return this.dailyNewWordsCount;
    }

    public void setDailyNewWordsCount(Long dailyNewWordsCount) {
        this.dailyNewWordsCount = dailyNewWordsCount;
    }

    public Long getLastLearningDate() {
        return this.lastLearningDate;
    }

    public void setLastLearningDate(Long lastLearningDate) {
        this.lastLearningDate = lastLearningDate;
    }
}
