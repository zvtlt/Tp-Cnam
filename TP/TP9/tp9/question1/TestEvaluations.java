package question1;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;

public class TestEvaluations extends junit.framework.TestCase {
    
    public void testSer() {

        IProgr p = new AST_SOM_F(10);
        
        try {
            JAVASerialiseDeserialise.serialjava(p, "question1/testSer.ser");
        } catch (Exception e){
            System.out.println("Erreur Svg" + e.getMessage());
        }
    }
    
    public void testSerDesFact() {
        
        IProgr fact = new AST_Fact(10);
        
        try {
            JAVASerialiseDeserialise.serialjava(fact, "question1/testFact.ser");
        } catch (Exception e) {
            fail("Erreur Svg" + e.getMessage());
        }

        IProgr factRestore = null;
        try {
            factRestore = JAVASerialiseDeserialise.deserialjava("question1/testFact.ser");
        } catch (Exception e) {
            fail("Erreur Restore" + e.getMessage());
        }

        Contexte restoreM = factRestore.getMem();

        VisiteurExpression<Integer> ve = new VisiteurEvaluation(restoreM);
        VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
        VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

        VisiteurExpression<String> ves = new VisiteurInfixe(restoreM);
        VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
        VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);

        Instruction ast = factRestore.getAST();
        Contexte t = ast.accepter(vi);

        assertEquals("{fact=3628800, n=10, xxx=0}", ast.accepter(vi).toString());
        assertEquals(fact.getAST().accepter(vi).toString(), t.toString());
    }

    public void testSerDesMult1() {
        
        IProgr mult1 = new AST_Mult1(10, 3);
        
        try {
            JAVASerialiseDeserialise.serialjava(mult1, "question1/testMult1.ser");
        } catch (Exception e) {
            fail("Erreur Svg" + e.getMessage());
        }

        IProgr Mult1Restore = null;
        try {
            Mult1Restore = JAVASerialiseDeserialise.deserialjava("question1/testMult1.ser");
        } catch (Exception e) {
            fail("Erreur Restore" + e.getMessage());
        }

        Contexte restoreM = Mult1Restore.getMem();

        VisiteurExpression<Integer> ve = new VisiteurEvaluation(restoreM);
        VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
        VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

        VisiteurExpression<String> ves = new VisiteurInfixe(restoreM);
        VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
        VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);

        Instruction ast = Mult1Restore.getAST();
        Contexte t = ast.accepter(vi);

        assertEquals("{a=10, b=0, produit=30}", t.toString());
        assertEquals(mult1.getAST().accepter(vi).toString(), t.toString());
    }

    public void testSerDesMult2(){
        
        IProgr mult2 = new AST_Mult2(10, 4);
        
        try {
            JAVASerialiseDeserialise.serialjava(mult2, "question1/testMult2.ser");
        } catch (Exception e) {
            fail("Erreur Svg" + e.getMessage());
        }

        IProgr Mult2Restore = null;
        try {
            Mult2Restore = JAVASerialiseDeserialise.deserialjava("question1/testMult2.ser");
        } catch (Exception e) {
            fail("Erreur Restore" + e.getMessage());
        }

        Contexte restoreM = Mult2Restore.getMem();

        VisiteurExpression<Integer> ve = new VisiteurEvaluation(restoreM);
        VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
        VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

        VisiteurExpression<String> ves = new VisiteurInfixe(restoreM);
        VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
        VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);

        Instruction ast = Mult2Restore.getAST();
        Contexte t = ast.accepter(vi);

        assertEquals("{m1=20, m2=0, produit=40}", t.toString());
        assertEquals(mult2.getAST().accepter(vi).toString(), t.toString());
    }

    public void testSerDesSomW(){
        
        IProgr somW = new AST_SOM_W(10);
        
        try {
            JAVASerialiseDeserialise.serialjava(somW, "question1/testSomW.ser");
        } catch (Exception e) {
            fail("Erreur Svg" + e.getMessage());
        }

        IProgr somWRestore = null;
        try {
            somWRestore = JAVASerialiseDeserialise.deserialjava("question1/testSomW.ser");
        } catch (Exception e) {
            fail("Erreur Restore" + e.getMessage());
        }

        Contexte restoreM = somWRestore.getMem();

        VisiteurExpression<Integer> ve = new VisiteurEvaluation(restoreM);
        VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
        VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

        VisiteurExpression<String> ves = new VisiteurInfixe(restoreM);
        VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
        VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);

        Instruction ast = somWRestore.getAST();
        Contexte t = ast.accepter(vi);

        assertEquals("{n=0, som=55}", t.toString());
        assertEquals(somW.getAST().accepter(vi).toString(), t.toString());
    }

    public void testSerDesSomF(){
        
        IProgr somF = new AST_SOM_F(10);
        
        try {
            JAVASerialiseDeserialise.serialjava(somF, "question1/testSomF.ser");
        } catch (Exception e) {
            fail("Erreur Svg" + e.getMessage());
        }

        IProgr somFRestore = null;
        try {
            somFRestore = JAVASerialiseDeserialise.deserialjava("question1/testSomF.ser");
        } catch (Exception e) {
            fail("Erreur Restore" + e.getMessage());
        }

        Contexte restoreM = somFRestore.getMem();

        VisiteurExpression<Integer> ve = new VisiteurEvaluation(restoreM);
        VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
        VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

        VisiteurExpression<String> ves = new VisiteurInfixe(restoreM);
        VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
        VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);

        Instruction ast = somFRestore.getAST();
        Contexte t = ast.accepter(vi);

        assertEquals("{i=10, n=10, som=45}",  t.toString());
        assertEquals(somF.getAST().accepter(vi).toString(), t.toString());
    }
}
