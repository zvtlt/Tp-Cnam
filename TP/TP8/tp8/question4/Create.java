package question4;


public class Create extends Handler<Requete>{

    public Create(Handler<Requete> handler) {
        super(handler);
    }

    public Create(){
        super(null);
    }
    
    public boolean handleRequest(Requete requete){// a completer
        if (requete != null && requete.getCommande().equals("create")){
            Table.getInstance().ajouter(requete.getNom(), requete.getValeur());
            return true;
        }else return super.handleRequest(requete);
    }

    // public boolean handleRequest(Requete requete){// a completer
        // if (requete != null && requete.getCommande().equals("create")){
            // Table.getInstance().ajouter(requete.getNom(), requete.getValeur());
            // return true;
        // }else if(super.getNext() != null){
            // super.getNext().handleRequest(requete);
            // return true;
        // }else return false;
    // }
}
