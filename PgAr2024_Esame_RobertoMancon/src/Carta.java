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

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public String getSeme() {
        return seme;
    }

    public void setSeme(String seme) {
        this.seme = seme;
    }

    public boolean isEquipaggiabile() {
        return equipaggiabile;
    }

    public void setEquipaggiabile(boolean equipaggiabile) {
        this.equipaggiabile = equipaggiabile;
    }

    public String getNomeCarta() {
        return nomeCarta;
    }

    public void setNomeCarta(String nomeCarta) {
        this.nomeCarta = nomeCarta;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n-------------------------------------------\n");
        buffer.append("\t" + nomeCarta.toUpperCase() + "\n");
        buffer.append(" " + descrizione + "\n");
        buffer.append("" +  valore + " di " + seme + "\n");
        buffer.append("---------------------------------------------\n");
        return buffer.toString(); 
    }

    
}
