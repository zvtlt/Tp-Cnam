package question2;


import java.util.Stack;

class Caretaker{
   
    // Where all mementos are saved
    
    private Stack svg = new Stack();

    // Adds memento to the Stack
    
    public void addMemento(Memento m){ 
        svg.push(m); 
    }
   
    // Gets the memento requested from the Stack
    public int getSize(){
        return svg.size();
    }
    
    public Object getMemento(){
        if(getSize() == 0)
            return false;
        else
            return svg.pop();
    }
} 
