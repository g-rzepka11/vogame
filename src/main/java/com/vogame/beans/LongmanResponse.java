package com.vogame.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LongmanResponse {

  @JsonProperty("results")
  private List<LongmanResult> longmanResult;

  public List<LongmanResult> getLongmanResult() {
    return longmanResult;
  }

  public void setLongmanResult(List<LongmanResult> longmanResult) {
    this.longmanResult = longmanResult;
  }
}
