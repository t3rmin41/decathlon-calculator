package com.decathlon.calculator.enums;

public enum DecathlonEvent {

  RUNNING_100M(1, "100 meters", "running_100_meters", 25.4347, 18, 1.81, EventType.TRACK),
  LONG_JUMP(2, "Long jump", "long_jump", 0.14354, 220, 1.4, EventType.FIELD),
  SHOT_PUT(3, "Shot put", "shot_put", 51.39, 1.5, 1.05, EventType.FIELD),
  HIGH_JUMP(4, "High jump", "high_jump", 0.8465, 75, 1.42, EventType.FIELD),
  RUNNING_400M(5, "400 meters", "running_400_meters", 1.53775, 82, 1.81, EventType.TRACK),
  RUNNING_110M_HURDLES(6, "110 meters hurdles", "running_110_meters_hurdles", 5.74352, 28.5, 1.92, EventType.TRACK),
  DISCUS_THROW(7, "Discus throw", "discus_throw", 12.91, 4, 1.1, EventType.FIELD),
  POLE_VAULT(8, "Pole vault", "pole_vault", 0.2797, 100, 1.35, EventType.FIELD),
  JAVELIN_THROW(9, "Javelin throw", "javelin_throw", 10.14, 7, 1.08, EventType.FIELD),
  RUNNING_1500M(10, "1500 meters", "running_1500_meters", 0.03768, 480, 1.85, EventType.TRACK);
  
  private int id;
  private String title;
  private String xmlTag;
  private double A;
  private double B;
  private double C;
  private EventType type;
  
  private DecathlonEvent(int id, String title, String xmlTag, double A, double B, double C, EventType type) {
    this.id = id;
    this.title = title;
    this.xmlTag = xmlTag;
    this.A = A;
    this.B = B;
    this.C = C;
    this.type = type;
  }

  public static DecathlonEvent getEventById(int id) {
    for (DecathlonEvent event : DecathlonEvent.values()) {
      if (event.id == id) {
        return event;
      }
    }
    return null;
  }

  public String getTitle() {
    return title;
  }

  public String getXmlTag() {
    return xmlTag;
  }

  public double getA() {
    return A;
  }

  public double getB() {
    return B;
  }

  public double getC() {
    return C;
  }

  public EventType getType() {
    return type;
  }

}
