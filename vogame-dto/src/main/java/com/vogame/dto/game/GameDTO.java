package com.vogame.dto.game;

import com.vogame.dto.word.WordDTO;

import java.util.Date;
import java.util.List;

public class GameDTO {
    private Long id;
    private String name;
    private Long owner;
    private Integer status;
    private Long curUser;
    private WordDTO word;
    private List<GameUserDTO> gameUsers;
    private List<GameWordDTO> gameWords;
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

    public WordDTO getWord() {
        return word;
    }

    public void setWord(WordDTO word) {
        this.word = word;
    }

    public List<GameUserDTO> getGameUsers() {
        return gameUsers;
    }

    public void setGameUsers(List<GameUserDTO> gameUsers) {
        this.gameUsers = gameUsers;
    }

    public List<GameWordDTO> getGameWords() {
        return gameWords;
    }

    public void setGameWords(List<GameWordDTO> gameWords) {
        this.gameWords = gameWords;
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
