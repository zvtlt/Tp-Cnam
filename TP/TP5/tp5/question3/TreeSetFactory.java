package question3;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetFactory<T extends Comparable>/* à compléter */implements Factory<Set<T>>/* à compléter */{
    public Set<T> create(){
        return new TreeSet<T>();
    }
}
