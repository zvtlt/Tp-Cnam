package question2;

import question1.*;

public class TestsDuVisiteurBoolToJava extends junit.framework.TestCase {

    protected Contexte m;
    protected VisiteurExpressionBooleenne<String> vbs;

    public void setUp() {
        m = new Memoire();
        vbs = new VisiteurBoolToJava(new VisiteurInfixe(m));
    }

    public void testVisiteurBoolString() {
        assertEquals("true", new Vrai().accepter(vbs));
        assertEquals("false", new Faux().accepter(vbs));
        assertEquals("(5 > 8)", new Sup(new Constante(5), new Constante(8)).accepter(vbs));
        assertEquals("((5 + 3) == 8)", new Egal(new Addition(new Constante(5), new Constante(3)), new Constante(8)).accepter(vbs));
        assertEquals("(i < j)", new Inf(new Variable(m, "i"), new Variable(m, "j")).accepter(vbs));
        assertEquals("(i < (j + 1))",
                new Inf(new Variable(m, "i"),
                    new Addition(new Variable(m, "j"), new Constante(1))).accepter(vbs));
        assertEquals("((i > j) || (i < j))",
                new Ou(new Sup(new Variable(m, "i"), new Variable(m, "j")),
                    new Inf(new Variable(m, "i"), new Variable(m, "j"))).accepter(vbs));
        assertEquals("((i > j) && (i < j))",
                new Et(new Sup(new Variable(m, "i"), new Variable(m, "j")),
                    new Inf(new Variable(m, "i"), new Variable(m, "j"))).accepter(vbs));
    }

}
