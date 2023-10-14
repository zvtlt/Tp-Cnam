package question1;

public class And<E> extends Binary<E>{

    public And(SpecificationI<E> spec1, SpecificationI<E> spec2){
        super(spec1,spec2);
    }

    public And(){}

    public boolean isSatisfiedBy(E e){/* TODO */
        return spec1.isSatisfiedBy(e) && spec2.isSatisfiedBy(e); 
    }

    public String toString(){
        return "(" + spec1 + ") and (" + spec2 +")";
    }
}
