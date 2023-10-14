package question1;
import java.util.List;

public class OnlyOne<E> extends CompositeSpecification<E>{
  
    public boolean isSatisfiedBy(E e){/* TODO */
        
        boolean res = false;
        int count = 0;

        for (SpecificationI s : super.specifications){
            
            if (s.isSatisfiedBy(e)){
                res = true;
                count++;
            }
        }
        
        if(res && count != 1)
            res = false;

        return res;
    }
    
    public String toString(){
        return "onlyOne" + super.toString();
    }
}