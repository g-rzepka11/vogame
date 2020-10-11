package com.vogame.entity;

import javax.persistence.*;

@Entity
@Table(schema = "vogame", name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @Column
    private Long wordPackageId;

    private String translation;

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

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
