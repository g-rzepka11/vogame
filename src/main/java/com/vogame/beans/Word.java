package com.vogame.beans;

public class Word {

    private String content;

    private LongmanResponse definition;

    public Word() {
    }

    public Word(String content, LongmanResponse definition) {
        this.content = content;
        this.definition = definition;
    }

    public String getContent() {
        return content;
    }

    public LongmanResponse getDefinition() {
        return definition;
    }

    public void setDefinition(LongmanResponse definition) {
        this.definition = definition;
    }
}
