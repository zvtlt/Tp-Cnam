package chaineDeResponsabilitesHtmlVuEnCours;


import java.util.*;
import container.*;

public class ChainOfResponsibilityTests  extends junit.framework.TestCase{

    public void testAvecInjection() throws Exception{
        ApplicationContext ctx = Factory.createApplicationContext("./chaineDeResponsabilitesHtmlVuEnCours/README.TXT");
        System.out.println("test avec injection: ");
        StringBuffer sb = ctx.getBean("sb");
        sb.append("Exemple");
        
        Handler<StringBuffer> chaine = ctx.getBean("chaine");
        chaine.handleRequest(sb);
        System.out.println("resultat: " + sb.toString());
        assertEquals("<I><B><U>Exemple</U></B></I>",sb.toString());
        
    }
    
    public void testSansInjection() throws Exception{
      System.out.println("test sans injection: ");
      StringBuffer sb = new StringBuffer("Exemple");
      Handler<StringBuffer> chaine = new U(new B(new I(null)));
      chaine.handleRequest(sb);
      System.out.println("resultat: " + sb.toString());
      assertEquals("<I><B><U>Exemple</U></B></I>",sb.toString());
    }
}
