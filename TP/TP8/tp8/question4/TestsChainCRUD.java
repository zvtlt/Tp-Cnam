package question4;

import java.util.Properties;
public class TestsChainCRUD extends junit.framework.TestCase{
    public void setUp(){ 
        Table.getInstance().vider();
    }

 

    public void testCreate(){
        assertEquals(0, Table.getInstance().taille());
        Handler<Requete> chaine = new Create(null);
        Requete requete = new Requete("GET /create/?nom=temperature&valeur=20");
        boolean resultat = chaine.handleRequest(requete);
        assertTrue(resultat);
        assertEquals(1, Table.getInstance().taille());

        requete = new Requete("GET /create/?nom=jauge&valeur=200");
        resultat = chaine.handleRequest(requete);
        assertTrue(resultat);
        assertEquals(2, Table.getInstance().taille());
        assertTrue(Table.getInstance().contient("jauge"));
        assertTrue(Table.getInstance().contient("temperature"));
    }

    public void testCreateDeuxFoisMemeNom(){
        assertEquals(0, Table.getInstance().taille());
        Handler<Requete> chaine = new Create(null);
        Requete requete = new Requete("GET /create/?nom=temperature&valeur=20");
        boolean resultat = chaine.handleRequest(requete);
        assertTrue(resultat);
        assertEquals(1, Table.getInstance().taille());
        try{
            assertEquals(20,Table.getInstance().lire("temperature"));
        }catch(Throwable t){
            fail("aucune exception n'est attendue pour l'appel de lire ???");
        }

        requete = new Requete("GET /create/?nom=temperature&valeur=200");
        resultat = chaine.handleRequest(requete);
        assertTrue(resultat);
        assertEquals(1, Table.getInstance().taille());
        assertTrue(Table.getInstance().contient("temperature"));
        try{
            assertEquals(200,Table.getInstance().lire("temperature"));
        }catch(Throwable t){
            fail("aucune exception n'est attendue pour l'appel de lire ???");
        }
    }

    public void testRetrieve(){
        assertEquals(0, Table.getInstance().taille());
        Handler<Requete> chaine = new Create(new Retrieve(null));
        Requete requete = new Requete("GET /create/?nom=temperature&valeur=25");
        boolean resultat = chaine.handleRequest(requete);
        assertTrue(resultat);
        assertEquals(1, Table.getInstance().taille());

        requete = new Requete("GET /retrieve/?nom=temperature");
        resultat = chaine.handleRequest(requete);
        assertTrue(resultat);
        assertEquals(25, requete.getValeur());
    }

    public void testUpdate(){
        assertEquals(0, Table.getInstance().taille());
        Handler<Requete> chaine = new Create(new Retrieve(new Update(null)));
        Requete requete = new Requete("GET /create/?nom=temperature&valeur=25");
        boolean resultat = chaine.handleRequest(requete);
        assertTrue(resultat);
        assertEquals(1, Table.getInstance().taille());

        requete = new Requete("GET /retrieve/?nom=temperature");
        resultat = chaine.handleRequest(requete);
        assertTrue(resultat);
        assertEquals(25,Table.getInstance().lire("temperature"));

        requete = new Requete("GET /update/?nom=temperature&valeur=75");
        resultat = chaine.handleRequest(requete);
        assertTrue(resultat);
        assertEquals(75,Table.getInstance().lire("temperature"));
    }

    public void testDelete(){
        assertEquals(0, Table.getInstance().taille());
        Handler<Requete> chaine = new Create(new Delete(null));
        Requete requete = new Requete("GET /create/?nom=temperature&valeur=25");
        boolean resultat = chaine.handleRequest(requete);
        assertTrue(resultat);
        assertTrue( Table.getInstance().contient("temperature"));

        requete = new Requete("GET /delete/?nom=temperature");
        resultat = chaine.handleRequest(requete);
        assertTrue(resultat);
        assertFalse( Table.getInstance().contient("temperature"));

    }

    public void testDeleteAvecNomAbsent(){
        assertEquals(0, Table.getInstance().taille());
        Handler<Requete> chaine = new Create(new Delete(null));
        Requete requete = new Requete("GET /create/?nom=temperature&valeur=25");
        boolean resultat = chaine.handleRequest(requete);
        assertTrue(resultat);
        assertTrue( Table.getInstance().contient("temperature"));

        requete = new Requete("GET /delete/?nom=accelerometre");
        resultat = chaine.handleRequest(requete);
        assertTrue(resultat);
        assertTrue( Table.getInstance().contient("temperature"));

    }

