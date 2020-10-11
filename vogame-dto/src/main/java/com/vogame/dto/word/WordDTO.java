package com.vogame.dto.word;

import java.io.Serializable;

public class WordDTO implements Serializable {
    private Long id;
    private String text;
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
