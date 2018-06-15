package com.decathlon.calculator.util.test;

import static org.junit.Assert.assertEquals;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import com.decathlon.calculator.domain.Athlete;
import com.decathlon.calculator.domain.AthleteSort;
import com.decathlon.calculator.domain.DecathlonEventResult;
import com.decathlon.calculator.enums.DecathlonEvent;
import com.decathlon.calculator.util.Calculator;
import com.decathlon.calculator.util.CalculatorImpl;

public class CalculatorTest {

  private Calculator calc = new CalculatorImpl();

  List<Athlete> athletes = generateAthleteList();

  @Test
  public void checkEventCalculation() {

    assertEquals(7379, calc.calculateEventPoints(athletes.get(0).getResults()[0]));
    assertEquals(0, calc.calculateEventPoints(athletes.get(0).getResults()[1]));
    assertEquals(431, calc.calculateEventPoints(athletes.get(1).getResults()[2]));
    assertEquals(0, calc.calculateEventPoints(athletes.get(1).getResults()[3]));
    assertEquals(567, calc.calculateEventPoints(athletes.get(2).getResults()[4]));
    assertEquals(3423, calc.calculateEventPoints(athletes.get(2).getResults()[5]));
    assertEquals(472, calc.calculateEventPoints(athletes.get(3).getResults()[6]));
    assertEquals(0, calc.calculateEventPoints(athletes.get(3).getResults()[7]));
    assertEquals(420, calc.calculateEventPoints(athletes.get(3).getResults()[8]));
    assertEquals(5, calc.calculateEventPoints(athletes.get(3).getResults()[9]));
  }
  
  @Test
  public void checkSortedAthletesPlaces() {

    for (Athlete a : athletes) {
      a.setPoints(calc.sumEventPoints(a.getResults()));
    }

    Collections.sort(athletes, AthleteSort.SORT_DESCENDING);

    calc.setSortedAthletesPlaces(athletes);

    assertEquals(1, athletes.get(0).getPlace());
    assertEquals("1-2", athletes.get(1).getFormattedPlace());
    assertEquals(1, athletes.get(0).getPlacesShared());
    assertEquals("Athlete 2 surname", athletes.get(2).getLastName());
    assertEquals("4", athletes.get(3).getFormattedPlace());
  }
  
  @Test
  public void checkSumEventPoints() {
    assertEquals(12779, calc.sumEventPoints(athletes.get(0).getResults()));
    assertEquals(10223, calc.sumEventPoints(athletes.get(1).getResults()));
    assertEquals(12779, calc.sumEventPoints(athletes.get(2).getResults()));
    assertEquals(9329, calc.sumEventPoints(athletes.get(3).getResults()));
  }
  
