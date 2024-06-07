import java.util.ArrayList;

public class Giocatore {
    private String nome;
    private String ruolo;       
    private int puntiFerita;
    private String descrizione;
    private int forzaAttacco = 1;

    private ArrayList<Carta> carteEquip = new ArrayList<>();
    private ArrayList<Carta> cartePossedute = new ArrayList<>();

    public Giocatore(String nome, String ruolo, int puntiFerita, String descrizione) {
        this.nome = nome;
        this.ruolo = ruolo;
        this.puntiFerita = puntiFerita;
        this.descrizione = descrizione;
    }

    public void aggiornaPF(int quanto){
        puntiFerita = puntiFerita + quanto;
    }

    public void aggiungiCarte(Mazzo mazzoPrincipale){
        Carta carta = mazzoPrincipale.pescaCarta();
        cartePossedute.add(carta);
        System.out.println(carta.toString());
    }

    public boolean equipaggiaCarta(){
        System.out.println(toStringCartePossedute());
        int scelta = InterazioneUtente.qualeCartaVuoiEquipaggiare(cartePossedute.size());
        if(controlloSeEquipaggiabile(cartePossedute.get(scelta-1))){
            carteEquip.add(cartePossedute.get(scelta-1));
            if(cartePossedute.get(scelta-1) instanceof Arma){
                Arma a = (Arma)cartePossedute.get(scelta-1);
                forzaAttacco = a.getDistanzaAttacco();
            }
            Display.msgCartaEquipaggiata(cartePossedute.get(scelta-1).getNomeCarta());
            return true;
        }else{
            Display.msgNonPuoiEquipaggiare();
            return false;
        }
    }

    public boolean controlloSeEquipaggiabile(Carta carta){
        boolean equipaggiabile = true;
        for(Carta c : carteEquip){
            if(c.getNomeCarta().equals(carta.getNomeCarta())){
                equipaggiabile = false;
                break;
            }
            if(carta instanceof Arma && c instanceof Arma){
                equipaggiabile = false;
                break;
            }
        }
        return equipaggiabile;
    }

    public String toStringCartePossedute(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("CARTE POSSEDUTE: \n");
        for(Carta c : cartePossedute){
            buffer.append(c.toString() + "\n");
        }
        return buffer.toString();
    }
    
    public String toStringCarteEquip(){
        StringBuffer buffer = new StringBuffer();
        if(carteEquip.isEmpty()){
            return "NON HAI CARTE EQUIPAGGIATE!";
        }
        buffer.append("CARTE EQUIPAGGIATE: \n");
        for(Carta c : carteEquip){
            buffer.append(c.toString() + "\n");
        }
        return buffer.toString();
    }

    public void giocaCarta(){
        System.out.println(toStringCartePossedute());
        int scelta = InterazioneUtente.sceltaCartaDaGiocare(cartePossedute.size());
        switch (cartePossedute.get(scelta).getNomeCarta()) {
            case "BANG!":
                //Partita.calcolaDistanza();
                break;
        
            default:
                break;
        }
    }

    

    public void scartaCarta(Mazzo mazzo){
        if(cartePossedute.size() > puntiFerita){
            System.out.printf("Devi scartare %d carte: ", cartePossedute.size() - puntiFerita);
            System.out.println(toStringCartePossedute());
            for(int i = 0; i < cartePossedute.size() - puntiFerita; ++i){
                int scelta = InterazioneUtente.qualeCartaVuoiScartare(cartePossedute.size());
                mazzo.aggiungiAlloScarto(cartePossedute.get(scelta-1));
                cartePossedute.remove(scelta-1);
            }
        }
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPuntiFerita() {
        return puntiFerita;
    }

    public void setPuntiFerita(int puntiFerita) {
        this.puntiFerita = puntiFerita;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - Ruolo: " + ruolo + " - PF: " + puntiFerita + " - Descrizione: " + descrizione; 
    }

}
