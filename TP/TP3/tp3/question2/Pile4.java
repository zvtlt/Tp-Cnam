package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacit� de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    // public Foo();
    // //always initialized, never null
    // this.objectList = new ArrayList<>();

    /**
     * Classe interne "statique" contenant chaque �l�ment de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }


    /**
     * Cr�ation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit �tre > 0
     */
    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        stk = null;
        this.capacite = taille;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        stk = new Maillon(o, stk);
        nombre++;
        // � compl�ter
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        // � compl�ter
        Maillon current = stk;
        stk = stk.suivant();
        nombre--;
        return current.element();
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.element(); // � compl�ter
    }

    /**
     * Effectue un test de l'�tat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return nombre == 0; // � compl�ter
    }

    /**
     * Effectue un test de l'�tat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return nombre == capacite; // � compl�ter
    }

    /**
     * Retourne une repr�sentation en String d'une pile, contenant la
     * repr�sentation en String de chaque �l�ment.
     * 
     * @return une repr�sentation en String d'une pile
     */
    public String toString() {

        String s = "[";
        
        Maillon temp = stk;

        while (temp != null) {
            s += temp.element().toString();
            if (temp.suivant() != null)
                s += ", ";
            temp = temp.suivant();
        }
        // � compl�ter
        return s + "]";
    }

    public boolean equals(Object o) {
        if (o instanceof Pile4) {
            Pile4 p = (Pile4) o;

            boolean memeTaille = (p.taille() == this.taille());
            boolean memeCapacite = (p.capacite() == this.capacite());
            boolean sontVide = (p.estVide() && this.estVide());

            if (!memeTaille || !memeCapacite)
                return false;

            if (!sontVide) {

                Maillon temp = stk;
                Maillon tempP = p.stk;

                while (temp != null) {
                    if (temp.element().hashCode() != tempP.element().hashCode())
                        return false;
                    temp = temp.suivant();
                    tempP = tempP.suivant();
                }

                return true;
            }

            if (sontVide) {
                return true;
            }
            return false;

        }
        return false;
    }

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
    
    public void test(){
        
        System.out.println(stk.suivant().element());
        
    }
}