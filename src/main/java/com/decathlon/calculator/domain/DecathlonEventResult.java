package com.decathlon.calculator.domain;

import com.decathlon.calculator.enums.DecathlonEvent;

public class DecathlonEventResult {

  private double result;
  private String unformattedResult;
  private DecathlonEvent event;

  public double getResult() {
    return result;
  }
  public DecathlonEventResult setResult(double result) {
    this.result = result;
    return this;
  }
  public String getUnformattedResult() {
    return unformattedResult;
  }
  public DecathlonEventResult setUnformattedResult(String unformattedResult) {
    this.unformattedResult = unformattedResult;
    return this;
  }
  public DecathlonEvent getEvent() {
    return event;
  }
  public DecathlonEventResult setEvent(DecathlonEvent event) {
    this.event = event;
    return this;
  }

  @Override
  public String toString() {
    return this.event+" unformatted result="+this.unformattedResult+" result="+this.result;
  }
  
}
