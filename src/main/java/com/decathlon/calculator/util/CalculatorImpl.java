package com.decathlon.calculator.util;

import java.util.List;
import com.decathlon.calculator.domain.Athlete;
import com.decathlon.calculator.domain.DecathlonEventResult;
import com.decathlon.calculator.enums.EventType;

public class CalculatorImpl implements Calculator {

  @Override
  public int calculateEventPoints(DecathlonEventResult result) {
    double res = 0;
    if (result.getEvent().getType().equals(EventType.FIELD)) {
      res = Math.pow((result.getEvent().getA()*(result.getResult()-result.getEvent().getB())), result.getEvent().getC());
    }
    if (result.getEvent().getType().equals(EventType.TRACK)) {
      res = Math.pow((result.getEvent().getA()*(result.getEvent().getB()-result.getResult())), result.getEvent().getC());
    }
    return (int) Math.floor(res);
  }

  @Override
  public List<Athlete> setSortedAthletesPlaces(List<Athlete> athletes) {
    int currentPlace = 0;
    int i = 0;

    for (i = 0; i < athletes.size()-1; i++) {
      currentPlace++;
      int j = i+1;
      int placesShared = 0;

      while (athletes.get(i).getPoints() == athletes.get(j).getPoints()) {
        placesShared++;
        j++;
      }
      for (int k = i; k < j; k++) {
        athletes.get(k).setPlace(currentPlace);
        athletes.get(k).setPlacesShared(placesShared);
      }
      
      currentPlace = currentPlace + placesShared;
      
      i = j-1; // do not iterate over already checked athletes
    }
    //check last athlete in the list
    if (athletes.get(i).getPoints() == athletes.get(i-1).getPoints()) {
      athletes.get(i).setPlace(athletes.get(i-1).getPlace());
      athletes.get(i).setPlacesShared(athletes.get(i-1).getPlacesShared());
    } else {
      athletes.get(i).setPlace(currentPlace+1);
      athletes.get(i).setPlacesShared(0);
    }
    return athletes;
  }

  @Override
  public int sumEventPoints(DecathlonEventResult[] results) {
    int sum = 0;
    for (DecathlonEventResult result : results) {
      sum += calculateEventPoints(result);
    }
    return sum;
  }

}
