package question1;

public class All<E> extends CompositeSpecification<E>{
  
    public boolean isSatisfiedBy(E e){/* TODO */

        for (SpecificationI s : super.specifications){
            if (s.isSatisfiedBy(e)){

            } else
                return false;
        }

        return true;
    }

    public String toString(){
        return "all" + super.toString();
    }
}