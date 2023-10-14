package question1;
import java.util.List;

public class OneOf<E> extends CompositeSpecification<E>{

    public boolean isSatisfiedBy(E e){/* TODO */
        
        boolean res = false;

        for (SpecificationI s : super.specifications){
            
            if (s.isSatisfiedBy(e))
                res = true;
                
        }

        return res;
    }

    public String toString(){
        return "oneOf" + super.toString();
    }
}