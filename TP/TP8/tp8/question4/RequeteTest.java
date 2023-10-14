package question4;


public class RequeteTest extends junit.framework.TestCase{
    public void setUp(){ 

    }

    public void testCreationRequete1(){

        Requete requete = new Requete("GET /create/?nom=temperature&valeur=20");

        assertEquals("requete.getCommande() en défaut ???","create", requete.getCommande());
        assertEquals("requete.getNom() en défaut ???","temperature", requete.getNom());
        assertEquals("requete.getValeur() en défaut ???",20, requete.getValeur());

    }

    public void testCreationRequete2(){

        Requete requete = new Requete("GET /debug/");
        assertEquals("requete.getCommande() en défaut ???","debug", requete.getCommande());
        assertNull("requete.getNom() en défaut ???",requete.getNom());
        assertEquals("requete.getValeur() en défaut ???",-1, requete.getValeur());

    }  

    public void testCreationRequete3(){

        Requete requete = new Requete();
        requete.setUrl("GET /create/?nom=temperature&valeur=20");

        assertEquals("requete.getCommande() en défaut ???","create", requete.getCommande());
        assertEquals("requete.getNom() en défaut ???","temperature", requete.getNom());
        assertEquals("requete.getValeur() en défaut ???",20, requete.getValeur());
    }

    public void testCreationRequete4(){

        Requete requete = new Requete();
        requete.setUrl("GET /create/?name=temperature&valeur=100&type=humidity");

        assertEquals("requete.getCommande() en défaut ???","create", requete.getCommande());
        assertEquals("requete.getNom() en défaut ???",null, requete.getNom());
        assertEquals("requete.getValeur() en défaut ???",100, requete.getValeur());
    }
}
