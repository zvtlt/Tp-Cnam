package question1;

public class EnsembleTest extends junit.framework.TestCase {
    
    public void testAdd(){
        question1.Ensemble<Integer> a = new question1.Ensemble<Integer>();

        assertEquals(true, a.add(2));       // test de l'ajout d'un objet
        assertEquals(1, a.size());

        assertFalse(a.add(2));              // test de l'ajout d'un objet en doublon
    }
    
    public void testAdd2(){
        question1.Ensemble<Integer> a, b;

        a = new question1.Ensemble<Integer>();
        b = new question1.Ensemble<Integer>();

        a.add(2); a.add(3);
        b.add(3); b.add(4);
        
        assertTrue(a.contains(2));      // test de contains()

        assertTrue(a.addAll(b));        // test de addAll()
        assertEquals(3,a.size());

        assertFalse(a.addAll(b));       // test de l'ajout d'une collection en doublon
        assertEquals(3,a.size());
    }

    public void testUnion() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));

        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));

        question1.Ensemble<Integer> union = e1.union(e2);
        assertEquals(3, union.size());
        assertTrue(union.contains(2));
        assertTrue(union.contains(3));
        assertTrue(union.contains(4));
    }
    
    public void testIntersection() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));

        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));

        question1.Ensemble<Integer> union = e1.inter(e2);
        assertEquals(1, union.size());
        assertTrue(union.contains(3));
    }
    
    public void testDifference() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));

        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));

        question1.Ensemble<Integer> union = e1.diff(e2);
        assertEquals(1, union.size());
        assertTrue(union.contains(2));
    }
    
    public void testDifferenceSymetrique() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));

        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));

        question1.Ensemble<Integer> union = e1.diffSym(e2);
        assertEquals(2, union.size());
        assertTrue(union.contains(2));
        assertTrue(union.contains(4));
    }
    
    public void testUnionString() {
        question1.Ensemble<String> e1, e2;
        e1 = new question1.Ensemble<String>();
        assertEquals(true, e1.add("aaa"));
        assertEquals(true, e1.add("bbb"));
        assertEquals(true, e1.add("ccc"));

        e2 = new question1.Ensemble<String>();
        assertEquals(true, e2.add("aaa"));
        assertEquals(true, e2.add("yyy"));
        assertEquals(true, e2.add("www"));
        

        question1.Ensemble<String> union = e1.union(e2);
        assertEquals(5, union.size());
        assertTrue(union.contains("aaa"));
        assertTrue(union.contains("bbb"));
        assertTrue(union.contains("ccc"));
        assertTrue(union.contains("yyy"));
        assertTrue(union.contains("www"));
    }
    
    public void testIntersectionString() {
        question1.Ensemble<String> e1, e2;
        e1 = new question1.Ensemble<String>();
        assertEquals(true, e1.add("aaa"));
        assertEquals(true, e1.add("bbb"));
        assertEquals(true, e1.add("ccc"));

        e2 = new question1.Ensemble<String>();
        assertEquals(true, e2.add("aaa"));
        assertEquals(true, e2.add("yyy"));
        assertEquals(true, e2.add("www"));
        

        question1.Ensemble<String> inter = e1.inter(e2);
        assertEquals(1, inter.size());
        assertTrue(inter.contains("aaa"));
    }
    
    public void testDifferenceString() {
        question1.Ensemble<String> e1, e2;
        e1 = new question1.Ensemble<String>();
        assertEquals(true, e1.add("aaa"));
        assertEquals(true, e1.add("bbb"));
        assertEquals(true, e1.add("ccc"));

        e2 = new question1.Ensemble<String>();
        assertEquals(true, e2.add("aaa"));
        assertEquals(true, e2.add("yyy"));
        assertEquals(true, e2.add("www"));
        

        question1.Ensemble<String> diff = e1.diff(e2);
        assertEquals(2, diff.size());
        assertTrue(diff.contains("bbb"));
        assertTrue(diff.contains("ccc"));
    }
    
    public void testDifferenceSymetriqueString() {
        question1.Ensemble<String> e1, e2;
        e1 = new question1.Ensemble<String>();
        assertEquals(true, e1.add("aaa"));
        assertEquals(true, e1.add("bbb"));
        assertEquals(true, e1.add("ccc"));

        e2 = new question1.Ensemble<String>();
        assertEquals(true, e2.add("aaa"));
        assertEquals(true, e2.add("yyy"));
        assertEquals(true, e2.add("www"));
        

        question1.Ensemble<String> diffSym = e1.diffSym(e2);
        assertEquals(4, diffSym.size());
        assertTrue(diffSym.contains("bbb"));
        assertTrue(diffSym.contains("ccc"));
        assertTrue(diffSym.contains("yyy"));
        assertTrue(diffSym.contains("www"));
    }
}
