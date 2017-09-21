package com.vogame.beans;

public class Word {

    private String content;

    private String definition;

    public Word() {
    }

    public Word(String content, String definition) {
        this.content = content;
        this.definition = definition;
    }

    public String getContent() {
        return content;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
