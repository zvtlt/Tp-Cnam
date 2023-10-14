package question3;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.lang.reflect.Modifier;



public class Introspection{

    public static Set<Method> getHeritees(String nomDeLaClasse) throws ClassNotFoundException{
        Class<?> classe = Class.forName(nomDeLaClasse);
        List<List<Method>> liste = new ArrayList();
        
        while (classe != null){
            liste.add(localMethods(classe));
            classe = classe.getSuperclass();
        }
        
        Set<Method> result = new HashSet();
        
        for (Method m : methodVerifiee(liste)){
            result.add(m);
        }
        
        return result;
    }

  
    public static void main(String[] args) throws ClassNotFoundException{

        for(Method m : Introspection.getHeritees("java.util.AbstractCollection")){
            System.out.println(m);
        }
    }
    
    public static boolean isEqual(Method a, Method b){
        return (a.getName().equals(b.getName())
            && (Arrays.equals(a.getParameterTypes(), b.getParameterTypes())));
            //&& (a.getReturnType().equals(b.getReturnType())));
    }
    
    public static boolean isPP(Method m){
        return ((Modifier.isPublic(m.getModifiers())
                || Modifier.isProtected(m.getModifiers()))
                && !(Modifier.isAbstract(m.getModifiers())));
    }
    
    public static List<Method> localMethods (Class classe) throws ClassNotFoundException{
        if (classe == null)
            throw new ClassNotFoundException();
            
        List<Method> localMethods = new ArrayList();
        
        for (Method m : classe.getDeclaredMethods()){
            if(isPP(m))
                localMethods.add(m);
        }
            
        return localMethods;
    }
    
    public static List<Method> methodVerifiee (List<List<Method>> liste){
        
        List<Method> allMethods = new ArrayList();
        
        if (liste.size() > 1){
            
            List<Method> toDelete = new ArrayList();
            Method current;
            Method toCompare;
            
            // recuperation de toutes les methodes dans une List<Method>
            for (int i = 0 ; i < liste.size() ; i++ ){
                allMethods.addAll(liste.get(i));
            }
            
            // filtrage par rapport au niveau local
            for (int i = 0 ; i < liste.get(0).size() ; i++){
                current = allMethods.get(i);
                
                for (int j = i + 1 ; j < allMethods.size() ; j++){
                    toCompare = allMethods.get(j);
                    
                    if (isEqual(current, toCompare))
                        toDelete.add(toCompare);
                }
                toDelete.add(current);
            }
            
            // suppresion de notre listes de toutes nos methodes, des methodes locales ainsi que celle de niveau superieur
            // qui lui sont egal qui sont donc des methodes redefinies
            for (Method m : toDelete){
                allMethods.remove(m);
            }
            toDelete.clear();
            
            // filtrage par rapport aux restes
            for (int i = 0 ; i < allMethods.size() ; i++){
                current = allMethods.get(i);
                
                for (int j = i + 1 ; j < allMethods.size() ; j++){
                    toCompare = allMethods.get(j);
                    
                    if (isEqual(current, toCompare))
                        toDelete.add(toCompare);
                }
            }
            
            // suppresion des doublons...
            for (Method m : toDelete){
                allMethods.remove(m);
            }
        }
        
        return allMethods;
    }
}