package com.vogame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "vogame", name = "word")
public class Word {

    @Id
    @Column
    private Long id;

    @Column
    private String text;

    @Column
    private Long wordPackageId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getWordPackageId() {
        return wordPackageId;
    }

    public void setWordPackageId(Long wordPackageId) {
        this.wordPackageId = wordPackageId;
    }
}
