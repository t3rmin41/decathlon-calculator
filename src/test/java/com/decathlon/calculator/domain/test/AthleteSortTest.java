package com.decathlon.calculator.domain.test;

import static org.junit.Assert.assertEquals;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import com.decathlon.calculator.domain.Athlete;
import com.decathlon.calculator.domain.AthleteSort;

public class AthleteSortTest {

  private List<Athlete> athletes = generateAthleteList();
  
  @Test
  public void checkAthleteAscendingSort() {
    Collections.sort(athletes, AthleteSort.SORT_POINTS_ASCENDING);

    assertEquals(9329, athletes.get(0).getPoints());
    assertEquals(10223, athletes.get(1).getPoints());
    assertEquals(12779, athletes.get(2).getPoints());
    assertEquals(12779, athletes.get(3).getPoints());
  }
  
  @Test
  public void checkAthleteDescendingSort() {
    Collections.sort(athletes, AthleteSort.SORT_POINTS_DESCENDING);

    assertEquals(12779, athletes.get(0).getPoints());
    assertEquals(12779, athletes.get(1).getPoints());
    assertEquals(10223, athletes.get(2).getPoints());
    assertEquals(9329, athletes.get(3).getPoints());
  }

  private List<Athlete> generateAthleteList() {
    List<Athlete> athletes = new LinkedList<Athlete>();
    
    Athlete a1 = new Athlete().setFirstName("Athlete 1 name").setLastName("Athlete 1 surname");
    a1.setPoints(12779);
    
    Athlete a2 = new Athlete().setFirstName("Athlete 2 name").setLastName("Athlete 2 surname");
    a2.setPoints(10223);

    Athlete a3 = new Athlete().setFirstName("Athlete 3 name").setLastName("Athlete 3 surname");
    a3.setPoints(12779);

    Athlete a4 = new Athlete().setFirstName("Athlete 4 name").setLastName("Athlete 4 surname");
    a4.setPoints(9329);

    athletes.add(a1); athletes.add(a2); athletes.add(a3); athletes.add(a4);
    
    return athletes;
  }

}
