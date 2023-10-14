package question2;

import question1.Cotisant;
import question1.Contributeur;
import question1.GroupeDeContributeurs;
import question1.Visiteur;
import java.util.List;

public class DebitMaximal implements Visiteur<Integer>{

  public Integer visite(Contributeur c){
    return c.solde(); // a compléter
  }
  
  public Integer visite(GroupeDeContributeurs g){
    int res = Integer.MAX_VALUE;

    for (Cotisant c : g.getChildren())
        res = Math.min(c.accepter(this), res);
    // a compléter
    return res ;
  }
}