package question3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.Observable;
import java.util.Observer;

/**
 * D�crivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class Vue extends JPanel implements Observer{// � compl�ter

    private JLabel etatPile;
    private PileModele<Integer> pile;

    public Vue(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.etatPile = new JLabel("entrez des nombres entiers");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(etatPile);
        setBackground(Color.green);
        // inscription aupr�s du mod�le comme observateur
        pile.addObserver(this);
    }

    public void update(Observable obs, Object arg) {
        etatPile.setText(pile.toString()); // ou obs.toString()
    }

}
