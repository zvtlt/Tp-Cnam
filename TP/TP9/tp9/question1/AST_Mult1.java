package question1;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;

/**
 * Décrivez votre classe AST_Mult1 ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class AST_Mult1 extends AST_Progr implements java.io.Serializable {
    /*
     * modèle "java Style" dont l'AST "WhileL style" est à construire ci dessous
     * a = n1 ; b = n2 ; produit = 0 ; while (b > 0) { produit = produit + a ;
     * b=b-1; } afficher(produit);
     */
    
    private Contexte m = new Memoire();
    private Variable produit = new Variable(m, "produit");
    private Variable a = new Variable(m, "a");
    private Variable b = new Variable(m, "b");
    private Instruction ast = null; // à compléter

    public AST_Mult1(int n1, int n2) {
        m.ecrire("a", n1);
        m.ecrire("b", n2);
        instAst();
    }

    private void instAst(){// à compléter
        ast = 
        new Sequence(
                new Affectation(produit, new Constante(0)),
                new Sequence(
                    new TantQue(new Sup(b, new Constante(0)),
                    new Sequence(
                        new Affectation(produit, new Addition(produit, a)),
                        new Affectation(b, new Soustraction(b, new Constante(1))))
                    ),
                new Afficher(produit))
            );
    }

    public Contexte getMem() {
        return m;
    }

    public Instruction getAST() {
        return ast;
    }

}
