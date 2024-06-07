import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import it.kibo.fp.lib.InputData;
import it.kibo.fp.lib.RandomDraws;

public class Partita {
    private static final String[] RUOLI_GIOCATORI = {"Fuorilegge", "Rinnegato", "Fuorilegge", "Vice", "Fuorilegge", "Vice"};            //non è presente lo sceriffo perchè è sempre inserito come primo

    private static ArrayList<String> ruoliGiocatori = new ArrayList<>();

    private static int numGiocatori;
    private static LinkedList<Giocatore> listaGiocatori = new LinkedList<>();
    private static String saloon[][] = {
        {"","","","","",""},
        {"","OST","","","",""},
        {"","","","","","OST"},
        {"","","","","","OST"},
        {"","","OST","","",""},
        {"","","","","",""},
    };


    public static void gioco(){
        //Display.mostraIntroduzione();
        numGiocatori = InterazioneUtente.scegliNumGiocatori();
        inizializzaRuoliGiocatore();
        
        //Display.mostraSaloon(saloon);
        
        Mazzo mazzo = new Mazzo();
        mazzo.creaMazzo();
        mazzo.mescolaMazzo();

        aggiungiGiocatori(mazzo);
        
        addGiocatoriSaloon();
        Display.mostraSaloon(saloon);
        sceltaMenu(listaGiocatori.get(0));

        
    }

    private static void sceltaMenu(Giocatore g){
        int scelta = InterazioneUtente.scegliDaMenu();
        switch (scelta) {
            case 1:
                int numPassi = InterazioneUtente.ottieniNumPassi(g.getPuntiFerita());
                for(int i = 0; i < numPassi; ++i){
                    muoviGiocatoreInSaloon(g.getPuntiFerita(), g.getNome(),listaGiocatori.indexOf(g));
                    Display.mostraSaloon(saloon);
                }
                break;
            case 2:
                System.out.println(g.toStringCartePossedute());
                break;
            case 3:
                System.out.println(g.toStringCarteEquip());
                break;
            case 4:
                g.equipaggiaCarta();
                break;
            case 5:
                g.giocaCarta();
                break;
            default:
                break;
        }
    }

    // TRATTAMENTO GIOCATORI
    private static void inizializzaRuoliGiocatore(){
        for(int i = 0; i < numGiocatori -1; ++i){
            ruoliGiocatori.add(RUOLI_GIOCATORI[i]);
        }
        Collections.shuffle(ruoliGiocatori);
        ruoliGiocatori.addFirst("Sceriffo");
    }

    private static void aggiungiGiocatori(Mazzo mazzoPrincipale){
        Xml.leggiPersonaggi(numGiocatori, listaGiocatori);          //assegno i personaggi in ordine come nell'XML 
        Collections.shuffle(listaGiocatori);                        //mischio per ottenere un ordine casuale

        for(int i = 0; i < numGiocatori; ++i){
            if(i == 0){
                listaGiocatori.get(i).aggiornaPF(+1);               //lo sceriffo ha pf sempre +1
                System.out.println(listaGiocatori.get(0).getNome() + " sei lo Sceriffo");
            }
            listaGiocatori.get(i).setRuolo(ruoliGiocatori.get(i));  //assegno il ruolo: Sceriffo, ecc..
            pescaggioCarta(listaGiocatori.get(i), mazzoPrincipale, 2);
        }
    }

    //PESCAGGIO CARTE
    private static void pescaggioCarta(Giocatore g, Mazzo mazzoPrincipale, int numCarteDaPescare){
        for(int i = 0; i < numCarteDaPescare; ++i){
            Display.msgMostraCarteDaPescare(g.getNome(), numCarteDaPescare - i);
            char scelta = InterazioneUtente.msgPescaCarta(g.getNome());
            if(scelta == 'p'){
                g.aggiungiCarte(mazzoPrincipale);
            }
        }
    }

    // INSERIMENTO GIOCATORI NELLA MATRICE
    private static void addGiocatoriSaloon(){
        for(int i = 0; i < numGiocatori; ++i){
            int rigaCas, colonnaCas;
            do {
                rigaCas = RandomDraws.drawInteger(0, saloon.length - 1);           //saloon.length restituisce il numero di righe di saloon
                colonnaCas = RandomDraws.drawInteger(0, saloon[0].length - 1);           //saloon.length restituisce il numero di colonne di saloon
            } while (!saloon[rigaCas][colonnaCas].equals(""));

            saloon[rigaCas][colonnaCas] = String.format("G%d", i+1);
        }
    }

    //MOVIMENTO GIOCATORE NELLA MATRICE
    private static void muoviGiocatoreInSaloon(int numPassi, String nomeGiocatore, int numGiocatore){
        System.out.printf("Giocatore %s (NON E' CONSENTITO ANDARE IN DIAGONALE)\n", nomeGiocatore, numPassi);          //DA METTERE IN DISPLAY
        int[] posGioc = posizioneGiocatore(numGiocatore);
        boolean spostRiuscito = false;
        while(!spostRiuscito){
            char lettera = InterazioneUtente.inserisciDirezioneMovimento();
            switch (lettera) {
                case 'w':
                    spostRiuscito = spostaElemento(saloon, posGioc[0], posGioc[1], posGioc[0] - 1, posGioc[1]);
                    break;
                case 'a':
                    spostRiuscito = spostaElemento(saloon, posGioc[0], posGioc[1], posGioc[0], posGioc[1] - 1);
                    break;
                case 's':
                    spostRiuscito = spostaElemento(saloon, posGioc[0], posGioc[1], posGioc[0] + 1, posGioc[1]);
                    break;
                case 'd':
                    spostRiuscito = spostaElemento(saloon, posGioc[0], posGioc[1], posGioc[0], posGioc[1] + 1);
                    break;
                default:
                    break;
            }
            if(!spostRiuscito){
                System.out.println("SPOSTAMENTO NON RIUSCITO, RIPROVA");
            }
        }
    }

    public static int[] posizioneGiocatore (int numGiocatore){
        for(int i = 0; i < saloon.length; ++i){
            for(int j = 0; j < saloon[0].length; ++j){
                if(saloon[i][j].equals(String.format("G" + (numGiocatore+1)))){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static boolean spostaElemento(String[][] saloon, int rigaOrigine, int colonnaOrigine, int rigaDestinazione, int colonnaDestinazione) {
        if (rigaOrigine >= 0 && rigaOrigine < saloon.length && colonnaOrigine >= 0 && colonnaOrigine < saloon[rigaOrigine].length &&
            rigaDestinazione >= 0 && rigaDestinazione < saloon.length && colonnaDestinazione >= 0 && colonnaDestinazione < saloon[rigaDestinazione].length) {

            if (saloon[rigaDestinazione][colonnaDestinazione].equals("")) {

                saloon[rigaDestinazione][colonnaDestinazione] = saloon[rigaOrigine][colonnaOrigine];
                saloon[rigaOrigine][colonnaOrigine] = "";
                return true;                                        // Spostamento riuscito
            } else {
                return false;                                       // Spostamento fallito
            }
        } else {
            System.out.println("ATTENZIONE STAI USCENDO DALLA MATRICE");
            return false; 
        }
    }

    public static void calcolaDistanza(int numAttaccante, int numAttaccato) {
        
    }    
}
