package question2;

import question1.Cotisant;
import question1.Contributeur;
import question1.GroupeDeContributeurs;
import question1.Visiteur;
import java.util.List;
import java.util.HashSet;

public class CompositeValide implements Visiteur<Boolean>{
    // Le solde de chaque contributeur doit être supérieur ou égal à un nombre transmis en paramètre 
    // et il n’existe pas de groupe n’ayant pas de contributeurs.
    private int valeur;
    HashSet hashSet;

    public CompositeValide(int valeur){
        this.valeur = valeur;
        hashSet = new HashSet();
    }

    public CompositeValide(){
        this(0);
    }

    public Boolean visite(Contributeur c){
        return c.solde() >= valeur;// a compléter;
    }
    
    public Boolean visite(GroupeDeContributeurs g){
        List<Cotisant> cotisants = g.getChildren();
        int index = 0;
        Cotisant cotisant;
        Boolean reponse = !g.getChildren().isEmpty() && hashSet.add(g);

        while(reponse && index < cotisants.size()){
            cotisant = cotisants.get(index);
            reponse &= cotisant.accepter(this);
            index++;
        }

        return reponse;
    }
    
    // public Boolean visite(GroupeDeContributeurs g){
        // Boolean reponse = !g.getChildren().isEmpty() && hashSet.add(g);

        // for(Cotisant c : g.getChildren()){
            // if(reponse)
            // reponse &= c.accepter(this);
        // }

        // return reponse;
    // }
}