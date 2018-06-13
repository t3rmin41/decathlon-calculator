package com.decathlon.calculator.enums;

public enum EventType {

  TRACK("Track"),
  FIELD("Field");
  
  private String title;
  
  private EventType(String title) {
    this.title = title;
  }
  
  public String getTitle() {
    return this.title;
  }

}
