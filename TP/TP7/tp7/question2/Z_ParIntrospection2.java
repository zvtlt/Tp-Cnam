package question2;

import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.beans.*;

public class Z_ParIntrospection2 extends junit.framework.TestCase{

    private static class Entier extends Observable{
        private int x;

        public Entier(int x){ this.x = x;}

        public void initialiser(int valeur){
            this.x = valeur;
            setChanged();
            notifyObservers();
        }

        public String toString(){ return Integer.toString(x);}
    }
    
    private class UnObservateurDeSouris extends MouseAdapter implements MouseListener{
        public void mouseClicked(MouseEvent e){

        }
    }
    
    public void test_lierCanvasEtActionListener(){
        try{
            Canvas c = new Canvas();
            question2.ParIntrospection.lierSourceEtListener(c, new ActionListener(){
                    public void actionPerformed(ActionEvent e)  {                                 
                    }
                }
            );
            fail("lier Canvas et ActionListener doit lever une exception ???");
        }catch(Exception e){
            assertTrue(" NoSuchElementException est attendue ???", e instanceof NoSuchElementException); 
        }
    }     
    
    public void test_delierJButtonEtNonMouseListener() throws Exception{
        try{
            MouseListener obs = new UnObservateurDeSouris();;
            JButton jb = new JButton("test");
            question2.ParIntrospection.delierSourceEtListener(jb, new String("rerer"));
            fail(" une NoSuchElementException est attendue");
        }catch(Exception e){
            assertTrue(" NoSuchElementException est attendue ??? (" + e.getMessage() + ")", e instanceof NoSuchElementException);
        }
    }
    
    public void test_lierJButtonEtMouseListener() throws Exception{
        try{
            MouseListener obs = new UnObservateurDeSouris();;
            JButton jb = new JButton("test");
            question2.ParIntrospection.lierSourceEtListener(jb, obs);

            boolean present = false;
            for( EventListener listener : jb.getListeners(MouseListener.class)){
                if(listener.equals(obs)) present =true;
            }
            assertTrue(" l'observateur ne fait pas partie des \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", present);
        }catch(Exception e){
            fail(" lier JButton et MouseListener leve une exception ???"); 
        }
    }
}