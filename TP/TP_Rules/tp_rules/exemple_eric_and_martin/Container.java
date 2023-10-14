package exemple_eric_and_martin;

import java.util.List;

public class Container{
   private int id;
   private boolean hasRefrigerator;
   private int internalTemperature; 
   private int maxWeight;
   private List<Cargo> Cargoes;
    

//Start GetterSetterExtension Source Code

    /**GET Method Propertie id*/
    public int getId(){
        return this.id;
    }//end method getId

    /**SET Method Propertie id*/
    public void setId(int id){
        this.id = id;
    }//end method setId

    /**GET Method Propertie hasRefrigerator*/
    public boolean getHasRefrigerator(){
        return this.hasRefrigerator;
    }//end method getHasRefrigerator

    /**SET Method Propertie hasRefrigerator*/
    public void setHasRefrigerator(boolean hasRefrigerator){
        this.hasRefrigerator = hasRefrigerator;
    }//end method setHasRefrigerator

    /**GET Method Propertie internalTemperature*/
    public int getInternalTemperature(){
        return this.internalTemperature;
    }//end method getInternalTemperature

    /**SET Method Propertie internalTemperature*/
    public void setInternalTemperature(int internalTemperature){
        this.internalTemperature = internalTemperature;
    }//end method setInternalTemperature

    /**GET Method Propertie maxWeight*/
    public int getMaxWeight(){
        return this.maxWeight;
    }//end method getMaxWeight

    /**SET Method Propertie maxWeight*/
    public void setMaxWeight(int maxWeight){
        this.maxWeight = maxWeight;
    }//end method setMaxWeight

    /**GET Method Propertie Cargoes*/
    public java.util.List<Cargo> getCargoes(){
        return this.Cargoes;
    }//end method getCargoes

    /**SET Method Propertie Cargoes*/
    public void setCargoes(java.util.List<Cargo> Cargoes){
        this.Cargoes = Cargoes;
    }//end method setCargoes

//End GetterSetterExtension Source Code


}//End class