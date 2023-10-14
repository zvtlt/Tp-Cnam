package question2;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.Observer;
import java.util.Observable;

public class ParIntrospection{
    public static void lierObservableEtObserver(Object observable, Object observer) throws Exception{
        // à completer
        try{
            // Method m = observable.getClass().getMethod("addObserver", Observer.class);
            // m.invoke(observable, observer);
            // ---------------------------------------------------------
            Method tempMethod = null;
            for(Method m : Observable.class.getMethods()){
                if(m.getName().contains("addObserver")){
                    tempMethod = m;
                    break;
                }
            }
            tempMethod.invoke(observable, observer);
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }

    public static void delierObservableEtObserver(Object observable, Object observer) throws Exception{
        // à completer
        try{
            Method m = observable.getClass().getMethod("deleteObserver", Observer.class);
            m.invoke(observable, observer);
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }

    public static void lierSourceEtListener(Object source, Object listener) throws Exception{
        // à completer
        try{
            Method tempMethod = null;
            for(Method m : source.getClass().getMethods()){
                if(m.getName().contains("add") && m.getName().contains("Listener")
                && m.getParameterTypes().length == 1 && m.getParameterTypes()[0].isInstance(listener)){
                    tempMethod = m;
                    break;
                }
            }
            tempMethod.invoke(source, listener);
            // Arrays.stream(
            // source.getClass().getMethods())
            // .filter(x -> x.getName().contains("add") && x.getName().contains("Listener"))
            // .filter(x -> x.getParameterTypes().length == 1)
            // .filter(x -> x.getParameterTypes()[0].isInstance(listener))
            // .collect(Collectors.toList())
            // .get(0)
            // .invoke(source, listener);
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }

    // public static void lierSourceEtListener(Object source, Object listener) throws Exception{  
        // try{
            // String str = listener.getClass().getInterfaces()[0].toString();

            // String res = str.substring(str.lastIndexOf(" ")+1);   // recuperation de MouseListener par exemple
            // Class c = Class.forName(res);                         // recuperation de la class 
            // String[] res2 = res.split("[.]");                      

            // int index = 0;
            // try{
                // while(res2[index] != null){
                    // res = res2[index] ;
                    // index++;
                // }
            // }catch (Exception e) {

            // }
            // // Apres filtrage res est sous la bonne forme
            // String tempMethod = "add" + res;      // adaptation de res pour dans notre cas avoir la methode pour ajouter
            // Method m = source.getClass().getMethod(tempMethod, c);    // creation de notre methode par rapport à nos parametre recuperé
            // m.invoke(source, listener);      // invocation de la methode avec les parametres transmit dans la methode lierSourceEtListener(...)
        // } catch (Exception e) {
            // throw new NoSuchElementException();
        // }
    // }

    /** Cette methode permet de delier par introspection, une source et un "listener"<p>
     * Appel par introspection de la methode source.removeXXXXListener(listener) 
     * 
     * @param source est une instance 
     * @param listener une implementation d'une interface XXXXListener
     * @throws NoSuchElementException en cas d'erreur
     */
    public static void delierSourceEtListener(Object source, Object listener) throws Exception{
        // à completer
        try{
            Method tempMethod = null;
            for(Method m : source.getClass().getMethods()){
                if(m.getName().contains("remove") && m.getName().contains("Listener")
                && m.getParameterTypes().length == 1 && m.getParameterTypes()[0].isInstance(listener)){
                    tempMethod = m;
                    break;
                }
            }
            tempMethod.invoke(source, listener);
            // Arrays.stream(
            // source.getClass().getMethods())
            // .filter(x -> x.getName().contains("remove") && x.getName().contains("Listener"))
            // .filter(x -> x.getParameterTypes().length == 1)
            // .filter(x -> x.getParameterTypes()[0].isInstance(listener))
            // .collect(Collectors.toList())
            // .get(0)
            // .invoke(source, listener);
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }

    // public static void lierSourceEtListener(Object source, Object listener) throws Exception{
        // try{
            // Class[] interfaces = listener.getClass().getInterfaces();
            // Method tempMethod = null;
            // for( Class c : interfaces){ // pour toutes les interfaces implementees
                // Method[] methods = source.getClass().getMethods();
                // for( Method m : methods){ // toutes les methodes de source
                    // Class[] type = m.getParameterTypes();
                    // if(type.length == 1){ // un seul parametre est attendu du bon type
                        // if(type[0].getSimpleName().equals(c.getSimpleName()) && m.getName().startsWith("add" + c.getSimpleName())){ // methode addXXXXX
                            // tempMethod = m;
                        // }
                    // }
                // }
            // }
            // tempMethod.invoke(source,listener);
        // }catch(Exception e){
            // throw new NoSuchElementException();
        // }
    // }
}