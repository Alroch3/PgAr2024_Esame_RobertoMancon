import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;


public class Xml {
    public static void leggiPersonaggi(int numGiocatori, LinkedList<Giocatore> listaGiocatori) {
        final String filename = "src\\listaCarte.xml";
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(filename))) {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(filename, reader);

            while (numGiocatori != 0) {
                int event = xmlr.next();

                if (event == XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("personaggio")) {       //va avanti finche non trova il tag di apertura con scritto personaggio
                    int PF = Integer.parseInt(xmlr.getAttributeValue(0));
                    xmlr.next();
                    xmlr.next();
                    xmlr.next();
                    String nome = xmlr.getText();
                    xmlr.next();
                    xmlr.next();
                    xmlr.next();
                    xmlr.next();
                    String descrizione = xmlr.getText();
                    Giocatore g = new Giocatore(nome, null, PF, descrizione);
                    listaGiocatori.add(g);
                    numGiocatori--;
                }
            }

        } catch (FactoryConfigurationError | XMLStreamException | IOException e) {
            System.out.println("Error in initializing the reader:");
            System.out.println(e.getMessage());
        }
    }
}
