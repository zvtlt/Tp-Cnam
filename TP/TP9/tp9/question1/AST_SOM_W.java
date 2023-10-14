package question1;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;

/**
 * Décrivez votre classe AST_SOM_W ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class AST_SOM_W extends AST_Progr implements java.io.Serializable {
    /*
     * modèle "java Style" dont l'AST "WhileL style" est à construire ci dessous
     * n=100; som = 0 ; while (n> 0) { som = som+n ; n = n - 1 ; }
     * afficher(som);
     */
    
    private Contexte m = new Memoire();
    private Variable som = new Variable(m, "som");
    private Variable n = new Variable(m, "n");
    private Constante zero = new Constante(0);
    private Constante un = new Constante(1);
    private Instruction ast = null; // à compléter
    
    public AST_SOM_W(int n) {
        m.ecrire("n", n);
        instAst();
    }
    
    private void instAst(){// à compléter
        ast = 
         new Sequence(
                new Sequence(
                new Affectation(som, zero),
                    new TantQue(new Sup(n, zero),
                    new Sequence(
                        new Affectation(som,new Addition(som, n)),
                        new Affectation(n, new Soustraction(n, un)))
                    )
                ), new Afficher(som)
             );    
    }

    public Contexte getMem() {
        return m;
    }

    public Instruction getAST() {
        return ast;
    }

}
