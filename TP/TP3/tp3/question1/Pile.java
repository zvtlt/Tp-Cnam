package question1;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer par votre classe Pile .
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile {
    public final static int TAILLE_PAR_DEFAUT = 5;

    private Object[] zone;
    private int ptr;

    /**
     * à compléter
     * 
     */
    public Pile(int taille) {
        if (taille < 0)
            taille = TAILLE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(TAILLE_PAR_DEFAUT);
    }

    public void empiler(Object i) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = i;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide()) 
            throw new PileVideException();
        this.ptr--;
        return this.zone[this.ptr].hashCode();
    }

    public int count(){
        return (this.zone[this.ptr - 1]).toString().length();
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean uneEntree() {
        return ptr == 1;
    }

    public boolean estPleine() {
        return ptr == zone.length;
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

    public void test(){
        System.out.println(this.zone[this.ptr].hashCode());
    }
}