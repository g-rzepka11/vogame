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

    private Long dailyNewWordsCount;

    private Date lastLearningDate;


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

    public Long getDailyNewWordsCount() {
        return this.dailyNewWordsCount;
    }

    public void setDailyNewWordsCount(Long dailyNewWordsCount) {
        this.dailyNewWordsCount = dailyNewWordsCount;
    }

    public Date getLastLearningDate() {
        return lastLearningDate;
    }

    public void setLastLearningDate(Date lastLearningDate) {
        this.lastLearningDate = lastLearningDate;
    }
}
