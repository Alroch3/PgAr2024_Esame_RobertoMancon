import it.kibo.fp.lib.InputData;

public class InterazioneUtente {


    private static final String MSG_INSERISCI_NUM_GIOCATORI = "Inserisci il numero di giocatori: ";

    public static int scegliNumGiocatori(){
        return InputData.readIntegerBetween(MSG_INSERISCI_NUM_GIOCATORI, 4, 7);
    }

    public static String inserisciNomeGiocatore(int numGiocatore) {
        return InputData.readNonEmptyString(String.format("Inserisci il nome del giocatore %d: ", numGiocatore), false);
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
