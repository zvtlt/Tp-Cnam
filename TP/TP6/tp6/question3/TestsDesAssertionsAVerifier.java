package question3;

import question1.*;
import question2.*;

public class TestsDesAssertionsAVerifier extends junit.framework.TestCase{

    public void testAssertionSucces(){
        Contexte m = new Memoire();
        Variable x = new Variable(m,"x",5);
        VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
        VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
        VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve,vb);

        VisiteurExpression<String> ves = new VisiteurInfixe(m);
        VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
        VisiteurInstruction<String> vs = new VisiteurInstToString(ves,vbs);

        Instruction i = new Assertion(new Egal(x,new Constante(5)));
        try{
            i.accepter(vi);
        }catch(AssertionError ae){
            fail("attention, assert a levé une exception ???");
        }
    }

    public void testAssertionError(){
        Contexte m = new Memoire();
        Variable x = new Variable(m,"x",5);
        VisiteurExpression ve = new VisiteurEvaluation(m);
        VisiteurExpressionBooleenne vb = new VisiteurBoolEvaluation(ve);
        VisiteurInstruction vi = new VisiteurInstEvaluation(ve,vb);

        VisiteurExpression ves = new VisiteurInfixe(m);
        VisiteurExpressionBooleenne vbs = new VisiteurBoolToString(ves);
        VisiteurInstruction vs = new VisiteurInstToString(ves,vbs);

        Instruction i = new Assertion(new Egal(x,new Constante(6)));
        try{
            i.accepter(vi);
            fail();
        }catch(junit.framework.AssertionFailedError e){
            fail("attention, " + i.accepter(vs) + " est-il sans effet ???");
        }catch(AssertionError e){

        }

    }     
}
