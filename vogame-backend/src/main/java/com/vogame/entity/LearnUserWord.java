package com.vogame.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "vogame", name = "learn_user_word")
public class LearnUserWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private LearnUser learnUser;

    private Integer status;

    private Date checkWordDate;

    private Integer knowledgeLevel;

    private Date createDate;

    private String word;

    private String translation;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LearnUser getLearnUser() {
        return learnUser;
    }

    public void setLearnUser(LearnUser learnUser) {
        this.learnUser = learnUser;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCheckWordDate() {
        return this.checkWordDate;
    }

    public void setCheckWordDate(Date checkWordDate) {
        this.checkWordDate = checkWordDate;
    }

    public Integer getKnowledgeLevel() {
        return this.knowledgeLevel;
    }

    public void setKnowledgeLevel(Integer knowledgeLevel) {
        this.knowledgeLevel = knowledgeLevel;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
}
