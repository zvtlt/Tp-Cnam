package question1;

import java.util.*;

public class None<E> extends CompositeSpecification<E>{

    List<SpecificationI<E>> spec ;

    public None(){
        spec = new ArrayList<>();
    }

    @Override
    public boolean isSatisfiedBy(E e){

        deepSpec(super.specifications.iterator());

        for (SpecificationI s : spec){
            if (s.isSatisfiedBy(e))
                return false;
        }

        return true;
    }

    public String toString(){
        return "none" + super.toString();
    }

    /**
     * Flatten all nested list into a single one
     * add to the Instance list
     * @param i an iterotor from a List
     */
    private void deepSpec(Iterator<SpecificationI<E>> i){
        
        SpecificationI<E> current = null;
        
        while (i.hasNext()) {
            current = i.next();
            
            if (current instanceof CompositeSpecification)
                deepSpec(((CompositeSpecification<E>) current).specifications.iterator());
            else
                spec.add(current);
        }
    }
}