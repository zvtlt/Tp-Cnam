package question3;

import java.io.InputStream;
import java.io.IOException;
import java.io.FilterInputStream;

/**
 * Cette classe "décore" un fichier (InputSream) par la conversion de tous
 * les caractères Minuscule en Majuscule
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class UpperCaseInputStream extends FilterInputStream { // à compléter
    
    protected UpperCaseInputStream(InputStream in) {
        super(in);
    }
    
    public int read() throws IOException {
        int c = super.read();
        if (c == -1)
            return -1;
        else
            return Character.toUpperCase(c);
    }
    
    public int read(byte[] b) throws IOException{
        return read(b, 0, b.length);
    }
    
    public int read(byte[] b, int off, int len) throws IOException {
        int c = super.read(b, off, len);
        
        for (int i = off ; i < off + len ; i++){
            b[i] = (byte)Character.toUpperCase(b[i]);
        }
        
        return c;
    }
}