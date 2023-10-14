package question4;

public class Retrieve extends Handler<Requete>{
    public Retrieve(Handler<Requete> handler) {
        super(handler);
    }

    public Retrieve(){
        super(null);
    }
    
    public boolean handleRequest(Requete requete){// a completer
        if (requete != null && requete.getCommande().equals("retrieve")){
            requete.setValeur(Table.getInstance().lire(requete.getNom()));
            System.out.println(requete);
            return true;
        }else return super.handleRequest(requete);
    }

    // public boolean handleRequest(Requete requete){// a completer
        // if (requete != null && requete.getCommande().equals("retrieve")){
            // requete.setValeur(Table.getInstance().lire(requete.getNom()));
            // return true;
        // }else if(super.getNext() != null){
            // super.getNext().handleRequest(requete);
            // return true;
        // }else return false;
    // }
}
