package question1;

import tp6.question1.Contexte;
import tp6.question1.VisiteurEvaluation;
import tp6.question1.VisiteurExpression;
import tp6.question1.VisiteurInfixe;
import tp6.question2.VisiteurBoolEvaluation;
import tp6.question2.VisiteurBoolToString;
import tp6.question2.VisiteurExpressionBooleenne;
import tp6.question3.Instruction;
import tp6.question3.VisiteurInstEvaluation;
import tp6.question3.VisiteurInstToString;
import tp6.question3.VisiteurInstruction;

public class TestAST extends junit.framework.TestCase {

    public static int mult1(int a, int b) {
        int produit = 0;
        while (b > 0) {
            produit += a;
            b -= 1;
        }
        return produit;
    }

    public static int mult2(int n1, int n2) {
        int m1 = n1;
        int m2 = n2;
        int produit = 0;
        while (m2 > 0) {
            if ((m2 / 2) * 2 == m2) {
                m1 = m1 * 2;
                m2 = m2 / 2;
            }
            produit = produit + m1;
            m2 = m2 - 1;
        }
        return produit;
    }

    public static int som_w(int n) {
        int som = 0;
        while (n > 0) {
            som += n;
            n -= 1;
        }
        return som;
    }

    public static int som_f(int n) {
        int som = 0;
        if (n > 0)
            for (int i = 0; i < n; i++)
                som += i;
        return som;
    }

    public void testMult1() {
        try {
            assertEquals("Devrait être 30, revoir methode statique", 30, TestAST.mult1(10, 3));
        } catch (Exception e) {
            fail("revoir methode statique");
        }

        try {
            AST_Mult1 p = new AST_Mult1(10, 3);
            Contexte m = p.getMem();

            VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

            VisiteurExpression<String> ves = new VisiteurInfixe(m);
            VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
            VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);

            Instruction ast = p.getAST();
            
            assertEquals("{a=10, b=0, produit=30}", ast.accepter(vi).toString());
            assertEquals(ast.accepter(vs) + " ne donne pas le résultat attendu ...", (int) m.lire("produit"), TestAST.mult1(10, 3));
        } catch (Exception e) {
            fail("erreur" + e.getMessage());
        }
    }

    public void testMult2() {

        try {
            assertEquals("Devrait être 40, revoir methode statique", 40, TestAST.mult2(10, 4));
        } catch (Exception e) {
            fail("revoir methode statique");
        }

        try {
            AST_Mult2 p = new AST_Mult2(10, 4);
            Contexte m = p.getMem();

            VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

            VisiteurExpression<String> ves = new VisiteurInfixe(m);
            VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
            VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);

            Instruction ast = p.getAST();
            
            assertEquals("{m1=20, m2=0, produit=40}", ast.accepter(vi).toString());
            assertEquals(ast.accepter(vs) + " ne donne pas le résultat attendu ...", (int) m.lire("produit"), TestAST.mult2(10, 4));
        } catch (Exception e) {
            fail("erreur" + e.getMessage());
        }
    }

    public void testSomW() {
        try {
            assertEquals("Devrait être egal a 55, revoir la methode statique", 55, TestAST.som_w(10));
        } catch (Exception e) {
            fail("revoir methode statique" + e.getMessage());
        }
        
        try {
            AST_SOM_W p = new AST_SOM_W(10);
            Contexte m = p.getMem();

            VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

            VisiteurExpression<String> ves = new VisiteurInfixe(m);
            VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
            VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);

            Instruction ast = p.getAST();
            
            Contexte t = ast.accepter(vi);

            assertEquals(ast.accepter(vs) + " ne donne pas le résultat attendu ...", (int) m.lire("som"), TestAST.som_w(10));
            assertEquals("{n=0, som=55}", t.toString());
        } catch (Exception e) {
            fail("erreur" + e.getMessage());
        }
    }

    public void testSomF(){
        try {
            assertEquals("Devrait être egal a 45, revoir la methode statique", 45, TestAST.som_f(10));
        } catch (Exception e) {
            fail("revoir methode statique" + e.getMessage());
        }

        try {
            AST_SOM_F p = new AST_SOM_F(10);
            Contexte m = p.getMem();

            VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

            VisiteurExpression<String> ves = new VisiteurInfixe(m);
            VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
            VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);

            Instruction ast = p.getAST();
            Contexte t = ast.accepter(vi);

            assertEquals(ast.accepter(vs) + " ne donne pas le résultat attendu ...", (int) m.lire("som"), TestAST.som_f(10));
            assertEquals("{i=10, n=10, som=45}", t.toString());
        } catch (Exception e) {
            fail("erreur" + e.getMessage());
        }
    }
}
