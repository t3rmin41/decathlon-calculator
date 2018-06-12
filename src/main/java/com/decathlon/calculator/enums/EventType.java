package com.decathlon.calculator.enums;

public enum EventType {

  TRACK("Track"),
  FIELD("Field");
  
  private String title;
  
  private EventType(String title) {
    this.title = title;
  }
  
  public EventType getEventByTitle(String title) {
    for (EventType type : EventType.values()) {
      if (type.title.equals(title)) {
        return type;
      }
    }
    return null;
  }
  
}
