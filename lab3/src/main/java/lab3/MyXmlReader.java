package lab3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class MyXmlReader implements Reader {

    @Override
    public ArrayList<ReactorType> read(File file) {
        ArrayList<ReactorType> reactorTypes = new ArrayList<>();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        ReactorType reactorType = null;

        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(file));
            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "class":
                            nextEvent = reader.nextEvent();
                            reactorType.setType(nextEvent.asCharacters().getData());
                            break;
                        case "burnup":
                            nextEvent = reader.nextEvent();
                            reactorType.setBurnup(Double.parseDouble(nextEvent.asCharacters().getData()));
                            break;
                        case "kpd":
                            nextEvent = reader.nextEvent();
                            reactorType.setKpd(Double.parseDouble(nextEvent.asCharacters().getData()));
                            break;
                        case "enrichment":
                            nextEvent = reader.nextEvent();
                            reactorType.setEnrichment(Double.parseDouble(nextEvent.asCharacters().getData()));
                            break;
                        case "termal_capacity":
                            nextEvent = reader.nextEvent();
                            reactorType.setThermalCapacity(Integer.parseInt(nextEvent.asCharacters().getData()));
                            break;
                        case "electrical_capacity":
                            nextEvent = reader.nextEvent();
                            reactorType.setElectricalCapacity(Double.parseDouble(nextEvent.asCharacters().getData()));
                            break;
                        case "life_time":
                            nextEvent = reader.nextEvent();
                            reactorType.setLifeTime(Integer.parseInt(nextEvent.asCharacters().getData()));
                            break;
                        case "first_load":
                            nextEvent = reader.nextEvent();
                            reactorType.setFirstLoad(Double.parseDouble(nextEvent.asCharacters().getData()));
                            break;
                        default:
                            nextEvent = reader.nextEvent();
                            reactorType = new ReactorType();
                            reactorType.setSource("From XML");
                            break;
                    }
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("first_load")) {
                        reactorTypes.add(reactorType);
                    }
                }
            }
            System.out.println("XML успешно прочитан");
        }catch(FileNotFoundException | XMLStreamException e){
            System.out.println("Ошибка");
        }
        return reactorTypes;
    }
}
