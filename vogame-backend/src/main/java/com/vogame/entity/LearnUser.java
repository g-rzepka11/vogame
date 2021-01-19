package com.vogame.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "vogame", name = "learn_user")
public class LearnUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private Integer dailyNewWordsCount;

    private Date lastLearningDate;

    private Integer reverseDailyNewWordsCount;

    private Date reverseLastLearningDate;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getDailyNewWordsCount() {
        return this.dailyNewWordsCount;
    }

    public void setDailyNewWordsCount(Integer dailyNewWordsCount) {
        this.dailyNewWordsCount = dailyNewWordsCount;
    }

    public Date getLastLearningDate() {
        return lastLearningDate;
    }

    public void setLastLearningDate(Date lastLearningDate) {
        this.lastLearningDate = lastLearningDate;
    }

    public Integer getReverseDailyNewWordsCount() {
        return reverseDailyNewWordsCount;
    }

    public void setReverseDailyNewWordsCount(Integer reverseDailyNewWordsCount) {
        this.reverseDailyNewWordsCount = reverseDailyNewWordsCount;
    }

    public Date getReverseLastLearningDate() {
        return reverseLastLearningDate;
    }

    public void setReverseLastLearningDate(Date reverseLastLearningDate) {
        this.reverseLastLearningDate = reverseLastLearningDate;
    }
}
