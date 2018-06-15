package com.decathlon.calculator.domain;

public class Athlete  {

  private String firstName;
  private String lastName;
  private DecathlonEventResult[] results = new DecathlonEventResult[10];
  private int points;
  private int place;
  private int placesShared;
  
  public String getFirstName() {
    return firstName;
  }
  public Athlete setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }
  public String getLastName() {
    return lastName;
  }
  public Athlete setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }
  public DecathlonEventResult[] getResults() {
    return results;
  }
  public int getPoints() {
    return points;
  }
  public Athlete setPoints(int points) {
    this.points = points;
    return this;
  }
  public int getPlace() {
    return place;
  }
  public Athlete setPlace(int place) {
    this.place = place;
    return this;
  }
  public int getPlacesShared() {
    return placesShared;
  }
  public Athlete setPlacesShared(int placesShared) {
    this.placesShared = placesShared;
    return this;
  }
  public String getFormattedPlace() {
    if (placesShared > 0) {
      return place+"-"+(place+placesShared);
    } else {
      return new Integer(place).toString();
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[Athlete:(firstName=");
    sb.append(firstName);
    sb.append(" lastName=");
    sb.append(lastName);
    sb.append(")(points=");
    sb.append(points);
    sb.append(")(place=");
    sb.append(place);
    sb.append(")(places shared=");
    sb.append(placesShared);
    sb.append(") results: {");
    int i = 0;
    for (i = 0; i < results.length-1; i++) {
      sb.append(results[i].toString());
      sb.append(";");
    }
    sb.append(results[i]);
    sb.append("}]");
    return sb.toString();
  }

}
