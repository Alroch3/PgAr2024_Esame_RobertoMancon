import java.util.ArrayList;

public class Giocatore {
    private String nome;
    private String ruolo;       
    private int puntiFerita;
    private String descrizione;

    private ArrayList<Carta> carteEquip = new ArrayList<>();
    private ArrayList<Carta> carteGiocaEScarta = new ArrayList<>();

    public Giocatore(String nome, String ruolo, int puntiFerita, String descrizione) {
        this.nome = nome;
        this.ruolo = ruolo;
        this.puntiFerita = puntiFerita;
        this.descrizione = descrizione;
    }

    public void aggiornaPF(int quanto){
        puntiFerita = puntiFerita + quanto;
    }

    public void scartaCarta(){

    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - Ruolo: " + ruolo + " - PF: " + puntiFerita + " - Descrizione: " + descrizione; 
    }

}
