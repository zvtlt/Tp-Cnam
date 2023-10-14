
package question4;

//import 
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;
import java.util.Stack;
import java.util.NoSuchElementException;
import java.util.Enumeration;

// import java.util.Set;
// import java.util.HashSet;

/** Une table utilisant le patron Singleton.<br>
 * L'accès à cette table uniquement via l'appel de Table.getInstance().<br>
 * <b>Attention</b> cette classe ne peut être utilisée dans un contexte concurrent (NotThreadSafe)
 */
public final class Table implements Iterable<String>{
    // Singleton
    private static Table instance = null;

    public static Table getInstance(){
        // Not ThreadSafe, cf. NSY102 ...
        synchronized(Table.class){
            if(instance==null){
                instance = new Table();
            }
            return instance;
        }
    }
    //private // une structure de votre choix
    private static Map<String, Integer> table;

    private Table(){// a completer
        table = new TreeMap();
    }

    /** Ajout d'un couple nom/valeur. le nom est unique.
     * @param nom un nom
     * @param valeur une valeur entière
     */
    public void ajouter(String nom, int valeur){// a completer
        table.put(nom, valeur);
    }

    /** Accès en lecture au couple nom/valeur.
     * @param nom un nom présent dans la table
     * @return la valeur associée à ce nom
     * @throws RuntimeException si ce nom est absent de la table
     */
    public int lire(String nom){// a completer
        // si le nom est absent de la table alors throw new RuntimeException();
        if (!table.containsKey(nom))
            throw new RuntimeException();

        return table.get(nom);
    }

    /** Test de la présence d'un nom dans la table.
     * @param nom un nom 
     * @return un booléen true ce nom est présent, false autrement
     */
    public boolean contient(String nom){
        return table.containsKey(nom); // a completer
    }

    /** Obtention de la taille de la table.
     * @return le nombre de couples de cette table
     */
    public int taille(){// a completer
        return table.size(); 
    }

    /** Retrait d'un couple nom/valeur.
     * @param nom le nom à retirer, quelque soit la valeur
     * @return un booléen true ce nom a bien été retiré
     */
    public boolean retirer(String nom){
        return !(table.remove(nom) == null ); // a completer
    }

    /** Retrait de tous les couples nom/valeur de cette table.
     */
    public void vider(){// a completer
        table.clear();
    }

    /** Obtention d'une <I>String</i> de la table.
     */
    public String toString(){// a completer
        return table.toString();
        // return new String();
    }

    /** Obtention d'un <I>Iterator</i> sur les noms de la table.
     * Attention, la méthode remove, n'a aucun effet sur la table.<b>
     * @return un itérateur sur la table.
     */
    // public Iterator<String> iterator(){
    // // return Collections.unmodifiableSet(table.keySet()).iterator();

    // return new Ite(table.keySet().iterator());
    // }

    public Iterator<String> iterator(){
        return new Ite(table.keySet().iterator());
    }

    // public Iterator<String> iterator(){
        // Set<String> copy = new HashSet<String>();

        // for(String key : table.keySet()){
            // copy.add(key);
        // }
        // return  copy.iterator();
    // }

    private class Ite implements Iterator<String>{
        private Stack<Iterator<String>> stk;

        public Ite(Iterator<String> iterator){
            this.stk = new Stack<Iterator<String>>();
            this.stk.push(iterator);
        }

        public boolean hasNext(){
            if(stk.empty()){
                return false;
            }else{
                Iterator<String> iterator = stk.peek();
                if( !iterator.hasNext()){
                    stk.pop();
                    return hasNext();
                }else{
                    return true;
                }
            }
        }

        public String next(){
            if(hasNext()){
                Iterator<String> iterator = stk.peek();
                String cpt = iterator.next();
                return cpt;
            }else{
                throw new NoSuchElementException();
            }
        }

        public void remove(){

        }
    }
}
