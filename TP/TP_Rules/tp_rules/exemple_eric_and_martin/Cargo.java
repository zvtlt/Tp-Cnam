package exemple_eric_and_martin;

import question1.SpecificationI;

public class Cargo{
 
   private int id;
   private String name;
   private int weight;
   
   private SpecificationI<Container> storageSpecification;

   
   
   public Cargo(SpecificationI<Container> specification){
       this.storageSpecification = specification;
   }

   public Cargo(){}
//Start GetterSetterExtension Source Code

    /**GET Method Propertie id*/
    public int getId(){
        return this.id;
    }//end method getId

    /**SET Method Propertie id*/
    public void setId(int id){
        this.id = id;
    }//end method setId

    /**GET Method Propertie name*/
    public String getName(){
        return this.name;
    }//end method getName

    /**SET Method Propertie name*/
    public void setName(String name){
        this.name = name;
    }//end method setName

    /**GET Method Propertie weight*/
    public int getWeight(){
        return this.weight;
    }//end method getWeight

    /**SET Method Propertie weight*/
    public void setWeight(int weight){
        this.weight = weight;
    }//end method setWeight

    /**GET Method Propertie specification*/
    public question1.SpecificationI<Container> getStorageSpecification(){
        return this.storageSpecification;
    }//end method getSpecification

    /**SET Method Propertie specification*/
    public void setStorageSpecification(SpecificationI<Container> specification){
        this.storageSpecification = specification;
    }//end method setSpecification

//End GetterSetterExtension Source Code


}//End class