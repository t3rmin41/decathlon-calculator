package com.decathlon.calculator.reader.test;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import com.decathlon.calculator.domain.Athlete;
import com.decathlon.calculator.reader.InputReader;
import com.decathlon.calculator.reader.InputReaderImpl;

public class InputReaderTest {

  private final String athleteLine1 = "Siim Susi;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72";
  private final String athleteLine2 = "Beata Kana;13.04;4.53;7.79;1.55;64.72;18.74;24.20;2.40;28.20;6.50.76";
  private final String athleteLine3 = "Jaana Lind;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75 ";
  private final String athleteLine4 = "Anti Loop;13.43;4.35;8.64;1.50;66.06;19.05;24.89;2.20;33.48;6.51.01 ";
  private final String athleteLine5 = "Marie Peinado;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;7.22.75 ";
  
  private final String testFilePath = "src/test/resources/Decathlon_input_test.txt";
  
  private InputReader reader = new InputReaderImpl();
  
  @Test
  public void checkInputReadingFromFile() {
    List<Athlete> athletes = reader.readFromFile(testFilePath);
    assertEquals("Anti", athletes.get(6).getFirstName());
    assertEquals(325.72, athletes.get(0).getResults()[9].getResult(), 0);
  }
  
  @Test
  public void checkAthleteParsing() {
    Athlete a1 = reader.parseAthleteResults(athleteLine1);
    Athlete a2 = reader.parseAthleteResults(athleteLine2);
    Athlete a3 = reader.parseAthleteResults(athleteLine3);
    Athlete a4 = reader.parseAthleteResults(athleteLine4);
    Athlete a5 = reader.parseAthleteResults(athleteLine5);
    
    assertEquals(9.22, a1.getResults()[2].getResult(), 0);
    assertEquals(18.74, a2.getResults()[5].getResult(), 0);
    assertEquals(13.75, a3.getResults()[0].getResult(), 0);
    assertEquals(411.01, a4.getResults()[9].getResult(), 0);
    assertEquals("Peinado", a5.getLastName());
  }
  
}
