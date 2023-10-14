package question2;
import java.util.*;

public class Memento {
    
    // The article stored in memento Object
    private List<String> MementoListe;
    private Map<String, Integer> MementoOccurrences;
    

    // Save a new MementoListe <String> to the memento Object
    // Save a new MementoOccurrences <String, Integer> to the memento Object
    
    public Memento(List<String> liste, Map<String, Integer> occurences){
        MementoListe = new LinkedList(liste);
        MementoOccurrences = new HashMap(occurences);
    }
    
    // Return the value stored in liste
    
    public List<String> getListe(){
        return MementoListe;
    }
    
    // Return the value stored in occurences
    
    public Map<String, Integer> getOccurences(){
        return MementoOccurrences;
    }
}
