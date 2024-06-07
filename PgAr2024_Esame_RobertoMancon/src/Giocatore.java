import java.util.ArrayList;

public class Giocatore {
    private String nome;
    private String ruolo;       //valutare se fare un ENUM
    private int puntiFerita;

    private ArrayList<Carta> carteEquip = new ArrayList<>();
    private ArrayList<Carta> carteGiocaEScarta = new ArrayList<>();

    public Giocatore(String nome, String ruolo, int puntiFerita) {
        this.nome = nome;
        this.ruolo = ruolo;
        this.puntiFerita = puntiFerita;
    }

    public void aggiornaPF(){

    }

    public void scartaCarta(){

    }

    public String getRuolo() {
        return ruolo;
    }

}
