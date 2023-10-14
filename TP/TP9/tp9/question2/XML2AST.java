package question2;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;
import java.lang.reflect.Method;
import org.jdom.Element;
import java.util.*;

/**
 * Décrivez votre classe XML2AST ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class XML2AST {

    private static Queue<Element> listElt = new LinkedList<>();
    private static List list = new LinkedList();
    private static Instruction instruction = null;

    public static Instruction xmlInst2ast(Contexte m, Element element) throws Exception {

        XML2AST.XmlRecursive(element.getChildren().iterator());

        return toInst(m);
    }

    private static void XmlRecursive(Iterator<Element> list) {
        Element element = null;

        while (list.hasNext()) {
            element = list.next();
            listElt.add(element);
            XmlRecursive(element.getChildren().iterator());
        }
    }

    private static Instruction toInst(Contexte m) {
        Element current = listElt.poll();

        if (current.getName().equals("Sequence"))
            return new Sequence(toInst(m), toInst(m));

        if (current.getName().equals("Affectation"))
            return new Affectation((Variable) toExpr(m), toExpr(m));

        if (current.getName().equals("Selection")){
            if (current.getChildren().size() == 3)
                return new Selection(toBool(m), toInst(m), toInst(m));
            else
                return new Selection(toBool(m), toInst(m));
        }

        if (current.getName().equals("TantQue"))
            return new TantQue(toBool(m), toInst(m));

        if (current.getName().equals("Pour"))
            return new Pour(toInst(m), toBool(m), toInst(m), toInst(m));

        if (current.getName().equals("Afficher"))
            return new Afficher(toExpr(m));

        if (current.getName().equals("Assertion"))
            return new Assertion(toBool(m));

        return null;
    }

    private static Expression toExpr(Contexte m) {
        Element current = listElt.poll();

        if (current.getName().equals("Constante"))
            return new Constante(Integer.parseInt(current.getText()));

        if (current.getName().equals("Variable")) {
            return new Variable(m, current.getText());

        }

        if (current.getName().equals("Addition"))
            return new Addition(toExpr(m), toExpr(m));

        if (current.getName().equals("Soustraction"))
            return new Soustraction(toExpr(m), toExpr(m));

        if (current.getName().equals("Division"))
            return new Division(toExpr(m), toExpr(m));

        if (current.getName().equals("Multiplication"))
            return new Multiplication(toExpr(m), toExpr(m));

        return null;
    }

    private static ExpressionBooleenne toBool(Contexte m) {
        Element current = listElt.poll();

        if (current.getName().equals("Vrai"))
            return new Vrai();

        if (current.getName().equals("Faux"))
            return new Faux();

        if (current.getName().equals("Non"))
            return new Non(toBool(m));

        if (current.getName().equals("Ou"))
            return new Ou(toBool(m), toBool(m));

        if (current.getName().equals("Et"))
            return new Et(toBool(m), toBool(m));

        if (current.getName().equals("Inf"))
            return new Inf(toExpr(m), toExpr(m));

        if (current.getName().equals("Egal"))
            return new Egal(toExpr(m), toExpr(m));

        if (current.getName().equals("Sup"))
            return new Sup(toExpr(m), toExpr(m));

        return null;

    }
}
