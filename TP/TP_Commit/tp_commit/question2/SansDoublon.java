package question2;

import question1.*;
import java.util.Set;
import java.util.TreeSet;

// La classe SansDoublon vérifie que les noms des groupes et des contributeurs sont différents.

public class SansDoublon implements Visiteur<Boolean>{
    Set<String> doublons = new TreeSet<>();
    
    public Boolean visite(Contributeur c){
        return doublons.add(c.nom());// a compléter;
    }

    public Boolean visite(GroupeDeContributeurs g){
        boolean res = doublons.add(g.nom());// a compléter
             
        for (Cotisant c : g.getChildren())
            res &= c.accepter(this);
        // a compléter
        return res ;
    }
}