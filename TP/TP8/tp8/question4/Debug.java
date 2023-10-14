package question4;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Iterator;

public class Debug extends Handler<Requete>{
    public Debug(Handler<Requete> handler) {
        super(handler);
    }

    public Debug(){
        super(null);
    }

    public boolean handleRequest(Requete requete){// a completer
        if (requete != null && requete.getCommande().equals("debug")){ // requete != null && requete.getCommande().equals("debug")
            Properties properties = new Properties();
            //properties.put(requete.getCommande().toString(), Table.getInstance().toString());
            requete.setProperties(properties);
            //properties.clear();
            
            for(String nom : Table.getInstance()){
                // properties.put(nom, Table.getInstance().lire(nom));
                // requete.setProperties(properties);
                // System.out.println(properties);
                properties.setProperty(nom, String.valueOf(Table.getInstance().lire(nom)));
                requete.setProperties(properties);
                requete.setNom(nom);
                requete.setValeur(Table.getInstance().lire(nom));
                System.out.println(requete);
                //System.out.println(properties);

            }
            return false;
        }else return super.handleRequest(requete);
    }
}