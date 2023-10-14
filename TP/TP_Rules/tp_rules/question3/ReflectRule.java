package question3;

import question1.ReflectSpecification;
import question2.ReflectCommand;

public class ReflectRule<E,R> extends Rule<E,R>  {
    protected ReflectSpecification<E>  instanceSpecification=null;
    protected ReflectCommand<E,R>  instanceCommand=null;

    public void setSpecification(String specification){
        Class c = null;
        
        try {
             c = Class.forName(specification);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found ! "+ e.getMessage());
        }
        
        try
        {
            instanceSpecification = (ReflectSpecification)c.newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setCommand(String command){/* TODO */
        Class c = null;

        try{
            c = Class.forName(command);
        }catch(Exception e){
            System.out.println("Class not found ! "+ e.getMessage());
        }

        try
        {
            instanceCommand = (ReflectCommand)c.newInstance();
            super.setCommand(instanceCommand);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
