
package question3;

import java.io.*;
import java.net.*;

public class UpperCaseInputStreamTest extends junit.framework.TestCase{

    public void testAccès_README_TXT(){
        try{
            InputStream is = new BufferedInputStream( new FileInputStream(new File("README.TXT")));
            int c = is.read();
            assertTrue(" erreur de lecture ???", c!= -1);
            is.close();
        }catch(Exception e){
            fail(" Erreur sur ce fichier : README.TXT ??? " + e.getMessage());
        }
    }

    public void testUpperCase_README_TXT() throws Exception{
        //InputStream is = new BufferedInputStream( new FileInputStream(new File("README.TXT")));   // déclaration à décorer ....
        InputStream is = new UpperCaseInputStream( new FileInputStream(new File("question3/README.TXT")));

        int c = is.read();
        while( c != -1){
            assertTrue("erreur !, '" + Character.valueOf((char)c) + "' ne semble pas être une majuscule ...", Character.isUpperCase((char)c) || (char)c==' ');  
            c = is.read();
        }

        is.close();
    }

    public void testPushPackUpperCase_README_TXT() throws Exception{ // à terminer
        StringBuffer sb = new StringBuffer();
        PushbackInputStream pbis = new PushbackInputStream( new UpperCaseInputStream( new FileInputStream(new File("question3/README.TXT"))));
        
        int count = 1;
        int c = pbis.read();
        
        while ( count < 20 ){
            sb.append((char)c);
            c = pbis.read();
            count++;
        }
        
        assertEquals("TESTS DU DECORATEUR", sb.toString());
        pbis.close();
        
        sb.delete(0, sb.length());
        count = 1;
        
        PushbackInputStream pbisUnread = new PushbackInputStream( new UpperCaseInputStream( new FileInputStream(new File("question3/README.TXT"))));
        c = pbisUnread.read();
        
        while ( count < 20 ){
            sb.append((char)c);
            pbisUnread.unread(c);
            c = pbisUnread.read();
            count++;
        }
        
        assertEquals("TTTTTTTTTTTTTTTTTTT", sb.toString());
        pbisUnread.close();
        
    }

    public void UpperCaseInputStream() throws Exception {
        InputStream is = new UpperCaseInputStream(new FileInputStream(new File("question3/README.TXT")));
        int c = is.read();
        while( c != -1){
            System.out.print((char) c);
            c = is.read();
        }
        is.close();
    }

    public void testUpperDataOffLen() throws Exception{
        InputStream is = new UpperCaseInputStream(new FileInputStream(new File("question3/README.TXT")));

        byte[] data = new byte[7];
        int off = 5;
        int len = data.length-off;
        int byteRead = is.read(data, off, len);
        
        System.out.println("Number of bytes read:- " + byteRead);

        while(byteRead != -1) {

            int count = 1;

            for (byte b : data){
                
                if (count == 8)
                    count = 1;
                    
                System.out.println("Char read from buffer :- " + (char) b + "            Count :- " + count);
                count++;
            }
            byteRead = is.read(data);
        }
        is.close();
    }
}
