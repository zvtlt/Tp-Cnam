package question4;

public interface Command<T>{
    public void send(T t) throws Exception;
}
