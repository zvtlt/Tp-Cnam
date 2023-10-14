package question4;

import java.util.StringTokenizer;
import java.util.Properties;

public class Main{

    
    
    public static void main(String[] args){
        Handler<Requete> chaine = new Log(new Create(new Retrieve( new Update( new Delete(null)))));
        System.out.println("chaine : " + chaine.toString());
        
        Requete requete = new Requete("GET /create/?nom=temperature&valeur=20");
        boolean resultat = chaine.handleRequest(requete);
        System.out.println("Table : " + Table.getInstance() + ", " + requete + ", " + resultat);
        
        requete = new Requete("GET /update/?nom=temperature&valeur=40");
        resultat = chaine.handleRequest(requete);
        System.out.println("Table : " + Table.getInstance() + ", " + requete + ", " + resultat);
        
        requete = new Requete("GET /retrieve/?nom=temperature");
        resultat = chaine.handleRequest(requete);
        System.out.println("Table : " + Table.getInstance() + ", " + requete + ", " + resultat);
        
        requete = new Requete("GET /delete/?nom=temperature");
        resultat = chaine.handleRequest(requete);
        System.out.println("Table : " + Table.getInstance() + ", " + requete + ", " + resultat);
        
        requete = new Requete("GET /create/?nom=jauge&valeur=1000");
        resultat = chaine.handleRequest(requete);
        System.out.println("Table : " + Table.getInstance() + ", " + requete + ", " + resultat);
        
        requete = new Requete("GET /void/?nom=jauge&valeur=1000");
        resultat = chaine.handleRequest(requete);
        System.out.println("Table : " + Table.getInstance() + ", " + requete + ", " + resultat);
    }
}
