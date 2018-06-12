package com.decathlon.calculator.reader;

import java.util.List;
import com.decathlon.calculator.domain.Athlete;
import com.decathlon.calculator.util.Calculator;

public interface InputReader {

  List<Athlete> readFromFile(String filePath);
  
  Athlete parseAthleteResults(String line);
  
  public Calculator getCalculator();
}
