import java.util.Collections;
import java.util.LinkedList;

public class Mazzo {

    private LinkedList<Carta> mazzo = new LinkedList<>();

    public void creaMazzo(){
        Xml.creaMazzo(mazzo);
    }

    public void mescolaMazzo(){
        Collections.shuffle(mazzo);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < mazzo.size(); ++i){
            buffer.append(mazzo.get(i).toString() + "\n");
        }
        return buffer.toString();
    }
}
