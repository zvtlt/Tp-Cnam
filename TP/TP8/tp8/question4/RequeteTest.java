package question4;


public class RequeteTest extends junit.framework.TestCase{
    public void setUp(){ 

    }

    public void testCreationRequete1(){

        Requete requete = new Requete("GET /create/?nom=temperature&valeur=20");

        assertEquals("requete.getCommande() en d�faut ???","create", requete.getCommande());
        assertEquals("requete.getNom() en d�faut ???","temperature", requete.getNom());
        assertEquals("requete.getValeur() en d�faut ???",20, requete.getValeur());

    }

    public void testCreationRequete2(){

        Requete requete = new Requete("GET /debug/");
        assertEquals("requete.getCommande() en d�faut ???","debug", requete.getCommande());
        assertNull("requete.getNom() en d�faut ???",requete.getNom());
        assertEquals("requete.getValeur() en d�faut ???",-1, requete.getValeur());

    }  

    public void testCreationRequete3(){

        Requete requete = new Requete();
        requete.setUrl("GET /create/?nom=temperature&valeur=20");

        assertEquals("requete.getCommande() en d�faut ???","create", requete.getCommande());
        assertEquals("requete.getNom() en d�faut ???","temperature", requete.getNom());
        assertEquals("requete.getValeur() en d�faut ???",20, requete.getValeur());
    }

    public void testCreationRequete4(){

        Requete requete = new Requete();
        requete.setUrl("GET /create/?name=temperature&valeur=100&type=humidity");

        assertEquals("requete.getCommande() en d�faut ???","create", requete.getCommande());
        assertEquals("requete.getNom() en d�faut ???",null, requete.getNom());
        assertEquals("requete.getValeur() en d�faut ???",100, requete.getValeur());
    }
}