    public void testCR(){
        assertEquals(0, Table.getInstance().taille());
        Handler<Requete> chaine = new Create(new Retrieve(null));
        assertEquals("Create->Retrieve", chaine.toString());

        Requete requete = new Requete("GET /create/?nom=temperature&valeur=200");
        boolean resultat = chaine.handleRequest(requete);
        assertTrue(Table.getInstance().contient("temperature"));
        assertEquals(200,Table.getInstance().lire("temperature"));

        requete = new Requete("GET /retrieve/?nom=temperature");
        resultat = chaine.handleRequest(requete);
        assertEquals(200, requete.getValeur());

    }

    public void testCRUD(){
        assertEquals(0, Table.getInstance().taille());
        Handler<Requete> chaine = new Log(new Create(new Retrieve( new Update( new Delete(null)))));
        assertEquals("Log->Create->Retrieve->Update->Delete", chaine.toString());

        Requete requete = new Requete("GET /create/?nom=temperature&valeur=200");
        boolean resultat = chaine.handleRequest(requete);
        assertTrue(Table.getInstance().contient("temperature"));
        assertEquals(200,Table.getInstance().lire("temperature"));

        requete = new Requete("GET /update/?nom=temperature&valeur=40");
        resultat = chaine.handleRequest(requete);
        assertEquals(40,Table.getInstance().lire("temperature"));

        requete = new Requete("GET /retrieve/?nom=temperature");
        resultat = chaine.handleRequest(requete);
        assertEquals(40, requete.getValeur());

        requete = new Requete("GET /delete/?nom=temperature");
        resultat = chaine.handleRequest(requete);
        assertFalse(Table.getInstance().contient("temperature"));

        requete = new Requete("GET /create/?nom=jauge&valeur=1000");
        resultat = chaine.handleRequest(requete);
        assertTrue(Table.getInstance().contient("jauge"));

        int tailleAvant = Table.getInstance().taille();
        requete = new Requete("GET /commande_inconnue/?nom=jauge&valeur=1000");
        resultat = chaine.handleRequest(requete);
        assertEquals(tailleAvant, Table.getInstance().taille());

    }

    public void testCreateAvecErreursPossibles(){
        assertEquals(0, Table.getInstance().taille());
        Handler<Requete> chaine = new Create(new Retrieve( new Update( new Delete(null))));
        assertEquals("Create->Retrieve->Update->Delete", chaine.toString());

        Requete requete = new Requete("GET /create/?name=temperature&valeur=200");
        try{
            boolean resultat = chaine.handleRequest(requete);
            fail("Une 'RuntimeException est attendue, si le parametre \"nom\" est absent de la requête");
        }catch(Throwable e){
            assertTrue(e instanceof RuntimeException);
        }
    }

    public void testUpdateAvecErreursPossibles(){
        Requete requete = new Requete("GET /update/?name=temperature&valeur=40");
        Handler<Requete> chaine = new Create(new Retrieve( new Update( new Delete(null))));

        try{
            boolean resultat = chaine.handleRequest(requete);
            fail("Une 'RuntimeException est attendue, si le parametre \"nom\" est absent de la requête");
        }catch(Throwable e){
            assertTrue(e instanceof RuntimeException);
        }
    }

    public void testRetrieveAvecErreursPossibles(){
        
        Handler<Requete> chaine = new Create(new Retrieve( new Update( new Delete(null))));
        
        try{
            Requete requete = new Requete("GET /retrieve/?xxx=temperature");
            boolean resultat = chaine.handleRequest(requete);
            fail("Une 'RuntimeException' est attendue, si le parametre \"nom\" est absent de la requête");
        }catch(Throwable e){
            assertTrue(e instanceof RuntimeException);
        }
    }
    
     public void testDeleteAvecErreursPossibles(){
        Requete requete = new Requete("GET /delete/?zzz=temperature");
        Handler<Requete> chaine = new Create(new Retrieve( new Update( new Delete(null))));

        try{
            boolean resultat = chaine.handleRequest(requete);
            fail("Une 'RuntimeException est attendue, si le parametre \"nom\" est absent de la requête");
        }catch(Throwable e){
            assertTrue(e instanceof RuntimeException);
        }
    }
    

