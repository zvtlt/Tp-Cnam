package decorateurHtmlVuEnCours;


import java.util.*;
import container.*;

public class DecoratorTests  extends junit.framework.TestCase{

    public void testAvecInjection() throws Exception{
        ApplicationContext ctx = Factory.createApplicationContext("./decorateurHtmlVuEnCours/README.TXT");
        System.out.println("test avec injection: ");
        TexteI texteDecore = ctx.getBean("texteDecore");
        System.out.println("texte d�cor�: " + texteDecore.toHTML());
        assertEquals("<U><B><I>Exemple</I></B></U>",texteDecore.toHTML());
        System.out.println("texte d�cor�: " + texteDecore.toHTML());
        
    }
    
    public void testSansInjection() throws Exception{
      TexteI texte = new Texte("Exemple");
      TexteI texteDecore = new U(new B(new I( texte)));
      assertEquals("<U><B><I>Exemple</I></B></U>",texteDecore.toHTML());
    }
}

