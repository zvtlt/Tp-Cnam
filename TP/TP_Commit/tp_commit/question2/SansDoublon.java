package question2;

import question1.*;
import java.util.Set;
import java.util.TreeSet;

// La classe SansDoublon v�rifie que les noms des groupes et des contributeurs sont diff�rents.

public class SansDoublon implements Visiteur<Boolean>{
    Set<String> doublons = new TreeSet<>();
    
    public Boolean visite(Contributeur c){
        return doublons.add(c.nom());// a compl�ter;
    }

    public Boolean visite(GroupeDeContributeurs g){
        boolean res = doublons.add(g.nom());// a compl�ter
             
        for (Cotisant c : g.getChildren())
            res &= c.accepter(this);
        // a compl�ter
        return res ;
    }
}