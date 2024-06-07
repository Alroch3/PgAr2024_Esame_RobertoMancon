public class Carta {
    private String valore;
    private String seme;
    private boolean equipaggiabile;
    private String nomeCarta;
    private String descrizione;

    public Carta(String valore, String seme, boolean equipaggiabile, String nomeCarta, String descrizione) {
        this.valore = valore;
        this.seme = seme;
        this.equipaggiabile = equipaggiabile;
        this.nomeCarta = nomeCarta;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Valore: " + valore + " - Seme: " + seme + " - equipaggiabile: " + equipaggiabile + " - Nome Carta: " + nomeCarta + " - Descrizione: " + descrizione; 
    }

    
}
