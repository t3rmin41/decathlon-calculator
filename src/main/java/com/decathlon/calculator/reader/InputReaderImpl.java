package com.decathlon.calculator.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import com.decathlon.calculator.domain.Athlete;
import com.decathlon.calculator.domain.DecathlonEventResult;
import com.decathlon.calculator.enums.DecathlonEvent;
import com.decathlon.calculator.util.Calculator;
import com.decathlon.calculator.util.CalculatorImpl;

public class InputReaderImpl implements InputReader {

  private final Calculator calc = new CalculatorImpl();
  
  @Override
  public List<Athlete> readFromFile(String filePath) {
    List<Athlete> athletes = new LinkedList<Athlete>();
    BufferedReader bufferedReader = null;
    try {
      File file = new File(filePath);
      FileReader fileReader = new FileReader(file);
      bufferedReader = new BufferedReader(fileReader);
      
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        athletes.add(parseAthleteResults(line));
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        bufferedReader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return athletes;
  }

  @Override
  public Athlete parseAthleteResults(String line) {
    Athlete athlete = new Athlete();
    String[] stringArr = line.split(";");
    String[] nameSurname = stringArr[0].split(" ");
    athlete.setFirstName(nameSurname[0]).setLastName(nameSurname[1]);
    int i = 1;
    for (i = 1; i < stringArr.length-1; i++) {
      athlete.getResults()[i-1] = new DecathlonEventResult()
                                    .setEvent(DecathlonEvent.getEventById(i))
                                    .setUnformattedResult(stringArr[i])
                                    .setResult(new Double(stringArr[i]));
    }
    String[] lastResult = stringArr[i].split("\\.", 2);
    athlete.getResults()[i-1] = new DecathlonEventResult()
                                  .setEvent(DecathlonEvent.getEventById(i))
                                  .setUnformattedResult(stringArr[i])
                                  .setResult((new Double(lastResult[0])*60)+new Double(lastResult[1]));
    athlete.setPoints(calc.sumEventPoints(athlete.getResults()));
    return athlete;
  }
  
  @Override
  public Calculator getCalculator() {
    return this.calc;
  }
  
}
