package question3;

import question1.*;


public class VisiteurSav implements Visiteur<Cotisant>{
    
    public Cotisant visite(Contributeur c){
        return new Contributeur(c.nom(), c.solde());
    }

    public Cotisant visite(GroupeDeContributeurs g){
        GroupeDeContributeurs gSave = new GroupeDeContributeurs(g.nom());
        for(Cotisant c : g.getChildren()){
            gSave.ajouter(c.accepter(this));
        }
        return gSave;
    }
}
