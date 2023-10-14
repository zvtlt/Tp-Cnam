package question2;

import java.awt.event.ActionListener; // � compl�ter
import java.awt.event.ActionEvent; // � compl�ter
import java.awt.TextArea;

public class JButtonObserver implements ActionListener { // � compl�ter

    private String nom;
    private TextArea contenu;

    public JButtonObserver(String nom, TextArea contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }

    public void actionPerformed (ActionEvent ae){
        String message = "observateur "+nom+" : clic du bouton " +ae.getActionCommand(); // � compl�ter, inspirez-vous de l'applette de l'�nonc�
        contenu.append(message + "\n");
    }
}

