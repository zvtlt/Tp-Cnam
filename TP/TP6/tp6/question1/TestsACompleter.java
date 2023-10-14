package question1;

public class TestsACompleter extends junit.framework.TestCase{
    private Memoire m;
    private Variable i,j,k,l;
    private VisiteurExpression<Integer> ve;
    private VisiteurExpression<String>  vp,vi;

    public void setUp(){
        m  = new Memoire();
        i  = new Variable(m,"i",3);
        j = new Variable(m,"j",5);
        k = new Variable(m,"k",7);
        l = new Variable(m,"l",9);
        ve = new VisiteurEvaluation( m);
        vi = new VisiteurInfixe( m);
        vp = new VisiteurPostfixe( m);
        assertNotNull(i);assertNotNull(j);
        assertNotNull(ve);assertNotNull(vp);assertNotNull(vi);
    }

    public void testUneAddition(){
        Expression expr = new Addition(new Constante(3), new Constante(2));
        assertEquals(" 3+2 != 5 ?, curieux ",5,expr.accepter(ve).intValue());
    }

    public void testMultiplication(){
        Expression expr = new Multiplication(new Constante(3), new Constante(2));
        assertEquals(" 3*2 != 6 ?, curieux ",6,expr.accepter(ve).intValue());
        expr = new Multiplication(expr,expr);
        assertEquals(" 6*6 != 36 ?, curieux ",36,expr.accepter(ve).intValue());
        expr = new Multiplication(expr,j);
        assertEquals(" 36*5 != 180 ?, curieux ",180,expr.accepter(ve).intValue());
        // à compléter
        // à compléter
        // à compléter
    }

    public void testSoustraction(){
        Expression expr = new Soustraction(new Constante(3), new Constante(2));
        assertEquals(" 3-2 != 1 ?, curieux ",1,expr.accepter(ve).intValue());
        expr = new Soustraction(expr,expr);
        assertEquals(" 1-1 != 0 ?, curieux ",0,expr.accepter(ve).intValue());
        expr = new Soustraction(expr,j);
        assertEquals(" 0-5 != -5 ?, curieux ",-5,expr.accepter(ve).intValue());
        // à compléter
        // à compléter
        // à compléter 
    }

    public void testDivision(){
        Expression expr = new Division(new Constante(100), new Constante(2));
        assertEquals(" 100/2 != 50 ?, curieux ",50,expr.accepter(ve).intValue());
        expr = new Division(expr,j);
        assertEquals(" 50/5 != 10 ?, curieux ",10,expr.accepter(ve).intValue());
        expr = new Division(expr,expr);
        assertEquals(" 10/10 != 1 ?, curieux ",1,expr.accepter(ve).intValue());
        // à compléter
        // à compléter
        // à compléter

        try{
            new Division(i,new Constante(0)).accepter(ve);
            fail("division par zéro ? possible ");
        }catch(ArithmeticException ae){
        }
    }

    public void testVisiteurInfixe(){

        Expression expr = new Division(new Constante(10), new Constante(2));
        assertEquals("(10 / 2)", expr.accepter(vi));
        expr = new Soustraction(expr, new Constante(2));
        assertEquals("((10 / 2) - 2)", expr.accepter(vi));
        Expression expr2 = new Constante(10);
        expr = new Addition(expr, expr2);
        
        //System.out.println(expr.accepter(vi));
        assertEquals("(((10 / 2) - 2) + 10)", expr.accepter(vi));

    }

    public void testVisiteurPostfixe(){
        Expression expr = new Division(new Constante(10), new Constante(2));
        assertEquals("(10,2)/", expr.accepter(vp));
        expr = new Soustraction(expr, new Constante(2));
        assertEquals("((10,2)/,2)-", expr.accepter(vp));
        Expression expr2 = new Constante(10);
        expr = new Addition(expr, expr2);
        
        //System.out.println(expr.accepter(vi));
        assertEquals("(((10,2)/,2)-,10)+", expr.accepter(vp));
        
        // à compléter
        // à compléter
        // à compléter
    }

    // à compléter
    // à compléter
    // à compléter

}
