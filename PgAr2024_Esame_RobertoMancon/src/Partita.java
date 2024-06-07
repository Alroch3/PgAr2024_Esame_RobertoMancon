import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Partita {
    private static final String[] RUOLI_GIOCATORI = {"Fuorilegge", "Rinnegato", "Fuorilegge", "Vice", "Fuorilegge", "Vice"};            //non è presente lo sceriffo perchè è sempre inserito come primo

    private ArrayList<String> ruoliGiocatori = new ArrayList<>();

    private int numGiocatori;
    private LinkedList<Giocatore> listaGiocatori = new LinkedList<>();
    private String saloon[][] = new String[6][6];


    public void gioco(){
        //Display.mostraIntroduzione();
        numGiocatori = InterazioneUtente.scegliNumGiocatori();
        inizializzaRuoliGiocatore();
        
        //Display.mostraSaloon(saloon);
        aggiungiGiocatori();
        
    }

    private void inizializzaRuoliGiocatore(){
        for(int i = 0; i < numGiocatori -1; ++i){
            ruoliGiocatori.add(RUOLI_GIOCATORI[i]);
        }
        Collections.shuffle(ruoliGiocatori);
        ruoliGiocatori.addFirst("Sceriffo");
        for(int i = 0; i < ruoliGiocatori.size(); ++i){
            System.out.println(ruoliGiocatori.get(i));
        }
    }

    private void aggiungiGiocatori(){
        Xml.leggiPersonaggi(numGiocatori, listaGiocatori);          //assegno i personaggi in ordine come nell'XML 
        Collections.shuffle(listaGiocatori);                        //mischio per ottenere un ordine casuale

        for(int i = 0; i < numGiocatori; ++i){
            if(i == 0){
                listaGiocatori.get(i).aggiornaPF(+1);               //lo sceriffo ha pf sempre +1
            }
            listaGiocatori.get(i).setRuolo(ruoliGiocatori.get(i));  //assegno il ruolo: Sceriffo, ecc..
            System.out.println(listaGiocatori.get(i).toString());           //SOLO DEBUG
        }
    }

    private void muoviGiocatore(){

    }

    
}
