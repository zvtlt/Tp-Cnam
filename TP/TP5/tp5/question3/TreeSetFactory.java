package question3;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetFactory<T extends Comparable>/* � compl�ter */implements Factory<Set<T>>/* � compl�ter */{
    public Set<T> create(){
        return new TreeSet<T>();
    }
}
