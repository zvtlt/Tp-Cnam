package question3;


import question1.*;

public class VisiteurRes implements Visiteur<Void>{
    
    private GroupeDeContributeurs save;
    
    public VisiteurRes(GroupeDeContributeurs save){
        this.save = save;
    }
    
    public Void visite(Contributeur c){
        for(Cotisant cotisant : save){
            if(cotisant.equals(c)){
                c.affecterSolde(cotisant.solde());
            }
        }
        return null;
    }
    
    public Void visite(GroupeDeContributeurs g){
        for(Cotisant cotisant : g.getChildren()){
            cotisant.accepter(this);
        }
        return null;
    }
}
