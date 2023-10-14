package question2;

import question1.*;
import java.util.*;
import java.io.*;
import org.jdom.*;
import org.jdom.output.*;

public class TestsCompositeCyclique extends junit.framework.TestCase{

    public void testAjouterAuGroupeUnContributeurEgal_null(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            g.ajouter(null);
            fail("Une exception est attendue !!! (cf assert, GroupeDeContributeurs.java:19)");
            g.ajouter(new Contributeur("g_c",300));

        }catch(Throwable t){
            assertTrue(true); // ...
        }
    }

    public void testCompositeCyclique(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            g.ajouter(g);
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(100)));
        }catch(StackOverflowError soe){
            fail("exception: appel récursif sans terminaison, le composite testé est cyclique");
        }catch(Throwable e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testCompositeCyclique2(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g.ajouter(g1);
            g1.ajouter(g);
            g1.ajouter(new Contributeur("g1_a",100));
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
        }catch(StackOverflowError soe){
            fail("exception: appel récursif sans terminaison, le composite testé est cyclique ");
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testCompositeCyclique3(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g.ajouter(g1);
            g1.ajouter(new Contributeur("g1_a",100));
            g1.ajouter(g);
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
        }catch(StackOverflowError soe){
            fail("exception: appel récursif sans terminaison, le composite testé est cyclique");
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testCompositeCyclique4(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g.ajouter(g1);
            g1.ajouter(new Contributeur("g1_a",100));
            g1.ajouter(g);
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
        }catch(StackOverflowError soe){
            fail("exception: appel récursif sans terminaison, le composite testé est cyclique");
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

  
    public void testCompositeInvalideDeuxAppelsSetParent(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g1.ajouter(new Contributeur("g1_a",100));
            GroupeDeContributeurs g2 = new GroupeDeContributeurs("g2");
            g2.ajouter(new Contributeur("g2_a",100));
            GroupeDeContributeurs g3 = new GroupeDeContributeurs("g3");
            g3.ajouter(new Contributeur("g3_a",100));

            g.ajouter(g1);
            g.ajouter(g2);
            g2.ajouter(g3);
            g.ajouter(g3);
            fail("Une exception est attendue !!! (cf assert, GroupeDeContributeurs.java:19)");

        }catch(Throwable t){
            assertTrue(true); // ...
        }
    }

}
