package com.vogame.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LongmanResult {

  @JsonProperty("part_of_speech")
  private String partOfSpeech;

  @JsonProperty("senses")
  private List<LongmanSense> longmanSenses;

  public String getPartOfSpeech() {
    return partOfSpeech;
  }

  public void setPartOfSpeech(String partOfSpeech) {
    this.partOfSpeech = partOfSpeech;
  }

  public List<LongmanSense> getLongmanSenses() {
    return longmanSenses;
  }

  public void setLongmanSenses(List<LongmanSense> longmanSenses) {
    this.longmanSenses = longmanSenses;
  }
}
