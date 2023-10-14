package exemple_conges;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Agent{
  private String       nom;
  private String       prenom;
  private int          anciennete;
  private Mairie       mairie;
  private List<String> services; // la liste des services depuis son arrivee
  
  
  public Agent(String prenom, String nom){
      this.prenom   = prenom;
      this.nom      = nom;
      this.services = new ArrayList<String>();
  }

  public void setNom(String nom){this.nom = nom;}
  public void setPrenom(String prenom){this.prenom = prenom;}
  public void setAnciennete(int anciennete){this.anciennete = anciennete;} 
  public void setService(String service){
      this.services.add(service);
  }
  public void setMairie(Mairie mairie){ this.mairie = mairie;}
  public String getNom(){return this.nom;}
  public String getPrenom(String prenom){return this.prenom;}
  public List<String> getServices(){
      return Collections.unmodifiableList(services);
  }
  public int getAnciennete(){ return this.anciennete;}
  public Mairie getMairie(){ return mairie;}
  public String toString(){
      return "<"+prenom+"-"+nom+","+mairie+","+services+">";
    }
}
