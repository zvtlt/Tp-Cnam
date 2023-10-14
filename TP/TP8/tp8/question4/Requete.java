package question4;

import java.util.Properties;
import java.util.StringTokenizer;

public class Requete{

    private String commande;
    private String nom;
    private int valeur;
    private Properties properties; // mode debug;

    /** M�thode utilitaire d'extraction des param�tres d'une requ�te GET/HTTP.
     * Requ�te de la forme GET /commande/?nom=string&valeur=integer&...
     * @param url une requ�te GET et ses param�tres
     * @return une properties : couples nom/valeur
     */
    private static Properties analyserRequete(String url){
        Properties properties = new Properties();
        StringTokenizer st = new StringTokenizer(url);
        String token = st.nextToken();
        if(token.equals("GET")){ // autre methode HTTP ignor�e
            String paramUrl = st.nextToken(); // la commande
            st = new StringTokenizer(paramUrl,"/&?= ");    
            properties.put("commande", st.nextToken());
            // une suite de couples clef/valeur
            while (((st.countTokens()%2)==0) && st.hasMoreTokens()){ 
                token = st.nextToken(" /&?=");
                properties.put(token,st.nextToken(" /&?=")); 
            }
        }
        return properties;
    }

    public Requete(String url){
        Properties props = analyserRequete(url);
        assert props.getProperty("commande")!=null:"Une commande doit �tre pr�sente...";
        this.commande = props.getProperty("commande");
        this.nom = props.getProperty("nom");

        if(props.getProperty("valeur")==null){
            this.valeur = -1;           
        }else{
            this.valeur = Integer.parseInt(props.getProperty("valeur"));
        }

    }

    public Requete(){}
    public void setUrl(String url){
        Requete requete = new Requete(url);
        this.commande = requete.commande;
        this.nom=requete.nom;
        this.valeur=requete.valeur;
    }

    public String getCommande(){ return commande;}

    public void setCommande(String commande){this.commande = commande;}

    public String getNom(){ return nom;}

    public void setNom(String nom){this.nom=nom;}

    public int getValeur(){return valeur;}

    public void setValeur(int valeur){this.valeur=valeur;}

    public Properties getProperties(){return this.properties;}

    public void setProperties(Properties properties){this.properties = properties;}

    public String toString(){
        return "<" + commande + ", " + nom + ", " + valeur + ">";
    }

}