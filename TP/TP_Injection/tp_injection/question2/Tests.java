package question2;

import container.*;

public class Tests extends junit.framework.TestCase{

    public void testAvecInjection() throws Exception{
        ApplicationContext ctx = container.Factory.createApplicationContext("./question2/README.TXT");

        String str = ctx.getBean("strDown").toString();
        assertEquals(str, "test");

        String str2 = ctx.getBean("strUp").toString();
        assertEquals(str2, "TEST");

    }

    public void testSansInjection() throws Exception{
        Client str = new Client();
        str.setMode(0);
        String res = str.setUoD("Test");
        assertEquals("test", res);

        Client str2 = new Client();
        str2.setMode(1);
        String res2 = str2.setUoD("Test");
        assertEquals("TEST", res2);
    }
}