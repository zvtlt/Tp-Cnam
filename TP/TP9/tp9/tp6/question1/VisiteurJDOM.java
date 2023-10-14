package tp6.question1;

import java.io.*;

import org.jdom.Element;

public class VisiteurJDOM extends VisiteurParDefaut<Element> {

    private Contexte c;

    public VisiteurJDOM(Contexte c) {
        this.c = c;
    }

    // à compléter
    public Element visite(Constante c) {
        Element elem = new Element("Constante");
        elem.setText(Integer.toString(c.valeur()));
        return elem;
    }

    public Element visite(Variable v) {
        Element elem = new Element("Variable");
        elem.setText(v.nom());
        return elem;
    }

    public Element visite(Division d) {
        Element elem = new Element("Division");
        elem.addContent(d.op1.accepter(this));
        elem.addContent(d.op2.accepter(this));
        return elem;
    }

    public Element visite(Addition a) {
        Element elem = new Element("Addition");
        elem.addContent(a.op1.accepter(this));
        elem.addContent(a.op2.accepter(this));
        return elem;
    }

    public Element visite(Multiplication m) {
        Element elem = new Element("Multiplication");
        elem.addContent(m.op1.accepter(this));
        elem.addContent(m.op2.accepter(this));
        return elem;
    }

    public Element visite(Soustraction s) {
        Element elem = new Element("Soustraction");
        elem.addContent(s.op1.accepter(this));
        elem.addContent(s.op2.accepter(this));
        return elem;
    }

    public Contexte contexte() {
        return c;
    }
}
