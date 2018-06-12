package com.decathlon.calculator.util;

import java.util.List;
import com.decathlon.calculator.domain.Athlete;
import com.decathlon.calculator.domain.DecathlonEventResult;

public interface Calculator {

  int calculateEventPoints(DecathlonEventResult result);

  List<Athlete> setSortedAthletesPlaces(List<Athlete> athletes);
  
  int sumEventPoints(DecathlonEventResult[] results);
}
