package com.decathlon.calculator.enums.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.decathlon.calculator.enums.DecathlonEvent;

public class DecathlonEventTest {

  @Test
  public void checkDecathlonEventExtractionById() {
    DecathlonEvent longJump =  DecathlonEvent.LONG_JUMP;
    DecathlonEvent testEvent = DecathlonEvent.getEventById(2);
    assertEquals(longJump, testEvent);
  }
  
}
