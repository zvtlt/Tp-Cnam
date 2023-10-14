package question4;



public class Delete extends Handler<Requete>{
 
    public Delete(Handler<Requete> handler) {
       super(handler);
    }
    public Delete(){super(null);}
    
    public boolean handleRequest(Requete requete){// a completer
        if (requete != null && requete.getCommande().equals("delete")){
            Table.getInstance().retirer(requete.getNom());
            return true;
        }else return super.handleRequest(requete);
    }

    // public boolean handleRequest(Requete requete){// a completer
       // if (requete != null && requete.getCommande().equals("delete")){
            // Table.getInstance().retirer(requete.getNom());
            // return true;
        // }else if(super.getNext() != null){
            // super.getNext().handleRequest(requete);
            // return true;
        // }else return false;
    // }
}