package question2;

import java.lang.reflect.*;


public class ReflectCommand<E,R> extends Command<E,R>  {
    protected CommandI<E,R>  instanceCommand=null;

    public void setCommand(String command){/* TODO */
        Class c = null;
        
        try{
            c = Class.forName(command);
        }catch(Exception e){
            System.out.println("Class not found ! "+ e.getMessage());
        }
        
        try
        {
            instanceCommand = (CommandI)c.newInstance();
            super.setCommand(instanceCommand);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    
    public R execute(E entity, R result)throws Exception{/* TODO */
        if(instanceCommand == null)
            throw new RuntimeException();
        
        Method mCommand=null;
        try{
            for(Method m : instanceCommand.getClass().getMethods())
                if (m.getName().equals("execute") && m.getParameterTypes().length == 2)
                    mCommand=m;
            
            if (mCommand == null)
                throw new NoSuchMethodException();
                
            result = (R)mCommand.invoke(instanceCommand,entity, result);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        
        return result;
    }
}
