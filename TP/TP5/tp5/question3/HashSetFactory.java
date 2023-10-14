package question3;

import java.util.Set;
import java.util.HashSet;

public class HashSetFactory<T>/* à compléter */implements Factory<Set<T>>/* à compléter */{
    public Set<T> create(){
        return new HashSet<T>();
    }
}