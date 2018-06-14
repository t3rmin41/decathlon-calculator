package com.decathlon.calculator.domain.test;

import static org.junit.Assert.assertEquals;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import com.decathlon.calculator.domain.Athlete;

public class AthleteTest {

  @Test
  public void checkAthleteCompare() {
    List<Athlete> athletes = generateAthleteList();
    assertEquals(1, athletes.get(2).compareTo(athletes.get(3)));
    assertEquals(-1, athletes.get(1).compareTo(athletes.get(0)));
    assertEquals(0, athletes.get(0).compareTo(athletes.get(2)));
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
