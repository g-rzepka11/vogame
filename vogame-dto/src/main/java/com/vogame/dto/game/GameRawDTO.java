package com.vogame.dto.game;

import java.util.Date;

public class GameRawDTO {
    private Long id;
    private String name;
    private Long owner;
    private Integer status;
    private Long curUser;
    private String hashedWord;
    private Date wordTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCurUser() {
        return curUser;
    }

    public void setCurUser(Long curUser) {
        this.curUser = curUser;
    }

    public String getHashedWord() {
        return hashedWord;
    }

    public void setHashedWord(String hashedWord) {
        this.hashedWord = hashedWord;
    }

    public Date getWordTime() {
        return wordTime;
    }

    public void setWordTime(Date wordTime) {
        this.wordTime = wordTime;
    }
}
