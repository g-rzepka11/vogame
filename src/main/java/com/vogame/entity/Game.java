package com.vogame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String status;

    @Column
    private Long currentUser;

    @Column
    private Long wordPackageId;

    @Column
    private Long nextWord;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Long currentUser) {
        this.currentUser = currentUser;
    }

    public Long getWordPackageId() {
        return wordPackageId;
    }

    public void setWordPackageId(Long wordPackageId) {
        this.wordPackageId = wordPackageId;
    }

    public Long getNextWord() {
        return nextWord;
    }

    public void setNextWord(Long nextWord) {
        this.nextWord = nextWord;
    }
}