    public void testCRUD_Puis_RUD_Puis_RU(){
        assertEquals(0, Table.getInstance().taille());
        Handler<Requete> chaine = new Log(new Create(new Retrieve( new Update( new Delete(null)))));
        // chaine CRUD
        assertEquals("Log->Create->Retrieve->Update->Delete", chaine.toString());

        chaine.handleRequest(new Requete("GET /create/?nom=temperature&valeur=200"));
        chaine.handleRequest(new Requete("GET /create/?nom=jauge&valeur=2000"));
        assertEquals(2, Table.getInstance().taille());

        chaine.setNext(chaine.getNext().getNext());
        // Chaine RUD (pas tant que ça ;-))
        assertEquals("Log->Retrieve->Update->Delete", chaine.toString());

        // pas C(reate) possible RUD
        assertFalse(chaine.handleRequest(new Requete("GET /create/?nom=pluviometre&valeur=20")));
        assertEquals(2, Table.getInstance().taille());

        assertTrue(chaine.handleRequest(new Requete("GET /update/?nom=temperature&valeur=40")));
        assertEquals(40,Table.getInstance().lire("temperature"));

        Requete requete = new Requete("GET /retrieve/?nom=temperature");
        assertTrue(chaine.handleRequest(requete));
        assertEquals(40, requete.getValeur());

        assertTrue(chaine.handleRequest(new Requete("GET /delete/?nom=temperature")));
        assertFalse(Table.getInstance().contient("temperature"));

        chaine.getNext().getNext().setNext(null);
        // Chaine RU
        assertEquals("Log->Retrieve->Update", chaine.toString());

    }

    public void testCRUD_Debug(){
        assertEquals(0, Table.getInstance().taille());
        Handler<Requete> chaine = new Log(new Create(new Retrieve( new Update( new Delete(new Debug(null))))));
        assertEquals("Log->Create->Retrieve->Update->Delete->Debug", chaine.toString());
        chaine.handleRequest(new Requete("GET /create/?nom=temperature&valeur=200"));
        chaine.handleRequest(new Requete("GET /create/?nom=jauge&valeur=2000"));
        // debug
        Requete  requete = new Requete("GET /debug/");
        chaine.handleRequest(requete);
        Properties properties = requete.getProperties();
        assertNotNull(properties);
        assertEquals(2,properties.size());
        assertEquals("200",properties.getProperty("temperature"));
        assertEquals("2000",properties.getProperty("jauge"));
        chaine.handleRequest(new Requete("GET /delete/?nom=jauge&valeur=2000"));

        requete = new Requete("GET /debug/");
        chaine.handleRequest(requete);
        properties = requete.getProperties();
        assertNotNull(properties);
        assertEquals(1,properties.size());
        assertEquals("200",properties.getProperty("temperature"));
        assertEquals(null,properties.getProperty("jauge"));

    }

    public void testC_Debug_RUD(){
        assertEquals(0, Table.getInstance().taille());
        Handler<Requete> chaine = new Log(new Create(new Retrieve( new Update( new Delete(null)))));
        Handler<Requete> debug = new Debug(chaine.getNext().getNext());
        chaine.getNext().setNext(debug);
        assertEquals("Log->Create->Debug->Retrieve->Update->Delete", chaine.toString());
        chaine.handleRequest(new Requete("GET /create/?nom=temperature&valeur=200"));
        chaine.handleRequest(new Requete("GET /create/?nom=jauge&valeur=2000"));

        Requete requete = new Requete("GET /debug/");
        chaine.handleRequest(requete);
        Properties properties = requete.getProperties();
        assertNotNull(properties);
        assertEquals(2,properties.size());
        assertEquals("200",properties.getProperty("temperature"));
        assertEquals("2000",properties.getProperty("jauge"));
    }

    public void testDebugSeul(){
        assertEquals(0, Table.getInstance().taille());
        Handler<Requete> chaine = new Debug(null);
        assertEquals("Debug", chaine.toString());
        chaine.handleRequest(new Requete("GET /create/?nom=temperature&valeur=200"));
        chaine.handleRequest(new Requete("GET /create/?nom=jauge&valeur=2000"));
        // debug
        Requete  requete = new Requete("GET /debug/");

        requete = new Requete("GET /debug/");
        chaine.handleRequest(requete);
        Properties properties = requete.getProperties();
        assertNotNull("mode /debug/ getProperties()==null ???",properties);
        assertEquals("mode /debug/ getProperties().size() != 0 ???",0,properties.size());
    }

}