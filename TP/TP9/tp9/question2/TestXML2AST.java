package question2;

import question1.*;
import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;

import org.jdom.*;
import org.jdom.output.*;
import org.jdom.input.*;

import java.io.*;

public class TestXML2AST extends junit.framework.TestCase {

    private String nomDuFichier;

    protected void setUp() {
        nomDuFichier = "test_tp9q2_XML2AST.xml";
    }

    protected void tearDown() {
        // try{
            // new File(nomDuFichier).delete();
        // }catch(Exception e){
        // }
    }

    public void test_XML2AST() {

        try {

            SerialiseDeserialiseAST_XML.serialAst2xml(new AST_Fact(10),    nomDuFichier);
            Element astXML = SerialiseDeserialiseAST_XML.deserialXml(nomDuFichier);

            Contexte m = new Memoire();
            Instruction inst = XML2AST.xmlInst2ast(m, astXML);

            m.ecrire("n", 5);
            VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

            VisiteurExpression<String> ves = new VisiteurInfixe(m);
            VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
            VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);
            inst.accepter(vi);

            assertTrue(m + inst.accepter(vs) + " ne donne pas le résultat attendu ...",    m.lire("fact") == fact(5));

        } catch (Exception e) {
            fail("exception inattendue !!! : " + e.getMessage());
        }
    }

    private static int fact(int n) {
        if (n == 0)
            return 1;
        else
            return n * fact(n - 1);
    }
    
    public void test_XML2ASTMult1() {
        try {
            nomDuFichier = nomDuFichier + "mult1";
            SerialiseDeserialiseAST_XML.serialAst2xml(new AST_Mult1(10, 3), nomDuFichier);
            Element astXMLMult1 = SerialiseDeserialiseAST_XML.deserialXml(nomDuFichier);

            Contexte m = new Memoire();
            Instruction inst = XML2AST.xmlInst2ast(m, astXMLMult1);

            m.ecrire("a", 10);
            m.ecrire("b", 3);

            VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

            VisiteurExpression<String> ves = new VisiteurInfixe(m);
            VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
            VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);
            inst.accepter(vi);

            assertEquals(" Mult1 ne donne pas le résultat attendu ...", (int) m.lire("produit"), question1.TestAST.mult1(10, 3));

        } catch (Exception e) {
            fail("exception inattendue !!! : " + e.getMessage());
        }
    }

    public void test_XMLASTMult2() {
        try {
            nomDuFichier = nomDuFichier + "mult2";
            SerialiseDeserialiseAST_XML.serialAst2xml(new AST_Mult2(10, 4), nomDuFichier);
            Element astXMLMult2 = SerialiseDeserialiseAST_XML.deserialXml(nomDuFichier);

            Contexte m = new Memoire();
            Instruction inst = XML2AST.xmlInst2ast(m, astXMLMult2);

            m.ecrire("m1", 10);
            m.ecrire("m2", 4);

            VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

            VisiteurExpression<String> ves = new VisiteurInfixe(m);
            VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
            VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);
            inst.accepter(vi);

            assertEquals(" Mult2 ne donne pas le résultat attendu ...", (int) m.lire("produit"), question1.TestAST.mult2(10, 4));

        } catch (Exception e) {
            fail("exception inattendue !!! : " + e.getMessage());
        }
    }

    public void test_XMLASTSOM_W() {
        try {
            nomDuFichier = nomDuFichier + "somW";
            SerialiseDeserialiseAST_XML.serialAst2xml(new AST_SOM_W(10), nomDuFichier);
            Element astXMLSomW = SerialiseDeserialiseAST_XML.deserialXml(nomDuFichier);

            Contexte m = new Memoire();
            Instruction inst = XML2AST.xmlInst2ast(m, astXMLSomW);

            m.ecrire("n", 10);

            VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

            VisiteurExpression<String> ves = new VisiteurInfixe(m);
            VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
            VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);
            inst.accepter(vi);

            assertEquals(" SOM_W ne donne pas le résultat attendu ...", (int) m.lire("som"), question1.TestAST.som_w(10));

        } catch (Exception e) {
            fail("exception inattendue !!! : " + e.getMessage());
        }
    }

    public void test_XMLASTSOM_F(){
        try {
            nomDuFichier = nomDuFichier + "somF";
            SerialiseDeserialiseAST_XML.serialAst2xml(new AST_SOM_F(10), nomDuFichier);
            Element astXMLSomF = SerialiseDeserialiseAST_XML.deserialXml(nomDuFichier);

            Contexte m = new Memoire();
            Instruction inst = XML2AST.xmlInst2ast(m, astXMLSomF);

            m.ecrire("n", 10);

            VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

            VisiteurExpression<String> ves = new VisiteurInfixe(m);
            VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
            VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);
            inst.accepter(vi);

            assertEquals(" SOM_F ne donne pas le résultat attendu ...", (int) m.lire("som"), question1.TestAST.som_f(10));

        } catch (Exception e) {
            fail("exception inattendue !!! : " + e.getMessage());
        }
    }

    public void test_VisiteurXml() {

        Contexte m = new Memoire();
        IProgr test = new AST_Fact(2);

        VisiteurExpression<Element> ve = new VisiteurJDOM(m);
        VisiteurExpressionBooleenne<Element> vb = new VisiteurBoolJDOM(ve);
        VisiteurInstruction<Element> vi = new VisiteurInstJDOM(ve, vb);

        Element racine = new Element("Programme");
        Document document = new Document(racine);
        racine.addContent(test.getAST().accepter(vi));
        try {
            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
            out.output(document, System.out);

        } catch (IOException e) {
            fail("Erreur");
        }
    }

    public void test_Parsing() {
        try {
            SerialiseDeserialiseAST_XML.serialAst2xml(new AST_Fact(10), nomDuFichier);
            Element astXML = SerialiseDeserialiseAST_XML.deserialXml(nomDuFichier);

            Contexte m = new Memoire();
            XML2AST.xmlInst2ast(m, astXML);

        } catch (Exception e) {
            fail("Erreur");
        }
    }
}
