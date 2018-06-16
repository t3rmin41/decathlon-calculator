package com.decathlon.calculator.app;

import java.util.Collections;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import com.decathlon.calculator.domain.Athlete;
import com.decathlon.calculator.domain.AthleteSort;
import com.decathlon.calculator.reader.InputReader;
import com.decathlon.calculator.reader.InputReaderImpl;
import com.decathlon.calculator.xml.XmlGenerator;

public class Main {

  public static void main(String[] args) {

    if (0 == args.length) {
      System.out.println("Please provide input and output file paths");
      System.exit(-1);
    } else if (1 == args.length) {
      System.out.println("Please provide output file path");
      System.exit(-1);
    }
    String inputFile = args[0];
    String outputFile = args[1];

    InputReader reader = new InputReaderImpl();

    XmlGenerator xmlGenerator = new XmlGenerator();

    List<Athlete> athletes = reader.readFromFile(inputFile);

    Collections.sort(athletes, AthleteSort.SORT_POINTS_DESCENDING);

    reader.getCalculator().setSortedAthletesPlaces(athletes);

    try {
      xmlGenerator.generateAthletesXml(outputFile, athletes);
    } catch (ParserConfigurationException | TransformerException e) {
      e.printStackTrace();
    } finally {
      System.out.println("XML output file generated to "+outputFile+" from input file "+inputFile);
    }
  }
}
