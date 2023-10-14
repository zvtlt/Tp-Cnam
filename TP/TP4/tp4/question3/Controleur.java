package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * D�crivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        //donnee.addActionListener(null /* null est � remplacer */);

        donnee.getDocument().addDocumentListener(new DocumentListener()
            {
                public void changedUpdate(DocumentEvent e) {
                    warn();
                }

                public void removeUpdate(DocumentEvent e) {
                    warn();
                }

                public void insertUpdate(DocumentEvent e) {
                    warn();
                }

                public void warn() {
                    if (donnee.getText().length() == 0)
                        push.setEnabled(false);
                    else
                        push.setEnabled(true);
                }
            }
        );
        

        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        
        boutons.add(push);
        push.addActionListener(new pushListener() /* null est � remplacer */);

        boutons.add(add);
        add.addActionListener(new addListener() /* null est � remplacer */);

        boutons.add(sub);
        sub.addActionListener(new subListener() /* null est � remplacer */);

        boutons.add(mul);
        mul.addActionListener(new mulListener() /* null est � remplacer */);

        boutons.add(div);
        div.addActionListener(new divListener() /* null est � remplacer */);

        boutons.add(clear);
        clear.addActionListener(new clearListener() /* null est � remplacer */);

        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
        push.setEnabled(false);
    }

    public void actualiserInterface() {
        if (pile.taille() <2){
            add.setEnabled(false);
            sub.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);
        } else {
            add.setEnabled(true);
            sub.setEnabled(true);
            mul.setEnabled(true);
            div.setEnabled(true);
        }
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    private class pushListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            try{
                pile.empiler(operande());
            }catch(Exception e){}
            actualiserInterface();
        }
    }

    private class addListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            if(pile.taille() >= 2){
                try{
                    pile.empiler(pile.depiler() + pile.depiler());
                }catch(Exception e){}
                actualiserInterface();
            }
        }
    }

    private class subListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            if(pile.taille() >= 2){
                try{
                    int temp = pile.depiler();
                    pile.empiler(pile.depiler() - temp);
                }catch(Exception e){}
                actualiserInterface();
            }
        }
    }

    private class mulListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            if(pile.taille() >= 2){
                try{
                    pile.empiler(pile.depiler() * pile.depiler());
                }catch(Exception e){}
                actualiserInterface();
            }
        }
    }

    private class divListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            if(pile.taille() >= 2){
                try{
                    if (pile.sommet() == 0)
                        throw new ArithmeticException();
                    else{
                        int temp = pile.depiler(); 
                        pile.empiler(pile.depiler() / temp);
                    }
                }catch(Exception e){}
                actualiserInterface();
            }
        }
    }

    public class clearListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae) {

            try {
                while (!pile.estVide()) {
                    pile.depiler();
                }
            } catch (Exception e) {}
            actualiserInterface();
        }
    }

    // � compl�ter
    // en cas d'exception comme division par z�ro, 
    // mauvais format de nombre suite � l'appel de la m�thode operande
    // la pile reste en l'�tat (intacte)

}
