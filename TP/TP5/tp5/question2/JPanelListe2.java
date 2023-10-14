package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

public class JPanelListe2 extends JPanel implements ActionListener, ItemListener{

    private JPanel cmd = new JPanel();
    private JLabel afficheur = new JLabel();
    private JTextField saisie = new JTextField();

    private JPanel panelBoutons = new JPanel();
    private JButton boutonRechercher = new JButton("rechercher");
    private JButton boutonRetirer = new JButton("retirer");

    private CheckboxGroup mode = new CheckboxGroup();
    private Checkbox ordreCroissant = new Checkbox("croissant", mode, false);
    private Checkbox ordreDecroissant = new Checkbox("d�croissant", mode, false);

    private JButton boutonOccurrences = new JButton("occurrence");

    private JButton boutonAnnuler = new JButton("annuler");

    private TextArea texte = new TextArea();

    private List<String> liste;
    private Map<String, Integer> occurrences;

    private Caretaker listeSvg = new Caretaker();

    public JPanelListe2(List<String> liste, Map<String, Integer> occurrences) {
        this.liste = liste;
        this.occurrences = occurrences;

        cmd.setLayout(new GridLayout(3, 1));

        cmd.add(afficheur);
        cmd.add(saisie);

        panelBoutons.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelBoutons.add(boutonRechercher);
        panelBoutons.add(boutonRetirer);
        panelBoutons.add(new JLabel("tri du texte :"));
        panelBoutons.add(ordreCroissant);
        panelBoutons.add(ordreDecroissant);
        panelBoutons.add(boutonOccurrences);
        panelBoutons.add(boutonAnnuler);
        cmd.add(panelBoutons);

        if(liste!=null && occurrences!=null){
            afficheur.setText(liste.getClass().getName() + " et "+ occurrences.getClass().getName());
            texte.setText(liste.toString());
        }else{
            texte.setText("la classe Chapitre2CoreJava semble incompl�te");
        }

        setLayout(new BorderLayout());

        add(cmd, "North");
        add(texte, "Center");

        boutonRechercher.addActionListener(this);
        boutonRetirer.addActionListener(this);
        ordreCroissant.addItemListener(this);
        ordreDecroissant.addItemListener(this);
        boutonOccurrences.addActionListener(this);
        boutonAnnuler.addActionListener(this);

        saisie.addActionListener(this);
        // � compl�ter;
        boutonAnnuler.setEnabled(false);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            boolean res = false;
            if (ae.getSource() == boutonRechercher || ae.getSource() == saisie) {
                res = liste.contains(saisie.getText());
                Integer occur = occurrences.get(saisie.getText());
                afficheur.setText("r�sultat de la recherche de : "
                    + saisie.getText() + " -->  " + res);
            } else if (ae.getSource() == boutonRetirer) {
                res = retirerDeLaListeTousLesElementsCommencantPar(saisie
                    .getText());
                afficheur
                .setText("r�sultat du retrait de tous les �l�ments commen�ant par -->  "
                    + saisie.getText() + " : " + res);
            } else if (ae.getSource() == boutonOccurrences) {
                Integer occur = occurrences.get(saisie.getText());
                if (occur != null)
                    afficheur.setText(" -->  " + occur + " occurrence(s)");
                else
                    afficheur.setText(" -->  ??? ");
            }else if (ae.getSource() == boutonAnnuler) {
                 restoreFromMemento((Memento)listeSvg.getMemento());
            }

            texte.setText(liste.toString());
        } catch (Exception e) {
            afficheur.setText(e.toString());
        } finally{
            update();
        }
    }

    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == ordreCroissant){
            listeSvg.addMemento(storeInMemento());
            Collections.sort(liste); // � compl�ter
        }else if (ie.getSource() == ordreDecroissant){
            listeSvg.addMemento(storeInMemento());
            Desc desc = new Desc();
            Collections.sort(liste, desc);;// � compl�ter
        }
        texte.setText(liste.toString());
        update();
    }

    private boolean retirerDeLaListeTousLesElementsCommencantPar(String prefixe) {
        if (prefixe.equals("") || prefixe == null)
            return false;
        
        boolean resultat = false;
        boolean etatSvg = false;
        
        Iterator it = occurrences.entrySet().iterator();

        while (it.hasNext()){
            Map.Entry<String, Integer> temp = (Map.Entry)it.next();
            

            if (temp.getKey().startsWith(prefixe)){
                if (temp.getValue() != 0){
                    if(!etatSvg){
                    listeSvg.addMemento(storeInMemento());
                    etatSvg = true;
                    }
                    occurrences.replace(temp.getKey(), 0);
                }
                
                for (int i = liste.size() - 1; i >= 0; i--) {
                    if (liste.get(i).equals(temp.getKey())){
                        liste.remove(i);
                        resultat = true;
                    }
                }
            }
        }
        texte.setText(liste.toString());

        return resultat;
    }

    // Creates a new Memento with a new liste, occurences

    public Memento storeInMemento() {
        return new Memento(liste, occurrences); 
    }

    // Gets the liste and occurences currently stored in memento

    public void restoreFromMemento(Memento m) {
        liste = m.getListe();
        occurrences = m.getOccurences();
    }
    
    public void update(){
        if (listeSvg.getSize() == 0)
        boutonAnnuler.setEnabled(false);
        else
        boutonAnnuler.setEnabled(true);
    }

    public class Desc implements Comparator<String>{
        public int compare(String a, String b){
            return (b.compareToIgnoreCase(a));
        } 
    }
}