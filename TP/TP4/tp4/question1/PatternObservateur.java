package question1;

public class PatternObservateur extends junit.framework.TestCase {

    public void testNotify() {
        ConcreteSubject list;
        ConcreteObserver observer;

        list = new ConcreteSubject();           // cr�ation d'un "observ�" constitu� d'une liste
        observer = new ConcreteObserver();      // cr�ation d'un observateur
        list.addObserver(observer);             // ajouter cet observateur � la liste
        list.insert("il fait beau, ce matin");  // modification de cette liste, l'observateur doit
                                                // (dervrait) �tre notifi�

        // "v�rification" :
        assertFalse(observer.senders().empty());                            // elle ne doit pas �tre vide,
        assertEquals(list, observer.senders().pop());                       // est-ce le bon �metteur ?
        assertEquals("il fait beau, ce matin", observer.arguments().pop()); // le param�tre re�u est-il correct ?
    }

    // une liste, 2 observateurs
    public void test1() {
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        question1.ConcreteObserver o1 = new question1.ConcreteObserver();
        question1.ConcreteObserver o2 = new question1.ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);
        l1.insert("test");
        l1.insert(" 1 ");
        // v�rifier que les deux observateurs ont bien �t� notifi�s avec les
        // bons param�tres
        assertEquals(2, o1.senders().size());
        assertEquals(2, o2.senders().size());
        assertEquals(2, o1.arguments().size());
        assertEquals(2, o1.arguments().size());
        
        
        assertEquals(l1, o1.senders().pop());
        assertEquals(" 1 ", o1.arguments().pop());
        assertEquals(l1, o1.senders().pop());
        assertEquals("test", o1.arguments().pop());
        
        assertEquals(l1, o2.senders().pop());
        assertEquals(" 1 ", o2.arguments().pop());
        assertEquals(l1, o2.senders().pop());
        assertEquals("test", o2.arguments().pop());
        
        // � compl�ter !!

        // ne pas modifier ces lignes, derni�res assertions vraies de cette
        // m�thode
        assertTrue(o1.senders().empty() && o1.arguments().empty());
        assertTrue(o2.senders().empty() && o2.arguments().empty());
    }

    // deux listes, 1 observateur
    public void test2() {
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        question1.ConcreteSubject l2 = new question1.ConcreteSubject();

        question1.ConcreteObserver o = new question1.ConcreteObserver();
        l1.addObserver(o);
        l2.addObserver(o);
        l1.insert("testA");
        l1.insert(" A ");
        l2.insert("testB");
        l2.insert(" B ");

        // � compl�ter � partir de la ligne 56
        // v�rifier que l'observateur a bien �t� notifi� par les deux listes

        assertEquals(4, o.senders().size());
        assertEquals(4, o.arguments().size());
        
        assertEquals(l2, o.senders().pop());
        assertEquals(" B ", o.arguments().pop());
        assertEquals(l2, o.senders().pop());
        assertEquals("testB", o.arguments().pop());
        
        assertEquals(l1, o.senders().pop());
        assertEquals(" A ", o.arguments().pop());
        assertEquals(l1, o.senders().pop());
        assertEquals("testA", o.arguments().pop());
        
        // � compl�ter !!
        
        // ne pas modifier cette ligne, derni�re assertion vraie de cette
        // m�thode
        assertTrue(o.senders().empty() && o.arguments().empty());
    }

    // deux listes, 2 observateurs
    public void test3() {
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        question1.ConcreteSubject l2 = new question1.ConcreteSubject();
        question1.ConcreteObserver o1 = new question1.ConcreteObserver();
        question1.ConcreteObserver o2 = new question1.ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);
        l2.addObserver(o1);
        l2.addObserver(o2);

        // � compl�ter � partir de la ligne 81
        // v�rifier le bon fonctionnement de countObservers(), de deleteObserver
        // et deleteObservers()
        
        
        assertEquals(2, l1.countObservers());
        assertEquals(2, l2.countObservers());
        
        l1.deleteObserver(o2);
        l2.deleteObserver(o2);
        
        assertEquals(1, l1.countObservers());
        assertEquals(1, l2.countObservers());
        
        l1.deleteObservers();
        l2.deleteObservers();
        
        assertEquals(0, l1.countObservers());
        assertEquals(0, l2.countObservers());
        
        // � compl�ter !!

        // ne pas modifier ces lignes, derni�res assertions vraies de cette
        // m�thode
        assertTrue(o1.senders().empty());
        assertTrue(o2.senders().empty());
        assertTrue(l1.countObservers() == 0);
        assertTrue(l2.countObservers() == 0);
    }
    
}
