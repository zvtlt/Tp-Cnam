package exemple_eric_and_martin;

import question1.SpecificationI;
// extrait de https://github.com/masoud-bahrami/Specification-Pattern-Samples/tree/master/Specification.Net.Samples/EricAndMartinSample/Specifications

public class ParameterizedStorageSpecification implements SpecificationI<Container>{

    private  int maxWeight;
    private  int maxTemp;
    
    public ParameterizedStorageSpecification(int maxTemp, int maxWeight){
        this.maxTemp = maxTemp;
        this.maxWeight = maxWeight;
    }

    public ParameterizedStorageSpecification(){    }
    
    public  boolean isSatisfiedBy(Container container){
        return container.getHasRefrigerator() && 
        container.getInternalTemperature() < this.maxTemp &&
        container.getMaxWeight() >= this.maxWeight;
    }

//Start GetterSetterExtension Source Code

    /**GET Method Propertie maxWeight*/
    public int getMaxWeight(){
        return this.maxWeight;
    }//end method getMaxWeight

    /**SET Method Propertie maxWeight*/
    public void setMaxWeight(int maxWeight){
        this.maxWeight = maxWeight;
    }//end method setMaxWeight

    /**GET Method Propertie maxTemp*/
    public int getMaxTemp(){
        return this.maxTemp;
    }//end method getMaxTemp

    /**SET Method Propertie maxTemp*/
    public void setMaxTemp(int maxTemp){
        this.maxTemp = maxTemp;
    }//end method setMaxTemp

//End GetterSetterExtension Source Code


}//End class