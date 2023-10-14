package question1;


import java.io.*;

/**
 * Décrivez votre classe JAVASerialiseDeserialise ici.
 * 
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class JAVASerialiseDeserialise
{
    public static void serialjava(IProgr p, String nomDuFichier) throws IOException{// à compléter
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomDuFichier));
        oos.writeObject(p);
        oos.close();
    }
    
    public static IProgr deserialjava(String nomDuFichier) throws Exception{// à compléter
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomDuFichier));
        IProgr obj = (IProgr) ois.readObject();
        ois.close();
        return obj;
    }    
}
