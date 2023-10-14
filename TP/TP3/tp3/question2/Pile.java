package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {
    public final static int TAILLE_PAR_DEFAUT = 6;

    private Object[] zone;
    private int ptr;
    private int taille;

    public Pile(int taille) {
        if (taille <= 0)
            taille = TAILLE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
        this.taille = taille;
    }

    public Pile() {
        this(TAILLE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide()) 
            throw new PileVideException();
        this.ptr--;
        return this.zone[this.ptr];
    }

    public Object sommet() throws PileVideException {
        if(estVide()){
            throw new PileVideException();
        }else{
            return this.zone[this.ptr - 1];
        }
    }

    public int capacite() {
        // à compléter
        return this.taille;
    }

    public int taille() {
        // à compléter
        return this.ptr;
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }

    public boolean equals(Object o) {
        // à compléter
        if (o instanceof Pile) {
            Pile p = (Pile)o; 

            boolean memeTaille = (p.taille() == this.taille());
            boolean memeCapacite = (p.capacite() == this.capacite());
            boolean sontVide = (p.estVide() && this.estVide());

            if( !memeTaille || !memeCapacite )
                return false;

            if (!sontVide) {
                
                for (int i = 0; i < taille(); i++) {
                    if (this.atIndex(i).hashCode() == p.atIndex(i).hashCode() == false)
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
    
    public Object atIndex(int index) {
    return this.zone[index];
    }

    // fonction fournie
    public int hashCode() {
         return toString().hashCode();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i]);
            if (i > 0)
            sb.append(", "); 
        }
        sb.append("]");
        return sb.toString();
    }
}