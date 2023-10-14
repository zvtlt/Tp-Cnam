package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T>{

    protected java.util.Vector<T> table = new java.util.Vector<T>();

    // public String toString() {
    // // � compl�ter
    // String s = "[";
    // for (int i = size() - 1; i >= 0; i--) {
    // s += table.get(i).toString();
    // if (i != 0)
    // s += ", ";
    // }
    // return s + "]";
    // }

    public int size() {
        return table.size();
    }

    public Iterator<T> iterator() {
        return table.iterator();
    }

    public boolean add(T t){
        // à compléter pour la question1-1
        if (table.contains(t))
            return false;
        else {
            return table.add(t);
        }
    }

    public Ensemble<T> union(Ensemble<? extends T> e) {
        // à compléter pour la question1-2
        Ensemble<T> e1 = new Ensemble<T>();
        
        e1.addAll(this);
        e1.addAll(e);
        return e1;
    }

    public Ensemble<T> inter(Ensemble<? extends T> e) {
        // à compléter pour la question1-2
        Ensemble<T> e1 = new Ensemble<T>();
        
        e1.addAll(this);
        e1.retainAll(e);
        return e1;
    }

    public Ensemble<T> diff(Ensemble<? extends T> e) {
        // à compléter pour la question1-2
        Ensemble<T> e1 = new Ensemble<T>();
        
        e1.addAll(this);
        e1.removeAll(e);
        return e1;
    }

    public Ensemble<T> diffSym(Ensemble<? extends T> e) {
        // à compléter pour la question1-2

        return ((this.union(e)).diff(this.inter(e)));
    }

}
