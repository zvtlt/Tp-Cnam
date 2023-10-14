package question4;

import container.*;
import java.util.Properties;

public class TestsChainCRUD_WithFemtoContainer extends junit.framework.TestCase{

    public void setUp(){ 
        Table.getInstance().vider();
    }

    public void testAvecInjection() throws Exception{
        try{
            assertEquals(0, Table.getInstance().taille());
            ApplicationContext ctx = Factory.createApplicationContext("./question4/README.TXT");
            System.out.println("tests avec injection: ");

            Requete requeteCreate = ctx.getBean("requete_create");
            Handler<Requete> chaineCRUD = ctx.getBean("log_bean");

            assertEquals("Log->Create->Retrieve->Update->Delete", chaineCRUD.toString());
            chaineCRUD.handleRequest(requeteCreate);
            assertTrue(Table.getInstance().contient("temperature"));
            assertEquals(200,Table.getInstance().lire("temperature"));

            Requete requeteUpdate = ctx.getBean("requete_update");
            chaineCRUD.handleRequest(requeteUpdate);
            assertEquals(40,Table.getInstance().lire("temperature"));

            Handler<Requete> chaineUD = ctx.getBean("update_bean");
            assertEquals("Update->Delete", chaineUD.toString());

            // à développer, par exemple en ajoutant le patron commande
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void testAvecInjection2() throws Exception{
        try{
            assertEquals(0, Table.getInstance().taille());
            ApplicationContext ctx = Factory.createApplicationContext("./question4/README.TXT");
            System.out.println("tests avec injection: ");
            Invoker<Requete> invoker = ctx.getBean("invoker_bean");

            invoker.execute(ctx.getBean("requete_create"));
            assertTrue(Table.getInstance().contient("temperature"));
            assertEquals(200,Table.getInstance().lire("temperature"));

            invoker.execute(ctx.getBean("requete_update"));
            assertEquals(40,Table.getInstance().lire("temperature"));

            // changez la chaine de responsabilités depuis le fichier de configuration
            // vérifiez le bon usage du Patron Commande via femtoContainer

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void testAvecInjectionAvecLePatronCommande() throws Exception{
        try{
            assertEquals(0, Table.getInstance().taille());
            ApplicationContext ctx = Factory.createApplicationContext("./question4/README.TXT");
            System.out.println("tests avec injection: ");
            Invoker<Requete> invoker = ctx.getBean("invoker_bean");

            invoker.execute(ctx.getBean("requete_create"));
            assertTrue(Table.getInstance().contient("temperature"));
            assertEquals(200,Table.getInstance().lire("temperature"));

            invoker.execute(ctx.getBean("requete_update"));
            assertEquals(40,Table.getInstance().lire("temperature"));

            // changez la chaine de responsabilités depuis le fichier de configuration
            // vérifiez le bon usage du Patron Commande

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}