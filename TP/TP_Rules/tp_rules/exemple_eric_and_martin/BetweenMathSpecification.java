package exemple_eric_and_martin;


import question1.SpecificationI;
// extrait de https://github.com/masoud-bahrami/Specification-Pattern-Samples/tree/master/Specification.Net.Samples/EricAndMartinSample/Specifications

public class BetweenMathSpecification implements SpecificationI<Integer>{

    private int left;
    private int right;

    public BetweenMathSpecification(int left, int rigth){
        this.left = left;
        this.right = rigth;
    }

    public  boolean isSatisfiedBy(Integer candidate){
        return candidate > this.left && candidate < this.right;
    }
}