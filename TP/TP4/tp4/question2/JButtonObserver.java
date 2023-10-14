package question2;

import java.awt.event.ActionListener; // à compléter
import java.awt.event.ActionEvent; // à compléter
import java.awt.TextArea;

public class JButtonObserver implements ActionListener { // à compléter

    private String nom;
    private TextArea contenu;

    public JButtonObserver(String nom, TextArea contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }

    public void actionPerformed (ActionEvent ae){
        String message = "observateur "+nom+" : clic du bouton " +ae.getActionCommand(); // à compléter, inspirez-vous de l'applette de l'énoncé
        contenu.append(message + "\n");
    }
}

