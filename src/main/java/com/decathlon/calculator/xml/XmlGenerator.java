package com.decathlon.calculator.xml;

import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.decathlon.calculator.domain.Athlete;

public class XmlGenerator {

  public void generateAthletesXml(String filepath, List<Athlete> athletes) 
  throws ParserConfigurationException, TransformerException {
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    
    //root element
    Document doc = docBuilder.newDocument();
    Element rootElement = doc.createElement("athletes");
    doc.appendChild(rootElement);
    
    for (int i = 0; i < athletes.size(); i++) {
      //Athlete elements
      Element athlete = doc.createElement("athlete");
      rootElement.appendChild(athlete);
      
      Attr attr = doc.createAttribute("id");
      attr.setValue(new Integer(i+1).toString());
      athlete.setAttributeNode(attr);
      
      Element firstname = doc.createElement("firstname");
      firstname.appendChild(doc.createTextNode(athletes.get(i).getFirstName()));
      athlete.appendChild(firstname);
      
      Element lastname = doc.createElement("lastname");
      lastname.appendChild(doc.createTextNode(athletes.get(i).getLastName()));
      athlete.appendChild(lastname);
      
      Element running_100_meters = doc.createElement(athletes.get(i).getResults()[0].getEvent().getXmlTag());
      running_100_meters.appendChild(doc.createTextNode(athletes.get(i).getResults()[0].getUnformattedResult()));
      athlete.appendChild(running_100_meters);
      
      Element long_jump = doc.createElement(athletes.get(i).getResults()[1].getEvent().getXmlTag());
      long_jump.appendChild(doc.createTextNode(athletes.get(i).getResults()[1].getUnformattedResult()));
      athlete.appendChild(long_jump);
      
      Element shot_put = doc.createElement(athletes.get(i).getResults()[2].getEvent().getXmlTag());
      shot_put.appendChild(doc.createTextNode(athletes.get(i).getResults()[2].getUnformattedResult()));
      athlete.appendChild(shot_put);
      
      Element high_jump = doc.createElement(athletes.get(i).getResults()[3].getEvent().getXmlTag());
      high_jump.appendChild(doc.createTextNode(athletes.get(i).getResults()[3].getUnformattedResult()));
      athlete.appendChild(high_jump);
      
      Element running_400_meters = doc.createElement(athletes.get(i).getResults()[4].getEvent().getXmlTag());
      running_400_meters.appendChild(doc.createTextNode(athletes.get(i).getResults()[4].getUnformattedResult()));
      athlete.appendChild(running_400_meters);
      
      Element running_110_meters_hurdles = doc.createElement(athletes.get(i).getResults()[5].getEvent().getXmlTag());
      running_110_meters_hurdles.appendChild(doc.createTextNode(athletes.get(i).getResults()[5].getUnformattedResult()));
      athlete.appendChild(running_110_meters_hurdles);
      
      Element discus_throw = doc.createElement(athletes.get(i).getResults()[6].getEvent().getXmlTag());
      discus_throw.appendChild(doc.createTextNode(athletes.get(i).getResults()[6].getUnformattedResult()));
      athlete.appendChild(discus_throw);
      
      Element pole_vault = doc.createElement(athletes.get(i).getResults()[7].getEvent().getXmlTag());
      pole_vault.appendChild(doc.createTextNode(athletes.get(i).getResults()[7].getUnformattedResult()));
      athlete.appendChild(pole_vault);
      
      Element javelin_throw = doc.createElement(athletes.get(i).getResults()[8].getEvent().getXmlTag());
      javelin_throw.appendChild(doc.createTextNode(athletes.get(i).getResults()[8].getUnformattedResult()));
      athlete.appendChild(javelin_throw);
      
      Element running_1500_meters = doc.createElement(athletes.get(i).getResults()[9].getEvent().getXmlTag());
      running_1500_meters.appendChild(doc.createTextNode(athletes.get(i).getResults()[9].getUnformattedResult()));
      athlete.appendChild(running_1500_meters);
      
      Element points = doc.createElement("points");
      points.appendChild(doc.createTextNode(new Integer(athletes.get(i).getPoints()).toString()));
      athlete.appendChild(points);
      
      Element place = doc.createElement("place");
      place.appendChild(doc.createTextNode(athletes.get(i).getFormattedPlace()));
      athlete.appendChild(place);
    }
    
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(new File(filepath));
    
    transformer.transform(source, result);
  }

}
