package question4;

public class Update extends Handler<Requete>{

    public Update(Handler<Requete> handler) {
        super(handler);
    }

    public Update(){
        super(null);
    }
    
    public boolean handleRequest(Requete requete){// a completer
        if (requete != null && requete.getCommande().equals("update")){
            Table.getInstance().ajouter(requete.getNom(), requete.getValeur());
            return true;
        }else return super.handleRequest(requete);
    }

    // public boolean handleRequest(Requete requete){// a completer
       // if (requete != null && requete.getCommande().equals("update")){
            // Table.getInstance().ajouter(requete.getNom(), requete.getValeur());
            // return true;
        // }else if(super.getNext() != null){
            // super.getNext().handleRequest(requete);
            // return true;
        // }else return false;
    // }
}