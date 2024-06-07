import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Mazzo {

    private Stack<Carta> mazzoPrincipale = new Stack<>();
    private Stack<Carta> mazzoScarti = new Stack<>();

    public void creaMazzo(){
        Xml.creaMazzo(mazzoPrincipale);
    }

    public void mescolaMazzo(){
        Collections.shuffle(mazzoPrincipale);
    }

    public void mescolaScarti(){
        Collections.shuffle(mazzoScarti);
    }

    public Carta pescaCarta(){
        Carta cartaPescata = mazzoPrincipale.pop();
        return cartaPescata;
    }

    public void aggiungiAlloScarto(Carta c){
        mazzoScarti.push(c);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < mazzoPrincipale.size(); ++i){
            buffer.append(mazzoPrincipale.get(i).toString() + "\n");
        }
        return buffer.toString();
    }
}
