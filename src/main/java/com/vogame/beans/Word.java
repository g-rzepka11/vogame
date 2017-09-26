package com.vogame.beans;

public class Word {

    private String content;

    private LongmanResponse definition;

    private String previousWord;

    public Word() {
    }

    public Word(String content, LongmanResponse definition, String previousWord) {
        this.content = content;
        this.definition = definition;
        this.previousWord = previousWord;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LongmanResponse getDefinition() {
        return definition;
    }

    public void setDefinition(LongmanResponse definition) {
        this.definition = definition;
    }

    public String getPreviousWord() {
        return previousWord;
    }

    public void setPreviousWord(String previousWord) {
        this.previousWord = previousWord;
    }
}
