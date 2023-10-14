package question2bis;

import container.*;

public class Tests extends junit.framework.TestCase{

    public void testAvecInjection() throws Exception{
        ApplicationContext ctx = container.Factory.createApplicationContext("./question2bis/README.TXT");

        Client client = ctx.getBean("clientDownShort");
        assertEquals(client.executer(), "test");
        System.out.print("Test StringDown : ");
        System.out.println(client.executer());
        
        Client client2 = ctx.getBean("clientUpShort");
        assertEquals(client2.executer(), "TEST");
        System.out.print("Test StringUp : ");
        System.out.println(client2.executer());
        
        Client client3 = ctx.getBean("clientDownLong");
        assertEquals(client3.executer(), "Chaine de caractere trop longue");
        System.out.print("Test StringDown : ");
        System.out.println(client3.executer());
        
        Client client4 = ctx.getBean("clientUpLong");
        assertEquals(client4.executer(), "Chaine de caractere trop longue");
        System.out.print("Test StringUp : ");
        System.out.println(client4.executer());

    }
    
    public void testSansInjection(){
        Proxy reel = new Reel();
        
        StringDown proxy1 = new StringDown();
        proxy1.setString("Test");
        proxy1.setProxy(reel);
        
        Client client = new Client();
        client.setProxy(proxy1);
        
        System.out.print("Test StringDown : ");
        System.out.println(client.executer());
        
        proxy1.setString("Test beaucoup trop long pour fonctionner");
        
        System.out.print("Test StringDown : ");
        System.out.println(client.executer());
        
        
        Proxy reel2 = new Reel();
        
        StringUp proxy2 = new StringUp();
        proxy2.setString("Test");
        proxy2.setProxy(reel2);
        
        Client client2 = new Client();
        client2.setProxy(proxy2);
        
        System.out.print("Test StringUp : ");
        System.out.println(client2.executer());
        
        proxy2.setString("Test beaucoup trop long pour fonctionner");
        
        System.out.print("Test StringUp : ");
        System.out.println(client2.executer());
    }
}
