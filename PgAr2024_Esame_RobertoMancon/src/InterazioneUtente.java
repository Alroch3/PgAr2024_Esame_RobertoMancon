import it.kibo.fp.lib.InputData;
import it.kibo.fp.lib.Menu;

public class InterazioneUtente {


    private static final String MSG_INSERISCI_NUM_GIOCATORI = "Inserisci il numero di giocatori: ";
    private static final String LETTERE_PER_MUOVERSI = "wasd";
    private static final String[] SELEZIONE_MENU = {
        "MUOVITI",
        "VISUALIZZA LE TUE CARTE",
        "VISUALIZZA LE CARTE EQUIPAGGIATE",
        "EQUIPAGGIA UNA CARTA",
        "GIOCA UNA CARTA"
    };

    public static int scegliNumGiocatori(){
        return InputData.readIntegerBetween(MSG_INSERISCI_NUM_GIOCATORI, 4, 7);
    }

    public static String inserisciNomeGiocatore(int numGiocatore) {
        return InputData.readNonEmptyString(String.format("Inserisci il nome del giocatore %d: ", numGiocatore), false);
    }

    public static char inserisciDirezioneMovimento() {
        return InputData.readChar("Inserisci il tasto per muoverti (w - a - s - d): ", LETTERE_PER_MUOVERSI);
    }

    public static char msgPescaCarta(String nome) {
        return InputData.readChar(String.format("Giocatore %s premi p per pescare una carta: ", nome), "pP");
    }

    public static int scegliDaMenu(){
        Menu menu = new Menu("Scegli cosa vuoi fare", SELEZIONE_MENU, true, true, true);
        return menu.choose();
    }

    public static int qualeCartaVuoiEquipaggiare(int numCartePossedute) {
        return InputData.readIntegerBetween("Quale carta vuoi equipaggiare?", 1, numCartePossedute);
    }

    public static int ottieniNumPassi(int maxPassi) {
        return InputData.readIntegerBetween("Quanti passi vuoi fare? ", 0, maxPassi);
    }

    public static int qualeCartaVuoiScartare(int numCartePossedute) {
        return InputData.readIntegerBetween("Quale carta vuoi scartare? ", 1, numCartePossedute);
    }

    public static int sceltaCartaDaGiocare(int numCartePossedute) {
        return InputData.readIntegerBetween("Quale carta vuoi giocare? ", 1, numCartePossedute);
    }

    /*
    private static final String OPZIONI[] = {
        "Mappa da 5",
        "Mappa da 12",
        "Mappa da 50",
        "Mappa da 200",
        "Mappa da 2000",
        "Mappa da 10000"
};

public static String scegliMappa() {

    Menu menuMappe = new Menu("Scegli la mappa", OPZIONI, true, true, true);

    int scelta = menuMappe.choose();

    switch (scelta) {
        case 1:

            return MAPPA_5;

        case 2:

            return MAPPA_12;

        case 3:

            return MAPPA_50;

        case 4:

            return MAPPA_200;

        case 5:

            return MAPPA_2000;

        case 6:

            return MAPPA_10000;

        default:

            return "exit";

        }

    }
    */  


}
