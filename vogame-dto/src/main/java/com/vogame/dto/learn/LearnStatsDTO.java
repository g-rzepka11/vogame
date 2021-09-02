package com.vogame.dto.learn;

import java.util.Date;

public class LearnStatsDTO {

    private Date statsForDate;

    private Integer totalWords;

    private Integer learnedWords;

    private Integer pendingWords;

    private Integer remainingWordsForDay;

    private Integer reverseLearnedWords;

    private Integer reversePendingWords;

    private Integer reverseRemainingWordsForDay;

    public Date getStatsForDate() {
        return statsForDate;
    }

    public void setStatsForDate(Date statsForDate) {
        this.statsForDate = statsForDate;
    }

    public Integer getTotalWords() {
        return totalWords;
    }

    public void setTotalWords(Integer totalWords) {
        this.totalWords = totalWords;
    }

    public Integer getLearnedWords() {
        return learnedWords;
    }

    public void setLearnedWords(Integer learnedWords) {
        this.learnedWords = learnedWords;
    }

    public Integer getPendingWords() {
        return pendingWords;
    }

    public void setPendingWords(Integer pendingWords) {
        this.pendingWords = pendingWords;
    }

    public Integer getRemainingWordsForDay() {
        return remainingWordsForDay;
    }

    public void setRemainingWordsForDay(Integer remainingWordsForDay) {
        this.remainingWordsForDay = remainingWordsForDay;
    }

    public Integer getReverseLearnedWords() {
        return reverseLearnedWords;
    }

    public void setReverseLearnedWords(Integer reverseLearnedWords) {
        this.reverseLearnedWords = reverseLearnedWords;
    }

    public Integer getReversePendingWords() {
        return reversePendingWords;
    }

    public void setReversePendingWords(Integer reversePendingWords) {
        this.reversePendingWords = reversePendingWords;
    }

    public Integer getReverseRemainingWordsForDay() {
        return reverseRemainingWordsForDay;
    }

    public void setReverseRemainingWordsForDay(Integer reverseRemainingWordsForDay) {
        this.reverseRemainingWordsForDay = reverseRemainingWordsForDay;
    }
}
