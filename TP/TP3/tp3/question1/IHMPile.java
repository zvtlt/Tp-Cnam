package question1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// pour le comportement attendu depuis votre répertoire
// exécuter cette commande tp3>appletviewer tp3.html
public class IHMPile extends JFrame implements ActionListener{
    private JTextField donnee = new JTextField(6);
    private JTextField sommet = new JTextField(6);
    private JLabel     contenu = new JLabel("[]");
    private Pile p = null;

    public IHMPile(){
        super("IHM Pile");

        JButton    boutonEmpiler = new JButton("empiler");
        JButton    boutonDepiler = new JButton("depiler");

        JPanel enHaut = new JPanel();
        enHaut.add(donnee);
        enHaut.add(boutonEmpiler);
        enHaut.add(boutonDepiler);
        enHaut.add(sommet);
        setLayout(new BorderLayout(5,5));
        add("North",enHaut);
        add("Center",contenu);
        enHaut.setBackground(Color.red);
        setLocation(100,100);
        pack();setVisible(true);
        boutonEmpiler.addActionListener(this);
        boutonDepiler.addActionListener(this);

        p = new Pile(5);
        

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("empiler")){
            try{
                if(donnee.getText() instanceof String){
                    if(!p.estPleine()){
                        String donneeAttendu = donnee.getText().toString();   
                        if(p.estVide()){
                            p.empiler(donneeAttendu);
                            sommet.setText(String.valueOf(donneeAttendu));
                            contenu.setText(contenu.getText().toString().substring( 0, (contenu.getText().length() - 1)) + donneeAttendu +"]");
                        }else{
                            p.empiler(donneeAttendu);
                            sommet.setText(String.valueOf(donneeAttendu));
                            String contenuTemp = contenu.getText().substring( 1, contenu.getText().length()) ;
                            contenu.setText("["+ donneeAttendu + ", " + contenuTemp);
                        }  
                    } 
                    else throw new PilePleineException();
                }
            }catch(PilePleineException e){
                System.out.println("La pile est pleine\nerror : " + e.getMessage());  // en cas d'erreur 
            }

            // à compléter
            // pour le comportement attendu depuis votre répertoire
            // exécuter cette commande tp3>appletviewer tp3.html

            // en cas d'exception
            //contenu.setText( /* à compléter */"" + " estPleine !");

        }else{
            try{
                if(donnee.getText() instanceof String){
                    if(!p.estVide()){
                        int count1 = p.count() + 1;
                        int count2 = p.count() + 3;
                        if(p.uneEntree()){
                            p.depiler();
                            String contenuTemp = contenu.getText().substring( count1, contenu.getText().length()) ;
                            contenu.setText("[" + contenuTemp);
                        }else{
                            p.depiler();
                            String contenuTemp = contenu.getText().substring( count2, contenu.getText().length()) ;
                            contenu.setText("["+ contenuTemp);
                        }
                    } 
                    else throw new PileVideException();
                }
            }catch(PileVideException e){
                System.out.println("La pile est deja vide\nerror : " + e.getMessage());  // en cas d'erreur 
            }

            // à compléter
            // en cas d'exception
            //contenu.setText( /* à compléter */"" + " estVide !");
        }
    }

    public static void main(String[] args){
        // for(int i = 0; i < args.length; i++) {
        // new IHMPile(new Pile(Integer.parseInt(args[i].toString())));
        // }
        new IHMPile();
    }

    public void test(){
        System.out.println(contenu.getText().length());
        //System.out.println(contenu.getText().substring( 0, contenu.getText().length() - 3));

    }
}
