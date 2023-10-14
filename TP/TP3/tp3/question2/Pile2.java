
package question2;
import question1.PilePleineException;
import question1.PileVideException;

import java.util.*;

public class Pile2 implements PileI {
    /** par délégation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacité de la pile */
    private int capacite;

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile2(int taille) {
        if (taille <= 0)
            this.capacite = CAPACITE_PAR_DEFAUT;
        else
            this.capacite = taille;

        stk = new Stack<Object>();
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        stk.add(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide()) 
            throw new PileVideException();
        return stk.pop();
    }

    public Object sommet() throws PileVideException {
        if (estVide()) 
            throw new PileVideException();
        return stk.peek();
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk.empty();
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return stk.size() == this.capacite;
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {
        String s = "[";
        for (int i = taille() - 1; i >= 0; i--) {
            s += stk.get(i).toString();
            if (i != 0)
                s += ", ";
        }
        return s + "]";
    }

    public boolean equals(Object o) {

        if (o instanceof Pile2) {
            Pile2 p = (Pile2)o; 

            boolean memeTaille = (p.taille() == this.taille());
            boolean memeCapacite = (p.capacite() == this.capacite());
            boolean sontVide = (p.estVide() && this.estVide());

            if( !memeTaille || !memeCapacite )
                return false;

            if (!sontVide) {

                Iterator<Object> stkIterator1 = stk.iterator();
                Iterator<Object> stkIterator2 = p.stk.iterator();

                while(stkIterator1.hasNext()) {
                    if (stkIterator1.next().hashCode() != stkIterator2.next().hashCode())
                        return false;
                }

                return true;
            }

            if (sontVide) {
                return true;
            }

        } 

        return false;
    }

    public Iterator<Object> stackInterator() {

        Iterator<Object> stkIterator = stk.iterator();
        return stkIterator;
    }
    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'élément d'une pile.
     * 
     * @return le nombre d'élément
     */
    public int taille() {
        // à compléter
        return stk.size();
    }

    /**
     * Retourne la capacité de cette pile.
     * 
     * @return le nombre d'élément
     */
    public int capacite() {
        // à compléter
        return this.capacite;
    }
} // Pile2.java
