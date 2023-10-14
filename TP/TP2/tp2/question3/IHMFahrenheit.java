package question3;

import question1.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IHMFahrenheit extends JFrame implements ActionListener{
    public JTextField entree = new JTextField( 6 );
    /** Le bouton de conversion. */
    public JButton  boutonDeConversion = new JButton( "convertir" );
    /** La sortie en degr� Celsius. */
    public JTextField sortie = new JTextField( 15 );

    public IHMFahrenheit(){
        super("IHM Fahrenheit");

        setLayout(new FlowLayout());
        add( entree ); add( boutonDeConversion ); add( sortie );
        sortie.setEditable( false );
        getContentPane().setBackground( Color.pink );
        setLocation(100,100);
        pack();setVisible(true);

        boutonDeConversion.addActionListener( this );
    }

    /** 
     * m�thode d�clench�e lorsque le bouton de conversion est appuy�. 
     * remarquer que le champs de droite (les degr�s Celsius) n'est pas �ditable.
     * @param ae l'�v�nement transmis
     */
    public void actionPerformed( ActionEvent ae ){
        try{
            int fahrenheit = 0; // valeur est une String et doit �tre convertie en entier, voir java.lang.Integer m�thode parseInt (--> try/catch)
            float celsius = 0F; // � compl�ter, en appelant la m�thode ad'hoc de la question2 

            fahrenheit = Integer.parseInt(entree.getText());
            celsius = fahrenheitEnCelsius(fahrenheit);
           

            if(celsius < -273.1F) celsius = -273.1F;   // un test ici pour le z�ro absolu (-273.1)

            sortie.setText( Float.toString(celsius));

        }catch(NumberFormatException nfe){
            // if(entree.getText().contains (".")){
                // sortie.setText( "Int Only");
            // }else{
                sortie.setText("error !");
            // }
        }
    }

    /**
     * la m�thode � compl�ter.
     * 
     * @param f
     *            la valeur en degr� Fahrenheit
     * @return la conversion en degr� Celsius
     */
    public static float fahrenheitEnCelsius(int f) {

        float resultat = (((float)f - 32)*5)/9;
        float resultat2 = ((int)(resultat*10)) / 10.0F;

        return resultat2; // � compl�ter en rempla�ant ce return 0.F par la fonction
        // de conversion
    }

    public static void main(String[] args){
        new IHMFahrenheit();
    }
}
