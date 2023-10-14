package question1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.HashSet;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class GroupeDeContributeurs extends Cotisant implements Iterable<Cotisant>{
    private List<Cotisant> liste;
    String Newligne=System.getProperty("line.separator");

    public GroupeDeContributeurs(String nomDuGroupe){
        super(nomDuGroupe);
        liste = new ArrayList();
        // a completer
    }

    public void ajouter(Cotisant cotisant){
        assert cotisant!=null && cotisant.getParent()==null;
        // if(liste.contains(cotisant))
        // System.out.println("Cotisant a déjà été ajouté");
        // else{
        // hashSet.add(cotisant);
        liste.add(cotisant);
        // liste.retainAll(hashSet);
        cotisant.setParent(this);
        // }
        // a completer
    }

    public int nombreDeCotisants(){
        int nombre = 0;

        for (Cotisant cotisant : liste) {
            nombre += cotisant.nombreDeCotisants();
        }
        // a completer
        return nombre;
    }

    public String toString(){
        String str = new String();
        // "<Contributeur : " + nom + "," + solde + ">";
        for (Cotisant cotisant : liste) {
            str += "<Contributeur : " + cotisant.nom() + "," + cotisant.solde() + ">" + Newligne;
        }
        // a completer
        return str;
    }

    public List<Cotisant> getChildren(){
        return liste;// a completer
    }

    public void debit(int somme) throws SoldeDebiteurException{
        for (Cotisant cotisant : liste) {
            cotisant.debit(somme);
        }
        // a completer
    }

    public void credit(int somme){
        for (Cotisant cotisant : liste) {
            cotisant.credit(somme);
        }
        // a completer
    }

    public int solde(){
        int solde = 0;

        for (Cotisant cotisant : liste) {
            solde += cotisant.solde();
        }
        // a completer
        return solde;
    }

    // méthodes fournies

    public Iterator<Cotisant> iterator(){
        return new GroupeIterator(liste.iterator());
    }

    private class GroupeIterator implements Iterator<Cotisant>{
        private Stack<Iterator<Cotisant>> stk;

        public GroupeIterator(Iterator<Cotisant> iterator){
            this.stk = new Stack<Iterator<Cotisant>>();
            this.stk.push(iterator);
        }

        public boolean hasNext(){
            if(stk.empty()){
                return false;
            }else{
                Iterator<Cotisant> iterator = stk.peek();
                if( !iterator.hasNext()){
                    stk.pop();
                    return hasNext();
                }else{
                    return true;
                }
            }
        }

        public Cotisant next(){
            if(hasNext()){
                Iterator<Cotisant> iterator = stk.peek();
                Cotisant cpt = iterator.next();
                if(cpt instanceof GroupeDeContributeurs){
                    GroupeDeContributeurs gr = (GroupeDeContributeurs)cpt;
                    stk.push(gr.liste.iterator());
                }
                return cpt;
            }else{
                throw new NoSuchElementException();
            }
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public <T> T accepter(Visiteur<T> visiteur){
        return visiteur.visite(this);
    }

}
