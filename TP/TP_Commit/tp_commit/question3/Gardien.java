package question3;
import java.util.Stack;

public class Gardien{
    private Stack<Memento> mementoStk;
    
    public Gardien(){
      this.mementoStk = new Stack<Memento>();
    }
    public Memento getMemento() {
        assert !this.mementoStk.empty():"Il manque au moins un appel de setMemento..." ;
        return this.mementoStk.pop();
    }
    
    public void setMemento(Memento memento){
        assert memento!=null;
        this.mementoStk.push(memento);
    }
  }