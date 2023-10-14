package question3;

import question1.*;
import java.util.*;

public class Memento {
    // Note : Un usage du patron Memento, 
    //        d’un premier visiteur pour la sauvegarde et 
    //        d’un second pour la restitution du composite, 
    //        représentent une solution possible. 

    private GroupeDeContributeurs etats;

    public Memento(Cotisant c) {
        etats = new GroupeDeContributeurs("sauvegarde");
        VisiteurSav vs = new VisiteurSav();
        etats.ajouter(c.accepter(vs));
        // sauvegarde
    }

    public void setState(Cotisant c) {
        VisiteurRes vr = new VisiteurRes(etats);
        c.accepter(vr);
        // restitution
    }
}