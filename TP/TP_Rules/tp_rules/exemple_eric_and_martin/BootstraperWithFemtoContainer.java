package exemple_eric_and_martin;

import container.ApplicationContext;
import java.util.*;

import question1.SpecificationI;

// https://github.com/masoud-bahrami/Specification-Pattern-Samples

public class BootstraperWithFemtoContainer{

    private static List<Container> containers; 
    private static List<Cargo> cargoes; 

    public static void main(String[] args)throws Exception{
        //Bootstraper.main(null);
        
        ApplicationContext ctx = null;
        ctx = container.Factory.createApplicationContext("./exemple_eric_and_martin/README.TXT");

        containers = ctx.getBean("containers");
        cargoes = ctx.getBean("cargoes");

        Cargo cargoMeat = ctx.getBean("cargoMeat");
        cargoes.add(cargoMeat);

        Cargo cargoVegetable = ctx.getBean("cargoVegetable");
        cargoes.add(cargoVegetable);

        Cargo cargoParameterized = ctx.getBean("cargoParameterized");
        cargoes.add(cargoParameterized);

        try{
            for (int i = 0; i < 10; i++){
                Container container = ctx.getBean("container"+i);
                containers.add(container);
            }
        }catch(Exception e){}
        
        //generateContainers();
        assignContainerForCargos();
    }

    private static void generateContainers(){
        for (int i = 0; i < 10; i++){
            Container container = new Container();
            container.setId(i);
            container.setMaxWeight(i*2);
            container.setHasRefrigerator(i/2 == 0);
            container.setInternalTemperature(i-1);
            containers.add(container);
        }
        
    }

    private static void assignContainerForCargos(){
        for(Cargo cargo : cargoes){
            System.out.println("Cargo Id="+cargo.getId()+ ","+ cargo.getName());
            for (Container container :  containers) {
                System.out.print("Container " + container.getId());
                System.out.println(cargo.getStorageSpecification().isSatisfiedBy(container) ? " IsOkay" : " IsNotOkay");
            }
            System.out.println("-----------------------------------");
        }

    }
}