  private List<Athlete> generateAthleteList() {
    List<Athlete> athletes = new LinkedList<Athlete>();
    
    Athlete a1 = new Athlete().setFirstName("Athlete 1 name").setLastName("Athlete 1 surname"); //12779 points
    a1.getResults()[0] = new DecathlonEventResult().setResult(12.61).setEvent(DecathlonEvent.getEventById(1));
    a1.getResults()[1] = new DecathlonEventResult().setResult(5.00).setEvent(DecathlonEvent.getEventById(2));
    a1.getResults()[2] = new DecathlonEventResult().setResult(9.22).setEvent(DecathlonEvent.getEventById(3));
    a1.getResults()[3] = new DecathlonEventResult().setResult(1.50).setEvent(DecathlonEvent.getEventById(4));
    a1.getResults()[4] = new DecathlonEventResult().setResult(60.39).setEvent(DecathlonEvent.getEventById(5));
    a1.getResults()[5] = new DecathlonEventResult().setResult(16.43).setEvent(DecathlonEvent.getEventById(6));
    a1.getResults()[6] = new DecathlonEventResult().setResult(21.60).setEvent(DecathlonEvent.getEventById(7));
    a1.getResults()[7] = new DecathlonEventResult().setResult(2.60).setEvent(DecathlonEvent.getEventById(8));
    a1.getResults()[8] = new DecathlonEventResult().setResult(35.81).setEvent(DecathlonEvent.getEventById(9));
    a1.getResults()[9] = new DecathlonEventResult().setResult(325.72).setEvent(DecathlonEvent.getEventById(10));
    
    Athlete a2 = new Athlete().setFirstName("Athlete 2 name").setLastName("Athlete 2 surname"); // 10223 points
    a2.getResults()[0] = new DecathlonEventResult().setResult(13.04).setEvent(DecathlonEvent.getEventById(1));
    a2.getResults()[1] = new DecathlonEventResult().setResult(4.53).setEvent(DecathlonEvent.getEventById(2));
    a2.getResults()[2] = new DecathlonEventResult().setResult(7.79).setEvent(DecathlonEvent.getEventById(3));
    a2.getResults()[3] = new DecathlonEventResult().setResult(1.55).setEvent(DecathlonEvent.getEventById(4));
    a2.getResults()[4] = new DecathlonEventResult().setResult(64.72).setEvent(DecathlonEvent.getEventById(5));
    a2.getResults()[5] = new DecathlonEventResult().setResult(18.74).setEvent(DecathlonEvent.getEventById(6));
    a2.getResults()[6] = new DecathlonEventResult().setResult(24.20).setEvent(DecathlonEvent.getEventById(7));
    a2.getResults()[7] = new DecathlonEventResult().setResult(2.40).setEvent(DecathlonEvent.getEventById(8));
    a2.getResults()[8] = new DecathlonEventResult().setResult(28.20).setEvent(DecathlonEvent.getEventById(9));
    a2.getResults()[9] = new DecathlonEventResult().setResult(410.76).setEvent(DecathlonEvent.getEventById(10));
    
    Athlete a3 = new Athlete().setFirstName("Athlete 3 name").setLastName("Athlete 3 surname"); //12779 points
    a3.getResults()[0] = new DecathlonEventResult().setResult(12.61).setEvent(DecathlonEvent.getEventById(1));
    a3.getResults()[1] = new DecathlonEventResult().setResult(5.00).setEvent(DecathlonEvent.getEventById(2));
    a3.getResults()[2] = new DecathlonEventResult().setResult(9.22).setEvent(DecathlonEvent.getEventById(3));
    a3.getResults()[3] = new DecathlonEventResult().setResult(1.50).setEvent(DecathlonEvent.getEventById(4));
    a3.getResults()[4] = new DecathlonEventResult().setResult(60.39).setEvent(DecathlonEvent.getEventById(5));
    a3.getResults()[5] = new DecathlonEventResult().setResult(16.43).setEvent(DecathlonEvent.getEventById(6));
    a3.getResults()[6] = new DecathlonEventResult().setResult(21.60).setEvent(DecathlonEvent.getEventById(7));
    a3.getResults()[7] = new DecathlonEventResult().setResult(2.60).setEvent(DecathlonEvent.getEventById(8));
    a3.getResults()[8] = new DecathlonEventResult().setResult(35.81).setEvent(DecathlonEvent.getEventById(9));
    a3.getResults()[9] = new DecathlonEventResult().setResult(325.72).setEvent(DecathlonEvent.getEventById(10));
    
    Athlete a4 = new Athlete().setFirstName("Athlete 4 name").setLastName("Athlete 4 surname"); // 9329 points
    a4.getResults()[0] = new DecathlonEventResult().setResult(13.43).setEvent(DecathlonEvent.getEventById(1));
    a4.getResults()[1] = new DecathlonEventResult().setResult(4.35).setEvent(DecathlonEvent.getEventById(2));
    a4.getResults()[2] = new DecathlonEventResult().setResult(8.64).setEvent(DecathlonEvent.getEventById(3));
    a4.getResults()[3] = new DecathlonEventResult().setResult(1.50).setEvent(DecathlonEvent.getEventById(4));
    a4.getResults()[4] = new DecathlonEventResult().setResult(66.06).setEvent(DecathlonEvent.getEventById(5));
    a4.getResults()[5] = new DecathlonEventResult().setResult(19.05).setEvent(DecathlonEvent.getEventById(6));
    a4.getResults()[6] = new DecathlonEventResult().setResult(24.89).setEvent(DecathlonEvent.getEventById(7));
    a4.getResults()[7] = new DecathlonEventResult().setResult(2.20).setEvent(DecathlonEvent.getEventById(8));
    a4.getResults()[8] = new DecathlonEventResult().setResult(33.48).setEvent(DecathlonEvent.getEventById(9));
    a4.getResults()[9] = new DecathlonEventResult().setResult(411.01).setEvent(DecathlonEvent.getEventById(10));
    
    athletes.add(a1); athletes.add(a2); athletes.add(a3); athletes.add(a4);
    
    return athletes;
  }
  
}
