package com.vogame.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "vogame", name = "game")
public class Game {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Long owner;

    @Column
    private Integer status;

    @Column
    private Long curUser;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word")
    private Word word;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GameUser> gameUsers;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GameWord> gameWords;

    @Column
    private Date wordTime;

    @Column
    private String hashedWord;

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

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public String getHashedWord() {
        return hashedWord;
    }

    public void setHashedWord(String hashedWord) {
        this.hashedWord = hashedWord;
    }

    public List<GameUser> getGameUsers() {
        return gameUsers;
    }

    public void setGameUsers(List<GameUser> gameUsers) {
        this.gameUsers = gameUsers;
    }

    public List<GameWord> getGameWords() {
        return gameWords;
    }

    public void setGameWords(List<GameWord> gameWords) {
        this.gameWords = gameWords;
    }

    public Date getWordTime() {
        return wordTime;
    }

    public void setWordTime(Date wordTime) {
        this.wordTime = wordTime;
    }
}
