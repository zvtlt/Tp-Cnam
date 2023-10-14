package tp6.question3;

import org.jdom.Element;

import tp6.question1.Contexte;
import tp6.question1.VisiteurExpression;
import tp6.question2.VisiteurExpressionBooleenne;

/**
 * Visiteur d'instruction, chaque classe concrète possède une implémentation de
 * la visite
 * 
 */
public class VisiteurInstJDOM extends VisiteurInstruction<Element> {

    private VisiteurExpression<Element> vi;
    private VisiteurExpressionBooleenne<Element> vb;

    /**
     * Création d'un visiteur d'instructions
     * 
     * @param vi
     *            le visiteur d'expressions arithmétiques
     * @param vb
     *            le visiteur d'expression booléennes
     */
    public VisiteurInstJDOM(VisiteurExpression<Element> vi,
    VisiteurExpressionBooleenne<Element> vb) {
        this.vi = vi;
        this.vb = vb;
    }

    /**
     * obtention du contexte,
     * 
     * @return le contexte ici de vi(le visiteur d'expression)
     */
    public Contexte contexte() {
        return this.vi.contexte();
    }

    // à compléter
    public Element visite(Affectation a){
        Element elem = new Element("Affectation");
        elem.addContent(a.v().accepter(this.vi));
        elem.addContent(a.exp().accepter(this.vi));
        return elem;
    }

    public Element visite(Sequence s){
        Element elem = new Element("Sequence");
        elem.addContent(s.i1().accepter(this));
        elem.addContent(s.i2().accepter(this));
        return elem;
    }

    public Element visite(Selection s){
        Element elem = new Element("Selection");
        elem.addContent(s.cond().accepter(this.vb));
        elem.addContent(s.i1().accepter(this));
        return elem;
    }

    public Element visite(TantQue t){
        Element elem = new Element("TantQue");
        elem.addContent(t.cond().accepter(this.vb));
        elem.addContent(t.i1().accepter(this));
        return elem;
    }

    public Element visite(Pour p){
        Element elem = new Element("Pour");
        elem.addContent(p.init().accepter(this));
        elem.addContent(p.cond().accepter(this.vb));
        elem.addContent(p.i1().accepter(this));
        elem.addContent(p.inc().accepter(this));
        return elem;
    }

    public Element visite(Afficher a){
        Element elem = new Element("Afficher");
        elem.addContent(a.exp().accepter(this.vi));
        return elem;
    }

    public Element visite(Assertion a){
        Element elem = new Element("Assertion");
        elem.addContent(a.cond().accepter(this.vb));
        return elem;
    }
}
