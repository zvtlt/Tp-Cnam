package question1;

/**
 * Décrivez votre classe FahrenheitCelsius ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class FahrenheitCelsius {

    /**
     * le point d'entrée de cette application, dont le commentaire est à
     * compléter
     * 
     * @param args
     *            ...
     */
    public static void main(String[] args) {
        // pour tous les paramètres de la ligne de commande
        int fahrenheit = 0;
        float celsius = 0;

        for (String s : args){
            fahrenheit = Integer.parseInt(s);
            celsius = fahrenheitEnCelsius(fahrenheit);

            System.out.println(fahrenheit + "\u00B0F -> " +  celsius + "\u00B0C");
            // ligne,
        }

        // format
        // imposés

    }

    /**
     * la méthode à compléter.
     * 
     * @param f
     *            la valeur en degré Fahrenheit
     * @return la conversion en degré Celsius
     */
    public static float fahrenheitEnCelsius(int f) {

        float resultat = (((float)f - 32)*5)/9;
        float resultat2 = ((int)(resultat*10))/10.F;

        return resultat2; // à compléter en remplaçant ce return 0.F par la fonction
        // de conversion
    }

}
