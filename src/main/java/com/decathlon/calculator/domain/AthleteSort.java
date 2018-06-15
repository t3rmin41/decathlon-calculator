package com.decathlon.calculator.domain;

import java.util.Comparator;

public class AthleteSort {

  public static final Comparator<Athlete> SORT_ASCENDING = new AthleteAscending();
  
  public static final Comparator<Athlete> SORT_DESCENDING = new AthleteDescending();
  
  private static class AthleteAscending implements Comparator<Athlete> {
    @Override
    public int compare(Athlete a1, Athlete a2) {
      if (a1.getPoints() > a2.getPoints()) return 1;
      if (a1.getPoints() < a2.getPoints()) return -1;
      return 0;
    }
  }
  
  private static class AthleteDescending implements Comparator<Athlete> {
    @Override
    public int compare(Athlete a1, Athlete a2) {
      if (a1.getPoints() < a2.getPoints()) return 1;
      if (a1.getPoints() > a2.getPoints()) return -1;
      return 0;
    }
  }
  
}
