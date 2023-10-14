package question2;

import question1.IProgr;

import org.jdom.*;
import org.jdom.output.*;
import org.jdom.input.*;


import java.io.*;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;



/**
 * Décrivez votre classe SerialiseDeserialiseAST_XML ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class SerialiseDeserialiseAST_XML {

    public static void serialAst2xml(IProgr p, String nomDuFichier)  throws IOException{
        // à compléter
        Contexte m = p.getMem();
        VisiteurExpression<Element> ve = new VisiteurJDOM(m);
        VisiteurExpressionBooleenne<Element> vb = new VisiteurBoolJDOM(ve);
        VisiteurInstruction<Element> vi = new VisiteurInstJDOM(ve, vb);

        Element racine = new Element("programme");
        Document document = new Document(racine);
        racine.addContent(p.getAST().accepter(vi));
        XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
        out.output(document, new FileOutputStream(nomDuFichier));
        
    }

    public static Element deserialXml(String nomDuFichier) throws Exception {
        // à compléter
        SAXBuilder sxb = new SAXBuilder();
        Document document = sxb.build(new File(nomDuFichier));
        return document.getRootElement();

    }
}