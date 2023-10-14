package question1;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.NoSuchElementException;


/** Gestion par introspection des m�thodes de la classe java.lang.Math,<br>
 *  Seules sont conserv�es :les m�thodes retournant un double et d'arit� 1 ou 2<p>
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
     * @param  nomDeLaM�thode Nom de la fonction + "(double)" ou "(double, double)"
     * @return true si la fonction est pr�sente
     */
    public boolean cetteMethodeEstPresente(String nomDeLaMethode){
        return tableDesMethodes.containsKey(nomDeLaMethode); // � compl�ter
    }

    /** 
     * @param  nomDeLaM�thode Nom de la fonction + "(double)" ou "(double, double)"
     * @return true si la fonction est binaire, d'arit� 2
     * @throws NoSuchElementException si la m�thode demand�e n'existe pas
     */
    public boolean cetteMethodeAttendDeuxParametres(String nomDeLaMethode){
        if(!cetteMethodeEstPresente(nomDeLaMethode))
            throw new NoSuchElementException();
        
        return tableDesMethodes.get(nomDeLaMethode).getParameterTypes().length == 2;  // � compl�ter
        }
    

    /** 
     * @param  nomDeLaM�thode Nom de la fonction + "(double)" ou "(double, double)"
     * @return true si la fonction est unaire, d'arit� 1
     * @throws NoSuchElementException si la m�thode demand�e n'existe pas 
     */
    public boolean cetteMethodeAttendUnSeulParametre(String nomDeLaMethode){
        if(!cetteMethodeEstPresente(nomDeLaMethode))
            throw new NoSuchElementException();
        
        return tableDesMethodes.get(nomDeLaMethode).getParameterTypes().length == 1;  // � compl�ter
    }

    /** 
     * Obtention de la liste ordonn�e des m�thodes
     * @return la liste tri�e des fonctions issues de java.lang.Math
     */  
    public String[] listeDesMethodes(){
        return tableDesMethodes.keySet().toArray(new String[]{}); // � compl�ter
    }

    /** Invocation d'une m�thode de la table
     * @param  nomDeLaM�thode Nom de la fonction + "(double)"
     * @param arg1 l'op�rande
     * @return un r�sultat
     * @throws NoSuchElementException si la m�thode demand�e n'existe pas ou une exception lev�e par la fonction appel�e
     */
    public double invoquer(String nomDeLaMethode,double arg1) throws Exception{
        if (!cetteMethodeEstPresente(nomDeLaMethode))
            throw new NoSuchElementException();
        return (double)tableDesMethodes.get(nomDeLaMethode).invoke(this, arg1);    // � compl�ter
    }

    /** Invocation d'une m�thode de la table
     * @param  nomDeLaM�thode Nom de la fonction + "(double, double)"
     * @param arg1 l'op�rande
     * @return un r�sultat
     * @throws NoSuchElementException si la m�thode demand�e n'existe pas ou une exception lev�e par la fonction appel�e
     */  
    public double invoquer(String nomDeLaMethode, double arg1, double arg2) throws Exception{
        if (!cetteMethodeEstPresente(nomDeLaMethode))
            throw new NoSuchElementException();
        return (double)tableDesMethodes.get(nomDeLaMethode).invoke(this, arg1, arg2);    // � compl�ter
    }

    /**
     * Le dictionnaire contient la liste des m�thodes disponibles.
     * un choix de dictionnaire pourrait �tre pour la Cl� une String soit le Nom de la fonction + "(double)" ou "(double, double)".<br>
     *  et en Valeur =  la Method correspondante.
     *  ou tout autre choix
     */
    private static Map<String,Method> tableDesMethodes = null;// � compl�ter ...

    /** bloc statique d'intialisation de la table des m�thodes */
    static{
        tableDesMethodes = new TreeMap();

        for(Method m : Math.class.getDeclaredMethods()){
            String paramType = Arrays.toString(m.getParameterTypes());
            if((paramType.equals("[double]") || paramType.equals("[double, double]")) && m.getReturnType().toString().equals("double")){
                String methodString = m.getName() + "(" + paramType.substring(1, paramType.length()-1) + ")";
                tableDesMethodes.put(methodString, m);
            }
        }
        // � compl�ter
    }
}
