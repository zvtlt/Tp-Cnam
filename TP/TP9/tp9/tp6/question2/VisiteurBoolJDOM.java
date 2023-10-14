package tp6.question2;

import org.jdom.Element;

import tp6.question1.VisiteurExpression;

public class VisiteurBoolJDOM extends VisiteurExpressionBooleenne<Element> {

    private VisiteurExpression<Element> ve;

    public VisiteurBoolJDOM(VisiteurExpression<Element> ve) {
        this.ve = ve;
    }

    // à compléter
    public Element visite(Vrai v){
        Element elem = new Element("Vrai");
        elem.addContent(v.accepter(this));
        return elem;
    }

    public Element visite(Faux f){
        Element elem  = new Element("Faux");
        elem.addContent(f.accepter(this));
        return elem;
    }

    public Element visite(Non n){
        Element elem = new Element("Non");
        elem.addContent(n.bop().accepter(this));
        return elem;
    }

    public Element visite(Ou o){
        Element elem = new Element("Ou");
        elem.addContent(o.bop1().accepter(this));
        elem.addContent(o.bop2().accepter(this));
        return elem;
    }

    public Element visite(Et e){
        Element elem = new Element("Et");
        elem.addContent(e.bop1().accepter(this));
        elem.addContent(e.bop2().accepter(this));
        return elem;
    }

    public Element visite(Sup s){
        Element elem = new Element("Sup");
        elem.addContent(s.op1().accepter(this.ve));
        elem.addContent(s.op2().accepter(this.ve));
        return elem;
    }

    public Element visite(Egal e){
        Element elem = new Element("Egal");
        elem.addContent(e.op1().accepter(this.ve));
        elem.addContent(e.op2().accepter(this.ve));
        return elem;
    }

    public Element visite(Inf i){
        Element elem = new Element("Inf");
        elem.addContent(i.op1().accepter(this.ve));
        elem.addContent(i.op2().accepter(this.ve));
        return elem;
    }
}
