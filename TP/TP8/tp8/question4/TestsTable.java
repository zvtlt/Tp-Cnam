package question4;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class TestsTable extends junit.framework.TestCase{

    public void setUp(){    }

    public void testSingleton(){
        Table table1 = Table.getInstance();
        assertNotNull(table1);
        Table table2 = Table.getInstance();
        assertNotNull(table2);
        assertSame(table1,table2);
    }

    public void testAjouts(){
        Table.getInstance().vider();
        Table table1 = Table.getInstance();
        table1.ajouter("temperature",20);
        assertEquals(1, table1.taille());
        Table table2 = Table.getInstance();
        assertEquals(1, table2.taille());
        table2.ajouter("temperature",30);
        assertEquals(1, table2.taille());
        table2.ajouter("jauge",10);
        assertEquals(2, table2.taille());
    }

    public void testContient(){
        Table.getInstance().vider();
        Table table1 = Table.getInstance();
        table1.ajouter("temperature",20);
        assertTrue(table1.contient("temperature"));
        Table table2 = Table.getInstance();
        assertEquals(1, table2.taille());
        assertTrue(table2.contient("temperature"));
        assertEquals(1, table2.taille());
        table2.ajouter("jauge",10);
        assertTrue(table2.contient("jauge"));
    }
    
    public void testLire(){
        Table.getInstance().vider();
        Table table1 = Table.getInstance();
        table1.ajouter("temperature",20);
        assertEquals(20,table1.lire("temperature"));
        try{
            table1.lire("capteur_absent");
            fail();
        }catch(Throwable e){
            assert(e instanceof RuntimeException);
        }
    }

    public void testRetirer(){
        Table.getInstance().vider();
        Table table1 = Table.getInstance();
        table1.ajouter("temperature",20);
        assertTrue(table1.retirer("temperature"));
        assertFalse(table1.retirer("temperature"));
        Table table2 = Table.getInstance();
        assertEquals(0, table2.taille());
        assertFalse(table1.retirer("null"));
    }
    
    public void testIterator(){
        Table.getInstance().vider();
        Table.getInstance().ajouter("temperature",20);
        Table.getInstance().ajouter("jauge",100);
        Table.getInstance().ajouter("batterie",3450);
        List<String> listeDesNoms = new ArrayList<>();
        listeDesNoms = new ArrayList<>();
        for(String nom : Table.getInstance()){
            listeDesNoms.add(nom);
        }
        assertEquals(3,listeDesNoms.size());
        assertTrue(listeDesNoms.contains("temperature"));
        assertTrue(listeDesNoms.contains("jauge"));
        assertTrue(listeDesNoms.contains("batterie"));
        

        listeDesNoms = new ArrayList<>();
        for(String nom : Table.getInstance()){
            listeDesNoms.add(nom);
        }
        assertEquals(3,listeDesNoms.size());
        Iterator<String> iterator = Table.getInstance().iterator();

        iterator.next();
        iterator.remove();
        
        listeDesNoms = new ArrayList<>();
        for(String nom : Table.getInstance()){
            listeDesNoms.add(nom);
        }
        assertEquals("Iterator sur la table, remove est sans effet ???",3,listeDesNoms.size());
        
    }
}