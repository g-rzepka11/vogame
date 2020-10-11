package com.vogame.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "vogame", name = "word_package")
public class WordPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String wordPackageName;

    @Column
    private Boolean isPrivate;

    @Column(updatable = false)
    private Long userId;

    @Column(updatable = false)
    private Date createdAt;

    @Column
    private String status;

    @OneToMany(mappedBy = "wordPackageId", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id ASC")
    @Lazy
    private List<Word> words;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWordPackageName() {
        return wordPackageName;
    }

    public void setWordPackageName(String wordPackageName) {
        this.wordPackageName = wordPackageName;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
