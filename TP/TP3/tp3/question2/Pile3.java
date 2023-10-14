package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;
import java.util.Iterator;

/**
 * D�crivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
    private int taille;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // � compl�ter
        if (taille <= 0)
            v = new Vector<Object>(CAPACITE_PAR_DEFAUT);
        else
            v = new Vector<Object>(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        // � compl�ter
        if (estPleine())
            throw new PilePleineException();
        v.addElement(o);
    }

    public Object depiler() throws PileVideException {
        Object v1 = null;

        if (estVide()) 
            throw new PileVideException();
        v1 = v.elementAt(v.size() - 1);
        v.removeElementAt(v.size() - 1);
        return v1;
    }

    public Object sommet() throws PileVideException {
        if (estVide()) 
            throw new PileVideException();
        return v.lastElement();
    }

    public int taille() {
        // � compl�ter
        return v.size();
    }

    public int capacite() {
        // � compl�ter
        return v.capacity();
    }

    public boolean estVide() {
        // � compl�ter
        return v.isEmpty();
    }

    public boolean estPleine() {
        // � compl�ter
        return v.size() == v.capacity();
    }

    public String toString() {
        // � compl�ter
        String s = "[";
        for (int i = taille() - 1; i >= 0; i--) {
            s += v.get(i).toString();
            if (i != 0)
                s += ", ";
        }
        return s + "]";
    }

     public boolean equals(Object o) {

        if (o instanceof Pile3) {
            Pile3 p = (Pile3) o;

            Iterator<Object> it = v.iterator();
            Iterator<Object> ito = p.v.iterator();

            boolean memeTaille = (p.taille() == this.taille());
            boolean memeCapacite = (p.capacite() == this.capacite());
            boolean sontVide = (p.estVide() && this.estVide());

            if (!memeTaille || !memeCapacite)
                return false;

            if (!sontVide) {

                while (it.hasNext()) {
                    if (it.next().hashCode() != ito.next().hashCode())
                        return false;
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

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }
    
    public void test(){
     System.out.println();   
    }
    }

