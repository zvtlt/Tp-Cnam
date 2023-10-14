package exemple_eric_and_martin;

//https://github.com/masoud-bahrami/Specification-Pattern-Samples/#readme

import question1.SpecificationI;
// extrait de https://github.com/masoud-bahrami/Specification-Pattern-Samples/
import java.util.List;
import java.util.ArrayList;

public class Bootstraper{

    private static List<Container> containers; 
    private static List<Cargo> cargoes; 

    public static void main(String[] args){
        initialize();
        generateContainers();
        generateCargos();
        assignContainerForCargos();

    }

    private static void initialize(){
        Bootstraper.containers = new ArrayList<Container>();
        Bootstraper.cargoes = new ArrayList<Cargo>();
    }

    private static void generateContainers(){
        for (int i = 0; i < 10; i++){
            Container container = new Container();
            container.setId(i);
            container.setMaxWeight(i*2);
            container.setHasRefrigerator(i/2 == 0);
            container.setInternalTemperature(i-1);
            Bootstraper.containers.add(container);

        }
    }

    private static void generateCargos(){
        //Using Strategy Pattern for Storage Specification
        Cargo cargoMeat = new Cargo(new MeatStorageSpecification());
        cargoMeat.setId(1);
        cargoMeat.setName("Meat");
        cargoMeat.setWeight(20);
        Bootstraper.cargoes.add(cargoMeat);

        Cargo cargoVegetable = new Cargo(new VegetableStorageSpecification());
        cargoVegetable.setId(2);
        cargoVegetable.setName("Vegetable");
        cargoVegetable.setWeight(30);
        Bootstraper.cargoes.add(cargoVegetable);

        Cargo cargoParameterized = new Cargo(new ParameterizedStorageSpecification(3,2));
        cargoParameterized.setId(3);
        cargoParameterized.setName("Milk");
        cargoParameterized.setWeight(20);
        Bootstraper.cargoes.add(cargoParameterized);
    }

    private static void assignContainerForCargos(){
        for(Cargo cargo : Bootstraper.cargoes){
            System.out.println("Cargo Id="+cargo.getId()+ ","+ cargo.getName());
            for (Container container :  Bootstraper.containers) {
                System.out.print("Container " + container.getId());
                System.out.println(cargo.getStorageSpecification().isSatisfiedBy(container) ? " IsOkay" : " IsNotOkay");
            }
            System.out.println("-----------------------------------");
        }

    }
}
