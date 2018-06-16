package com.decathlon.calculator.domain;

import java.util.Comparator;

public class AthleteSort {

  public static final Comparator<Athlete> SORT_POINTS_ASCENDING = new AthletePointsAscending();
  
  public static final Comparator<Athlete> SORT_POINTS_DESCENDING = new AthletePointsDescending();
  
  private static class AthletePointsAscending implements Comparator<Athlete> {
    @Override
    public int compare(Athlete a1, Athlete a2) {
      if (a1.getPoints() > a2.getPoints()) return 1;
      if (a1.getPoints() < a2.getPoints()) return -1;
      return 0;
    }
  }
  
  private static class AthletePointsDescending implements Comparator<Athlete> {
    @Override
    public int compare(Athlete a1, Athlete a2) {
      if (a1.getPoints() < a2.getPoints()) return 1;
      if (a1.getPoints() > a2.getPoints()) return -1;
      return 0;
    }
  }
  
}
