package question1;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.NoSuchElementException;


/** Gestion par introspection des méthodes de la classe java.lang.Math,<br>
 *  Seules sont conservées :les méthodes retournant un double et d'arité 1 ou 2<p>
 *   Note : Emploi du Pattern Singleton pour cette table, accessible uniquement en lecture par des accesseurs<p>
 * La convention de nommage est la suivante :
 *        le "Nom" de la fonction suivi de "(double)"  exemple : "sqrt(double)"
 *  ou le "Nom" de la fonction suivi de "(double, double)"  exemple : "IEEEremainder(double, double)"
 */

final public class TableMethodesJavaLangMath{
    /** Singleton */
    private static TableMethodesJavaLangMath instanceUnique = null;

    public static TableMethodesJavaLangMath getInstance(){
        synchronized(TableMethodesJavaLangMath.class){
            if (instanceUnique==null){
                instanceUnique = new TableMethodesJavaLangMath();
            }
            return instanceUnique;
        }
    }

    private TableMethodesJavaLangMath(){
    } 
    // fin du Singleton

    /** 
     * @param  nomDeLaMéthode Nom de la fonction + "(double)" ou "(double, double)"
     * @return true si la fonction est présente
     */
    public boolean cetteMethodeEstPresente(String nomDeLaMethode){
        return tableDesMethodes.containsKey(nomDeLaMethode); // à compléter
    }

    /** 
     * @param  nomDeLaMéthode Nom de la fonction + "(double)" ou "(double, double)"
     * @return true si la fonction est binaire, d'arité 2
     * @throws NoSuchElementException si la méthode demandée n'existe pas
     */
    public boolean cetteMethodeAttendDeuxParametres(String nomDeLaMethode){
        if(!cetteMethodeEstPresente(nomDeLaMethode))
            throw new NoSuchElementException();
        
        return tableDesMethodes.get(nomDeLaMethode).getParameterTypes().length == 2;  // à compléter
        }
    

    /** 
     * @param  nomDeLaMéthode Nom de la fonction + "(double)" ou "(double, double)"
     * @return true si la fonction est unaire, d'arité 1
     * @throws NoSuchElementException si la méthode demandée n'existe pas 
     */
    public boolean cetteMethodeAttendUnSeulParametre(String nomDeLaMethode){
        if(!cetteMethodeEstPresente(nomDeLaMethode))
            throw new NoSuchElementException();
        
        return tableDesMethodes.get(nomDeLaMethode).getParameterTypes().length == 1;  // à compléter
    }

    /** 
     * Obtention de la liste ordonnée des méthodes
     * @return la liste triée des fonctions issues de java.lang.Math
     */  
    public String[] listeDesMethodes(){
        return tableDesMethodes.keySet().toArray(new String[]{}); // à compléter
    }

    /** Invocation d'une méthode de la table
     * @param  nomDeLaMéthode Nom de la fonction + "(double)"
     * @param arg1 l'opérande
     * @return un résultat
     * @throws NoSuchElementException si la méthode demandée n'existe pas ou une exception levée par la fonction appelée
     */
    public double invoquer(String nomDeLaMethode,double arg1) throws Exception{
        if (!cetteMethodeEstPresente(nomDeLaMethode))
            throw new NoSuchElementException();
        return (double)tableDesMethodes.get(nomDeLaMethode).invoke(this, arg1);    // à compléter
    }

    /** Invocation d'une méthode de la table
     * @param  nomDeLaMéthode Nom de la fonction + "(double, double)"
     * @param arg1 l'opérande
     * @return un résultat
     * @throws NoSuchElementException si la méthode demandée n'existe pas ou une exception levée par la fonction appelée
     */  
    public double invoquer(String nomDeLaMethode, double arg1, double arg2) throws Exception{
        if (!cetteMethodeEstPresente(nomDeLaMethode))
            throw new NoSuchElementException();
        return (double)tableDesMethodes.get(nomDeLaMethode).invoke(this, arg1, arg2);    // à compléter
    }

    /**
     * Le dictionnaire contient la liste des méthodes disponibles.
     * un choix de dictionnaire pourrait être pour la Clé une String soit le Nom de la fonction + "(double)" ou "(double, double)".<br>
     *  et en Valeur =  la Method correspondante.
     *  ou tout autre choix
     */
    private static Map<String,Method> tableDesMethodes = null;// à compléter ...

    /** bloc statique d'intialisation de la table des méthodes */
    static{
        tableDesMethodes = new TreeMap();

        for(Method m : Math.class.getDeclaredMethods()){
            String paramType = Arrays.toString(m.getParameterTypes());
            if((paramType.equals("[double]") || paramType.equals("[double, double]")) && m.getReturnType().toString().equals("double")){
                String methodString = m.getName() + "(" + paramType.substring(1, paramType.length()-1) + ")";
                tableDesMethodes.put(methodString, m);
            }
        }
        // à compléter
    }
}
