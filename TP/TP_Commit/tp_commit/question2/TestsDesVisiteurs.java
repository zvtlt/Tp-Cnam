package question2;

import java.util.*;
import question1.*;

public class TestsDesVisiteurs extends junit.framework.TestCase{

    public void testACompleter(){
        // fail(" cette méthode de tests, est à compléter, appels des trois visiteurs....");
        try{  
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",150));
            g.ajouter(new Contributeur("g_b",200));
            g.ajouter(new Contributeur("g_c",300));
            g.ajouter(new Contributeur("g_c",300));

            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(200)));
            assertFalse(" Ce composite a un doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
            assertEquals(" Revoyez DébitMaximal !!!", new Integer(150), g.accepter(new DebitMaximal()));

        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }


    public void testTroisContributeurs(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            g.ajouter(new Contributeur("g_b",200));
            g.ajouter(new Contributeur("g_c",300));
            assertEquals("Le nombre de cotisants est-il erroné ???", 3, g.nombreDeCotisants());
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(100)));
            assertTrue(" Ce composite n'a pas de doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
            assertEquals(" Revoyez DébitMaximal !!!",new Integer(100), g.accepter(new DebitMaximal()));
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testQuatreContributeursUnGroupe(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            g.ajouter(new Contributeur("g_b",200));
            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g1.ajouter(new Contributeur("g1_a",20));
            g.ajouter(g1);
            g.ajouter(new Contributeur("g_c",300));
            assertEquals("Le nombre de cotisants est-il erroné ???", 4, g.nombreDeCotisants());
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(20)));
            assertTrue(" Ce composite n'a pas de doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
            assertEquals(" Revoyez DébitMaximal !!!",new Integer(20), g.accepter(new DebitMaximal()));
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testCompositeValide(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
            assertTrue(" Ce composite n'a pas de doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));

            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g1.accepter(new CompositeValide(0)));
            assertTrue(" Ce composite n'a pas de doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));

            g1.ajouter(new Contributeur("c",100));
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g1.accepter(new CompositeValide(0)));
            g.ajouter(g1);
            assertEquals("Le nombre de cotisants est-il erroné ???", 1, g.nombreDeCotisants());
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
            assertTrue(" Ce composite n'a pas de doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
            assertEquals("Le nombre de cotisants est-il erroné ???", 1, g.nombreDeCotisants());
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testCompositeValide_bis(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            assertTrue(" Ce composite n'a pas de doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));

            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            assertTrue(" Ce composite n'a pas de doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));

            GroupeDeContributeurs g2 = new GroupeDeContributeurs("g2");
            g2.ajouter(new Contributeur("c",100));

            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g2.accepter(new CompositeValide(0)));
            assertEquals(" Revoyez DébitMaximal !!!",new Integer(100), g2.accepter(new DebitMaximal()));
            g.ajouter(g1);
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
            assertTrue(" Ce composite n'a pas de doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
            g1.ajouter(g2);
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
            assertEquals("Le nombre de cotisants est-il erroné ???", 1, g.nombreDeCotisants());
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }


    public void testQuatreContributeursDeuxGroupes(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            g.ajouter(new Contributeur("g_b",200));
            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g1.ajouter(new Contributeur("g_c",300));
            g1.ajouter(new Contributeur("g_d",80));
            g.ajouter(g1);
            assertEquals("Le nombre de cotisants est-il erroné ???", 4, g.nombreDeCotisants());
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
            assertTrue(" Ce composite n'a pas de doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
            assertEquals(" Revoyez DébitMaximal !!!",new Integer(80), g.accepter(new DebitMaximal()));
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testQuatreContributeursQuatreGroupes(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g1.ajouter(new Contributeur("g_b",200));
            GroupeDeContributeurs g2 = new GroupeDeContributeurs("g2");
            g2.ajouter(new Contributeur("g_c",300));
            GroupeDeContributeurs g3 = new GroupeDeContributeurs("g3");
            g3.ajouter(new Contributeur("g_d",80));
            g.ajouter(g1);
            g1.ajouter(g2);
            g2.ajouter(g3);
            assertEquals("Le nombre de cotisants est-il erroné ???", 4, g.nombreDeCotisants());
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
            assertTrue(" Ce composite n'a pas de doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
            assertEquals(" Revoyez DébitMaximal !!!",new Integer(80), g.accepter(new DebitMaximal()));
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testLeMemeContributeurPresentDeuxFois(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            g.ajouter(new Contributeur("g_b",200));
            g.ajouter(new Contributeur("g_a",300));
            g.ajouter(new Contributeur("g_d",80));
            assertEquals("Le nombre de cotisants est-il erroné ???", 4, g.nombreDeCotisants());

            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
            assertFalse(" Ce composite a un doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }


    public void testUnContributeurUnGroupeAvecLeMemeNom(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g_a");
            g.ajouter(new Contributeur("g_a",100));
            g.ajouter(new Contributeur("g_b",200));
            g.ajouter(new Contributeur("g_c",300));
            g.ajouter(new Contributeur("g_d",80));
            assertEquals("Le nombre de cotisants est-il erroné ???", 4, g.nombreDeCotisants());

            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide(0)));
            assertFalse(" Ce composite a au moins un doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testUnGroupeAvecUnSoldeDebiteurDuPremierContributeur(){
        try{
            Contributeur a = new Contributeur("a",100);
            Contributeur b = new Contributeur("b",200);
            Contributeur c = new Contributeur("c",300);

            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(a);g.ajouter(b);g.ajouter(c);

            assertTrue(" nombre de Contributeurs ??? ", g.nombreDeCotisants() == 3);
            assertTrue(" solde erroné ??? ", g.solde()==600);

            try{
                g.debit(120);
            }catch(Exception e){
                assertTrue(" SoldeDebiteurException est attendue ???", e instanceof SoldeDebiteurException);
            }

            // pour ce test, les comptes des  Contributeurs sont intacts
            assertTrue(" à la question2 seulement l'atomicité est souhaitée ", a.solde()==100);
            assertTrue(" à la question2 seulement l'atomicité est souhaitée ", b.solde()==200);
            assertTrue(" à la question2 seulement l'atomicité est souhaitée ", c.solde()==300);        
            assertTrue(" solde erroné ??? ", g.solde()==600);

        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testUnGroupeAvecUnSoldeDebiteurDuDernierContributeur(){
        try{
            Contributeur a = new Contributeur("a",300);
            Contributeur b = new Contributeur("b",200);
            Contributeur c = new Contributeur("c",100);

            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(a);g.ajouter(b);g.ajouter(c);

            assertEquals(" nombre de Contributeurs ??? ",3, g.nombreDeCotisants() );
            assertEquals(" solde erroné ??? ", 600, g.solde());

            try{
                g.debit(120);
            }catch(Exception e){
                assertTrue(" SoldeDebiteurException est attendue ???", e instanceof SoldeDebiteurException);
            }
            //System.out.println(g);
            // pour ce test, les comptes des  Contributeurs b & c ont été débités, et le débit a échoué
            assertTrue(" à la question3 seulement l'atomicité est souhaitée ", a.solde()==180);
            assertTrue(" à la question3 seulement l'atomicité est souhaitée ", b.solde()==80);
            assertTrue(" à la question3 seulement l'atomicité est souhaitée ", c.solde()==100);        
            assertTrue(" solde erroné ??? ", g.solde()==(180+80+100));

        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }


    public void testIteratorSurUnGroupeDeGroupes(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            g.ajouter(new Contributeur("g_b",200));
            g.ajouter(new Contributeur("g_c",300));
            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g1.ajouter(new Contributeur("g1_a",100));
            g1.ajouter(new Contributeur("g1_b",200));
            GroupeDeContributeurs g11 = new GroupeDeContributeurs("g11");
            g11.ajouter(new Contributeur("g11_a",100));
            g1.ajouter(g11);
            GroupeDeContributeurs g2 = new GroupeDeContributeurs("g2");
            g2.ajouter(new Contributeur("g2_a",100));
            g2.ajouter(new Contributeur("g2_b",200));
            g2.ajouter(new Contributeur("g2_c",100));
            g2.ajouter(new Contributeur("g2_d",200));

            g.ajouter(g1);
            g.ajouter(g2);

            Iterator<Cotisant> it = g.iterator();
            assertTrue(" est-ce le bon Compte ?, un Contributeur est attendu !", it.next() instanceof Contributeur);
            assertTrue(" est-ce le bon Compte ?, un Contributeur est attendu !", it.next() instanceof Contributeur);
            assertTrue(" est-ce le bon Compte ?, un Contributeur est attendu !", it.next() instanceof Contributeur);
            assertTrue(" est-ce le bon Compte ?, un GroupeDeContributeurs est attendu !", it.next() instanceof GroupeDeContributeurs);     // g1
            assertTrue(" est-ce le bon Compte ?, un Contributeur est attendu !", it.next() instanceof Contributeur);
            assertTrue(" est-ce le bon Compte ?, un Contributeur est attendu !", it.next() instanceof Contributeur);
            assertTrue(" est-ce le bon Compte ?, un GroupeDeContributeurs est attendu !", it.next() instanceof GroupeDeContributeurs);     // g11
            assertTrue(" est-ce le bon Compte ?, un Contributeur est attendu !", it.next() instanceof Contributeur);
            assertTrue(" est-ce le bon Compte ?, un GroupeDeContributeurs est attendu !", it.next() instanceof GroupeDeContributeurs);     // g2
            assertTrue(" est-ce le bon Compte ?, un Contributeur est attendu !", it.next() instanceof Contributeur);        
            assertTrue(" est-ce le bon Compte ?, un Contributeur est attendu !", it.next() instanceof Contributeur);
            assertTrue(" est-ce le bon Compte ?, un Contributeur est attendu !", it.next() instanceof Contributeur);
            assertTrue(" est-ce le bon Compte ?, un Contributeur est attendu !", it.next() instanceof Contributeur);

            try{
                it.next();
            }catch(Exception ex){
                assertTrue(" NoSuchElementException est attendu ??? ", ex instanceof NoSuchElementException);
            }       
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testGetChildrenSurUnGroupeDeGroupes(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            g.ajouter(new Contributeur("g_b",200));
            g.ajouter(new Contributeur("g_c",300));
            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g1.ajouter(new Contributeur("g1_a",100));
            g1.ajouter(new Contributeur("g1_b",200));
            GroupeDeContributeurs g11 = new GroupeDeContributeurs("g11");
            g11.ajouter(new Contributeur("g11_a",100));
            g1.ajouter(g11);
            GroupeDeContributeurs g2 = new GroupeDeContributeurs("g2");
            g2.ajouter(new Contributeur("g2_a",100));
            g2.ajouter(new Contributeur("g2_b",200));
            g2.ajouter(new Contributeur("g2_c",100));
            g2.ajouter(new Contributeur("g2_d",200));

            g.ajouter(g1);
            g.ajouter(g2);

            Iterator<Cotisant> it = g.getChildren().iterator();
            assertTrue(" est-ce le bon Cotisant ?, un Contributeur est attendu !", it.next() instanceof Contributeur); // g_a
            assertTrue(" est-ce le bon Cotisant ?, un Contributeur est attendu !", it.next() instanceof Contributeur); // g_b
            assertTrue(" est-ce le bon Cotisant ?, un Contributeur est attendu !", it.next() instanceof Contributeur); // g_c
            assertTrue(" est-ce le bon Cotisant ?, un GroupeDeContributeurs est attendu !", it.next() instanceof GroupeDeContributeurs);     // g1
            assertTrue(" est-ce le bon Cotisant ?, un GroupeDeContributeurs est attendu !", it.next() instanceof GroupeDeContributeurs);     // g2
            try{
                it.next();
            }catch(Exception ex){
                assertTrue(" NoSuchElementException est attendu ??? ", ex instanceof NoSuchElementException);
            }       
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }



}
