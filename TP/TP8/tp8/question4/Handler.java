
package question4;
import java.util.List;
import java.util.ArrayList;

public abstract class Handler<T>{
    private Handler<T> next;

    public Handler(Handler<T> next){
        this.next = next;
    }

    public Handler<T> getNext(){ return next;}

    public void setNext(Handler<T> next){this.next = next;}

    public boolean handleRequest(T t){
        if(this.next != null) return next.handleRequest(t);
        return false;
    }

    public String toString(){
        if(next==null)
            return getClass().getSimpleName();
        else
            return getClass().getSimpleName() + "->" + next.toString();

    }
}
