package question3;

import java.io.*;

import question1.*;
import question2.*;

/**
 * 
 */
public class VisiteurInstToJava extends VisiteurInstruction<String> {

    private final static int TAB = 2;
    private static final String lineSeparator = System.getProperties().getProperty("line.separator");

    private VisiteurExpression<String> vi;
    private VisiteurExpressionBooleenne<String> vb;

    private int tabulations;

    /**
     * Création d'un visiteur d'instructions
     * 
     * @param vi
     *            le visiteur d'expressions arithmétiques
     * @param vb
     *            le visiteur d'expression booléennes
     * @param tabulations
     *            tabulations initiales
     */
    public VisiteurInstToJava(VisiteurExpression<String> vi, VisiteurExpressionBooleenne<String> vb, int tabulations) {
        this.vi = vi;
        this.vb = vb;
        this.tabulations = tabulations;
    }

    /**
     * Création d'un visiteur d'instructions
     * 
     * @param vi
     *            le visiteur d'expressions arithmétiques
     * @param vb
     *            le visiteur d'expression booléennes
     */
    public VisiteurInstToJava(VisiteurExpression<String> vi, VisiteurExpressionBooleenne<String> vb) {
        this(vi, vb, 0);
    }

    /**
     * obtention du contexte, ici celui du visiteur d'expression arithmétiques
     * 
     * @return le contexte ici de vi(le visiteur d'expression)
     */
    public Contexte contexte() {
        return this.vi.contexte();
    }

    /**
     * Visite d'une instance de la classe Affectation.
     * 
     * 
     * @param a
     *            une affectation
     * @return a := exp
     */
    public String visite(Affectation a) {
        return a.v().accepter(this.vi) + "=" + a.exp().accepter(this.vi);
    }

    /**
     * Visiste d'une séquence seq(I1,I2) <br>
     * 
     * @param seq
     *            une séquence
     * @return i1;i2
     */
    public String visite(Sequence seq) {
        String seqString = seq.i1().accepter(this);
        if (seq.i1() instanceof Affectation)
            seqString += ";";

        seqString += tab(0) + seq.i2().accepter(this);
        if (seq.i2() instanceof Affectation)
            seqString += ";";

        return seqString; // à compléter
        // à compléter
    }

    public String visite(Selection sel) {
        String selString = tab(0) + "if" + sel.cond().accepter(vb) + "{" + tab(2);
        selString += sel.i1().accepter(this);

        if (sel.i1() instanceof Affectation)
            selString += ";";

        if (sel.i2() != null){
            selString += tab(-2) +"}";
            selString += "else {" + tab(2);
            selString += sel.i2().accepter(this);
            if (sel.i2() instanceof Affectation)
                selString += ";";
            selString += tab(-2)+ "}";
        } else {
            selString += tab(-1) +"}";
        }

        

        return selString; // à compléter
    }

    public String visite(TantQue tq) {
        String tqString = tab(0) + "while" + tq.cond().accepter(vb) + "{" + tab(2);
        tqString += tq.i1().accepter(this);

        if (tq.i1() instanceof Affectation)
            tqString += ";";

        tqString += tab(-2) +"}";

        return tqString; // à compléter
    }

    public String visite(Pour pour) {
        String pourString = tab(0) + "for(" + pour.init().accepter(this)+ ";" + pour.cond().accepter(vb) + ";"
        + pour.inc().accepter(this) + "){" + tab(2);
        
        pourString += pour.i1().accepter(this);
        if (pour.i1() instanceof Affectation)
            pourString += ";";
            
        pourString += tab(-2) + "}";
        
        return pourString;
    } // à compléter
    

    public String visite(Afficher a) {
        return "System.out.println(" + a.exp().accepter(vi) + ");"; // à compléter
    }

    public String visite(Assertion a) {
        return "assert" + a.cond().accepter(this.vb) + ";"; // à compléter
    }

    private String tab(int n) {
        String str = new String();

        str = str + lineSeparator;
        for (int i = 0; i < this.tabulations + n; i++) {
            str = str + " ";
        }
        this.tabulations += n;
        return str;
    }

}
