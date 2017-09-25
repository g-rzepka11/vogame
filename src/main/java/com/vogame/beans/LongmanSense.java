package com.vogame.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LongmanSense {

  @JsonProperty("definition")
  private List<String> longmanSenseDefinitions;

  public List<String> getLongmanSenseDefinitions() {
    return longmanSenseDefinitions;
  }

  public void setLongmanSenseDefinitions(List<String> longmanSenseDefinitions) {
    this.longmanSenseDefinitions = longmanSenseDefinitions;
  }
}
