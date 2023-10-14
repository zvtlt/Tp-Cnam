package question1;

public class Not<E> implements SpecificationI<E>{
    protected SpecificationI<E> spec;

    public Not(SpecificationI<E> spec){
        this.spec = spec;
    }

    public Not(){}

    public void setSpec(SpecificationI<E> spec){
        this.spec = spec;
    }

    public SpecificationI<E> getSpec(){
        return this.spec;
    }

    public boolean isSatisfiedBy(E e){/* TODO */
        return !spec.isSatisfiedBy(e); 
    }

    public String toString(){
        return "not(" + spec +")";
    }

}
