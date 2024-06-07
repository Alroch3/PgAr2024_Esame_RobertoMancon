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
    private static final String FILENAME = "src\\listaCarte.xml";
    private static XMLInputFactory xmlif = null;
    private static XMLStreamReader xmlr = null;
    public static void leggiPersonaggi(int numGiocatori, LinkedList<Giocatore> listaGiocatori) {
        

        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(FILENAME))) {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(FILENAME, reader);

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

    public static void creaMazzo(LinkedList<Carta> mazzo){

        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(FILENAME))) {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(FILENAME, reader);

            while (xmlr.hasNext()) {
                int event = xmlr.next();
                //sezione armi
                if (event == XMLStreamConstants.START_ELEMENT && (xmlr.getLocalName().equals("arma") || xmlr.getLocalName().equals("carta"))) {  
                    //EQUIPAGGIABILE (SE C'E')
                    boolean equipaggiabile = false;
                    if(xmlr.getAttributeValue(0) != null){
                        equipaggiabile = Boolean.parseBoolean(xmlr.getAttributeValue(0));
                    }
                    //NOME
                    while(!(xmlr.getEventType() == XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("nome"))){
                        xmlr.next();
                    }
                    xmlr.next();
                    String nome = xmlr.getText();
                    //DISTANZA (PER LE ARMI) E DESCRIZIONE(PER LE ALTRE CARTE)
                    String distanza = null;
                    String descrizione = null;
                    while(!(xmlr.getEventType() == XMLStreamConstants.START_ELEMENT && (xmlr.getLocalName().equals("distanza") || xmlr.getLocalName().equals("descrizione")))){
                        xmlr.next();
                    }     
                    if(xmlr.getLocalName().equals("distanza")){
                        xmlr.next();
                        distanza = xmlr.getText();
                    }else{
                        xmlr.next();
                        descrizione = xmlr.getText();
                    }
                    //COPIE
                    while(!(xmlr.getEventType() == XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("copie"))){
                        xmlr.next();
                    }
                    int ripetizioni = Integer.parseInt(xmlr.getAttributeValue(0));
                    for(int i = 0; i < ripetizioni; ++i){
                        while(!(xmlr.getEventType() == XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("valore"))){
                            xmlr.next();
                        }
                        xmlr.next();
                        String valore = xmlr.getText();
                        while(!(xmlr.getEventType() == XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("seme"))){
                            xmlr.next();
                        }
                        xmlr.next();
                        String seme = xmlr.getText();
                        Carta c;
                        if(!(distanza == null)){
                            c = new Arma(valore, seme, equipaggiabile, nome, descrizione, Integer.parseInt(distanza));
                        }else{
                            c = new Carta(valore, seme, equipaggiabile, nome, descrizione);
                        }
                        mazzo.add(c);
                    }
                }
            }

        } catch (FactoryConfigurationError | XMLStreamException | IOException e) {
            System.out.println("Error in initializing the reader:");
            System.out.println(e.getMessage());
        }
    }
}
