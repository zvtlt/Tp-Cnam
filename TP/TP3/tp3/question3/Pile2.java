package question3;

import question1.PilePleineException;
import question1.PileVideException;
import java.util.Iterator;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par d�l�gation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacit� de la pile */
    private int capacite;

    /** Cr�ation d'une pile.
     * @param taille la "taille maximale" de la pile, doit �tre > 0
     */
    public Pile2(int taille){
        if (taille <= 0)
            this.capacite = CAPACITE_PAR_DEFAUT;
        else
            this.capacite = taille;

        stk = new Stack<T>();
    }

    public Pile2(){
        this(0);
    }

    public void empiler(T o) throws PilePleineException{
        if (estPleine())
            throw new PilePleineException();
        stk.add(o);
    }

    public T depiler() throws PileVideException{
        if (estVide()) 
            throw new PileVideException();
        return stk.pop();
    }

    public T sommet() throws PileVideException{
        if (estVide()) 
            throw new PileVideException();
        return stk.peek();
    }
    
    public boolean estVide() {
        return stk.empty();
    }
    
    public boolean estPleine() {
        return stk.size() == this.capacite;
    }
    
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

                Iterator<T> stkIterator1 = stk.iterator();
                Iterator<T> stkIterator2 = p.stk.iterator();

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

    public Iterator<T> stackInterator() {

        Iterator<T> stkIterator = stk.iterator();
        return stkIterator;
    }
    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        // � compl�ter
        return stk.size();
    }
    
    public int capacite() {
        // � compl�ter
        return this.capacite;
    }
} // Pile2