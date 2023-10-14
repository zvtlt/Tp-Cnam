package question2;

import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.beans.*;

public class Z_ParIntrospection extends junit.framework.TestCase{

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

    private Observable obs = null;
    public void test_lierObservableEtObserver(){
        try{
            Entier e = new Entier(1);
            assertTrue(" liaison absente,  e.countObservers != 0 ???", e.countObservers()==0);                           
            ParIntrospection.lierObservableEtObserver( e, new Observer(){
                    public void update(Observable o, Object arg){
                        Z_ParIntrospection.this.obs = o;
                    }
                }
            );
            assertTrue(" liaison absente,  e.countObservers != 1 ???", e.countObservers()==1);                           
            e.initialiser(3);
            assertNotNull(" notification absente ???", obs);
            assertEquals(" pas le bon Observable ???", e.toString(), obs.toString());
            assertEquals(" pas le bon Observable ???", "3", obs.toString());
        }catch(Exception e){
            fail(" exception !!! " + e.getMessage());
        }
    }

    private boolean temoinDeMiseAJour = false;
    public void test_delierObservableEtObserver(){

        try{
            Entier e = new Entier(1);
            Observer obs = new Observer(){ public void update(Observable o, Object arg){
                        Z_ParIntrospection.this.temoinDeMiseAJour = true;
                    }
                };
            ParIntrospection.lierObservableEtObserver( e, obs);
            e.initialiser(3);
            assertTrue(" notification absente ???", temoinDeMiseAJour);
            temoinDeMiseAJour = false;
            ParIntrospection.delierObservableEtObserver( e, obs);
            e.initialiser(3);
            assertFalse(" delier fonctionne-t-il ? ???", temoinDeMiseAJour);
        }catch(Exception e){
            fail(" exception !!! " + e.getMessage());
        }
    }

    public void test_lierNonObservableEtObserver(){
        try{
            Observer obs = new Observer(){ public void update(Observable o, Object arg){
                        Z_ParIntrospection.this.temoinDeMiseAJour = true;
                    }
                };
            ParIntrospection.lierObservableEtObserver( this, obs);
            fail(" le 1er parametre n'est pas instanceof Observable !!!");
        }catch(Exception e){

        }
    }

    public void test_lierObservableEtNonObserver(){

        try{
            ParIntrospection.lierObservableEtObserver( new Entier(1), new String("essai"));
            fail(" le 2eme parametre n'est pas instanceof Observer !");
        }catch(Exception e){
            assertTrue(" NoSuchElementException est attendu ??? (" + e.getMessage() + ")", e instanceof NoSuchElementException);
        }
    }

    public void test_lierObservableNullEtNonObserver(){
        try{
            ParIntrospection.lierObservableEtObserver( null, new String("essai"));
            fail(" le 2eme parametre n'est pas instanceof Observer !");
        }catch(Exception e){
            assertTrue(" NoSuchElementException est attendu ??? (" + e.getMessage() + ")", e instanceof NoSuchElementException);
        }
    }

    public void test_lierObservableEtObserverNull(){
        try{
            ParIntrospection.lierObservableEtObserver( new Entier(1), null);
            fail(" le 2eme parametre n'est pas instanceof observer !");
        }catch(Exception e){
            assertTrue(" NoSuchElementException est attendu ??? (" + e.getMessage() + ")", e instanceof NoSuchElementException);
        }
    }

    public void test_lierNonObservableEtNonObserver(){ 
        try{
            ParIntrospection.lierObservableEtObserver( new String("essai"), new String("essai"));
            fail(" les parametres NonObservable et NonObserver ne peuvent être lies !");
        }catch(Exception e){

        }
    }

     
    public void test_lierJButtonEtActionListener() throws Exception{
        try{
            JButton jb = new JButton();
            ActionListener obs = new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                    }
                };
            question2.ParIntrospection.lierSourceEtListener(jb, obs);

