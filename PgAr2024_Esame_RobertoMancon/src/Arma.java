public class Arma extends Carta{
    private int distanzaAttacco;

    public Arma(String valore, String seme, boolean equipaggiabile, String nomeCarta, String descrizione,
            int distanzaAttacco) {
        super(valore, seme, equipaggiabile, nomeCarta, descrizione);
        this.distanzaAttacco = distanzaAttacco;
    }

    @Override
    public String toString() {
        return super.toString() + " - Distanza attacco: " + distanzaAttacco;
    }
}
