package question4;



public class Invoker<T>{

    private Command<T> command;
    public void setCommand(Command<T> command){
        this.command = command;
    }
    
    public void execute(T t) throws Exception{
        this.command.send(t);
    }
}
