package chaineDeResponsabilitesHtmlVuEnCours;

public abstract class Handler<T>{
    private Handler next;

    public Handler(Handler next){
        this.next = next;
    }
    
    public Handler<T> getNext(){ return next;}
    public void setNext(Handler<T> next){this.next = next;}

    
    public boolean handleRequest(T t){
        if(next!=null) 
            return next.handleRequest(t);

        return false;
    }
}
