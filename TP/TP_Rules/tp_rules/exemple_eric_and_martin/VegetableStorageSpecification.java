package exemple_eric_and_martin;

import question1.SpecificationI;

// extrait de https://github.com/masoud-bahrami/Specification-Pattern-Samples/tree/master/Specification.Net.Samples/EricAndMartinSample/Specifications
public class VegetableStorageSpecification implements SpecificationI<Container>{

    public  boolean isSatisfiedBy(Container container){
        return (container.getInternalTemperature() > 5) && 
        (container.getMaxWeight() >= 1);
    }
}