            assertTrue(" l'observateur n'est pas ajoute ???", jb.getActionListeners().length==1);
            boolean present = jb.getActionListeners()[0].equals(obs);
            assertTrue(" l'observateur ne fait pas partie des \"Listeners\" de la source, echec lors de l'appel de \"getActionListeners\"", present);

        }catch(Exception e){
            fail(" lier JButton et ActionListener leve une exception ???"); 
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

    private class UnObservateurDeSouris extends MouseAdapter implements MouseListener{
        public void mouseClicked(MouseEvent e){

        }
    }

    public void test_lierCheckBoxEtItemListener() throws Exception{
        try{
            Checkbox c = new Checkbox();
            question2.ParIntrospection.lierSourceEtListener(c, new ItemListener(){
                    public void itemStateChanged(ItemEvent e) {
                    }
                }
            );

            ItemListener[] ls = (ItemListener[])(c.getListeners(ItemListener.class));
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", ls.length==1);
        }catch(Exception e){
            fail(" lier CheckBox et ItemListener leve une exception ???"); 
        }
    }

    public void test_lierJComboBoxEtActionListener() throws Exception{
        try{
            JComboBox jc = new JComboBox();
            question2.ParIntrospection.lierSourceEtListener(jc, new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                    }
                }
            );
            ActionListener[] ls = (ActionListener[])(jc.getListeners(ActionListener.class));
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", ls.length==1);

        }catch(Exception e){
            fail(" lier JComboBox et ActionListener leve une exception ???" ); 
        }
    }

    public void test_lierJScrollBarEtAdjustmentListener() throws Exception{
        try{
            JScrollBar jsb = new JScrollBar();
            question2.ParIntrospection.lierSourceEtListener(jsb, new AdjustmentListener(){
                    public void adjustmentValueChanged(AdjustmentEvent e) {
                    }
                }
            );
            AdjustmentListener[] ls = (AdjustmentListener[])(jsb.getListeners(AdjustmentListener.class));
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", ls.length==1);

        }catch(Exception e){
            fail(" lier JScrollBar et AdjustmentListener leve une exception ???"); 
        }
    }

    public void test_lierJScrollBarEtAncestorListener() throws Exception{
        try{
            JScrollBar jsb = new JScrollBar();
            question2.ParIntrospection.lierSourceEtListener(jsb, new AncestorListener(){
                    public void ancestorAdded(AncestorEvent event){
                    }

                    public void ancestorMoved(AncestorEvent event){
                    } 

                    public void ancestorRemoved(AncestorEvent event){
                    }
                }
            );

            AncestorListener[] ls = (AncestorListener[])(jsb.getListeners(AncestorListener.class));
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", ls.length==1);

        }catch(Exception e){
            fail(" lier JScrollBar et AncestorListener leve une exception ???"); 
        }
    }

    public void test_lierPropertyChangeSupportEtPropertyChangeListener() throws Exception{
        try{
            question2.ParIntrospection.lierSourceEtListener( new PropertyChangeSupport(new JButton()), 
                new PropertyChangeListener(){
                    public void propertyChange(PropertyChangeEvent evt) {
                    }
                }
            );

        }catch(Exception e){
            fail(" lier PropertyChangeSupport et PropertyChangeListener leve une exception ???"); 
        }
    }

    public void test_lierCanvasEtComponentListener(){
        try{
            Canvas c = new Canvas();
            question2.ParIntrospection.lierSourceEtListener(c, new ComponentListener(){
                    public void componentHidden(ComponentEvent e){
                    }

                    public void componentMoved(ComponentEvent e){
                    } 

                    public void componentResized(ComponentEvent e){
                    }

                    public void componentShown(ComponentEvent e){
                    }                                       
                }
            );

            ComponentListener[] ls = (ComponentListener[])(c.getListeners(ComponentListener.class));
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", ls.length==1);

        }catch(Exception e){
            fail(" lier Canvas et ComponentListener leve une exception ???"); 
        }
    }

    public void test_lierCanvasEtFocusListener(){
        try{
            Canvas c = new Canvas();
            question2.ParIntrospection.lierSourceEtListener(c, new FocusListener(){
                    public void focusGained(FocusEvent e) {
                    }

                    public void focusLost(FocusEvent e) {
                    }                                  
                }
            );

            FocusListener[] ls = (FocusListener[])(c.getListeners(FocusListener.class));
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", ls.length==1);

        }catch(Exception e){
            fail(" lier Canvas et FocusListener leve une exception ???"); 
        }
    }

    public void test_lierCanvasEtHierarchyBoundsListener(){
        try{
            Canvas c = new Canvas();
            question2.ParIntrospection.lierSourceEtListener(c, new HierarchyBoundsListener(){
                    public void ancestorMoved(HierarchyEvent e) {
                    }

                    public void ancestorResized(HierarchyEvent e)  {
                    }                                  
                }
            );

            HierarchyBoundsListener[] ls = (HierarchyBoundsListener[])(c.getListeners(HierarchyBoundsListener.class));
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", ls.length==1);

        }catch(Exception e){
            fail(" lier Canvas et HierarchyBoundsListener leve une exception ???"); 
        }
    }

    public void test_lierCanvasEtHierarchyListener(){
        try{
            Canvas c = new Canvas();
            question2.ParIntrospection.lierSourceEtListener(c, new HierarchyListener(){
                    public void hierarchyChanged(HierarchyEvent e) {                                 
                    }
                }
            );

            HierarchyListener[] ls = (HierarchyListener[])(c.getListeners(HierarchyListener.class));
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", ls.length==1);

        }catch(Exception e){
            fail(" lier Canvas et HierarchyListener leve une exception ???"); 
        }
    }

    public void test_lierCanvasEtInputMethodListener(){
        try{
            Canvas c = new Canvas();
            question2.ParIntrospection.lierSourceEtListener(c, new InputMethodListener(){
                    public void inputMethodTextChanged(InputMethodEvent event) {                                 
                    }

                    public void caretPositionChanged(InputMethodEvent event) {
                    }
                }
            );

            InputMethodListener[] ls = (InputMethodListener[])(c.getListeners(InputMethodListener.class));
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", ls.length==1);

        }catch(Exception e){
            fail(" lier Canvas et InputMethodListener leve une exception ???"); 
        }
    }

    public void test_lierCanvasEtKeyListener(){
        try{
            Canvas c = new Canvas();
            question2.ParIntrospection.lierSourceEtListener(c, new KeyListener(){
                    public void keyPressed(KeyEvent e)  {    
                    }

                    public void keyReleased(KeyEvent e)  {
                    }

                    public void keyTyped(KeyEvent e) {
                    }
                }
            );

            KeyListener[] ls = (KeyListener[])(c.getListeners(KeyListener.class));
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", ls.length==1);

        }catch(Exception e){
            fail(" lier Canvas et KeyListener leve une exception ???"); 
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

    public void test_lierCanvasEtMouseListener(){
        try{
            Canvas c = new Canvas();
            question2.ParIntrospection.lierSourceEtListener(c, new MouseListener(){
                    public void mouseClicked(MouseEvent e){}

                    public void mouseEntered(MouseEvent e){}

                    public void mouseExited(MouseEvent e){}

                    public void mousePressed(MouseEvent e){}

                    public void mouseReleased(MouseEvent e){}                                 }
            );
            MouseListener[] ls = (MouseListener[])(c.getListeners(MouseListener.class));
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", ls.length==1);
        }catch(Exception e){
            assertTrue(" NoSuchElementException est attendue ???", e instanceof NoSuchElementException); 
        }
    }

    public void test_lierBasicComboBoxEditorEtActionListener(){
        try{
            javax.swing.plaf.basic.BasicComboBoxEditor b = new javax.swing.plaf.basic.BasicComboBoxEditor();
            question2.ParIntrospection.lierSourceEtListener(b,new ActionListener(){
                    public void actionPerformed(ActionEvent e)  {                                 
                    }
                }
            );

        }catch(Exception e){
            fail(" lier BasicComboBoxEditor et ActionListener leve une exception ???"); 
        }
    }

    public void test_delierBasicComboBoxEditorEtActionListener(){
        try{
            javax.swing.plaf.basic.BasicComboBoxEditor b = new javax.swing.plaf.basic.BasicComboBoxEditor();
            ActionListener al = new ActionListener(){ public void actionPerformed(ActionEvent e){}};
            question2.ParIntrospection.delierSourceEtListener(b,al);

        }catch(Exception e){
            fail(" delier BasicComboBoxEditor et ActionListener leve une exception ???"); 
        }
    }

    // ----------------------------------------------------------------------------------------------------------------
    public void test_delierJButtonEtActionListener() throws Exception{
        try{
            JButton jb = new JButton();
            ActionListener obs = new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                    }
                };
            question2.ParIntrospection.lierSourceEtListener(jb, obs);

            boolean present = false;
            for( ActionListener listener : jb.getActionListeners()){
                if(listener.equals(obs)) present =true;
            }
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getActionListeners\"", present);

            question2.ParIntrospection.delierSourceEtListener(jb, obs);

            present = false;
            for( ActionListener listener : jb.getActionListeners()){
                if(listener.equals(obs)) present =true;
            }      
            assertFalse(" l'observateur fait encore partie \"Listeners\" de la source, appel de \"getActionListeners\"", present);

        }catch(Exception e){
            fail(" delier JButton et ActionListener leve une exception ???" + e.getMessage()); 
        }
    }

    public void test_delierJButtonEtMouseListener() throws Exception{
        try{
            MouseListener obs = new UnObservateurDeSouris();;
            JButton jb = new JButton("test");
            question2.ParIntrospection.lierSourceEtListener(jb, obs);

            boolean present = false;
            for( EventListener listener : jb.getListeners(MouseListener.class)){
                if(listener.equals(obs)) present =true;
            }
            assertTrue(" l'observateur ne fait pas partie \"Listeners\" de la source, echec lors de l'appel de \"getListeners\"", present);

            question2.ParIntrospection.delierSourceEtListener(jb, obs);

            present = false;
            for( EventListener listener : jb.getListeners(MouseListener.class)){
                if(listener.equals(obs)) present =true;
            }      
            assertFalse(" l'observateur fait encore partie \"Listeners\" de la source, appel de \"getListeners\"", present);
        }catch(Exception e){
            fail(" delier JButton et MouseListener leve une exception ???" + e.getMessage()); 
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

    public void test_delierJButtonEtMouseListenerAbsent() throws Exception{
        try{
            MouseListener obs = new UnObservateurDeSouris();;
            JButton jb = new JButton("test");
            question2.ParIntrospection.delierSourceEtListener(jb, obs);
        }catch(Exception e){
            assertTrue("  exception attendue ici ??? (" + e.getMessage() + ")", e instanceof NoSuchElementException);
        }
    }
}

// ------------------------------------------------------------------------------------------------------------------

// private class ClasseLocaleAuTest{
    // public ActionListener al = null;
    // public void addActionListener( ActionListener al){
        // this.al = al;
    // }

    // public void removeActionListener(ActionListener l){
        // this.al = null;
    // }
// }

// private class ClasseLocaleAuTest2{

    // public void test_lierClasseLocaleAuTestEtActionListener(){
        // try{
            // ClasseLocaleAuTest c = new ClasseLocaleAuTest();
            // question2.ParIntrospection.lierSourceEtListener(c, new ActionListener(){
                    // public void actionPerformed(ActionEvent e)  {                                 
                    // }
                // }
            // );
            // assertTrue("echec lors de la liaison par introspection ???", c.al != null);
        // }catch(Exception e){
            // assertTrue(" NoSuchElementException est attendue ???", e instanceof NoSuchElementException); 
            // fail(" pas d'exception attendue ici !!! "); 
        // }
    // }     

    // public void test_lier_delierClasseLocaleAuTestEtActionListener(){
        // try{
            // ClasseLocaleAuTest c = new ClasseLocaleAuTest();
            // ActionListener actionListener = new ActionListener(){
                    // public void actionPerformed(ActionEvent e)  {                                 
                    // }
                // };
            // question2.ParIntrospection.lierSourceEtListener(c, actionListener);
            // assertTrue("echec lors de la liaison par introspection ???", c.al != null);
            // assertTrue("echec lors de la liaison par introspection ???", c.al == actionListener);
            // question2.ParIntrospection.delierSourceEtListener(c, actionListener);
            // assertTrue("echec lors de l'appel de delier ???", c.al == null);

        // }catch(Exception e){
            // fail(" pas d'exception attendue ici !!! "); 
        // }
    // }     
// }

