package question3;

import java.util.Set;
import java.util.HashSet;

public class HashSetFactory<T>/* � compl�ter */implements Factory<Set<T>>/* � compl�ter */{
    public Set<T> create(){
        return new HashSet<T>();
    }
}