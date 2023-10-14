# https://github.com/masoud-bahrami/Specification-Pattern-Samples/#readme
#verbose=true

bean.id.1=containers
containers.class=java.util.ArrayList

bean.id.2=cargoes
cargoes.class=java.util.ArrayList

bean.id.3=meatStorageSpecification
meatStorageSpecification.class=exemple_eric_and_martin.MeatStorageSpecification

#        Cargo cargoMeat = new Cargo(new MeatStorageSpecification());
#        cargoMeat.setId(1);
#        cargoMeat.setName("Meat");
#        cargoMeat.setWeight(20);
#        Bootstraper.cargoes.add(cargoMeat);

bean.id.4=cargoMeat
cargoMeat.class=exemple_eric_and_martin.Cargo
cargoMeat.property.1=id
cargoMeat.property.1.param.1=1
cargoMeat.property.2=name
cargoMeat.property.2.param.1=Meat
cargoMeat.property.3=weight
cargoMeat.property.3.param.1=20
cargoMeat.property.4=storageSpecification
cargoMeat.property.4.param.1=meatStorageSpecification


#        Cargo cargoVegetable = new Cargo(new VegetableStorageSpecification());
#        cargoVegetable.setId(2);
#        cargoVegetable.setName("Vegetable");
#        cargoVegetable.setWeight(30);
#        Bootstraper.cargoes.add(cargoVegetable);
bean.id.5=vegetableStorageSpecification
vegetableStorageSpecification.class=exemple_eric_and_martin.VegetableStorageSpecification

bean.id.6=cargoVegetable
cargoVegetable.class=exemple_eric_and_martin.Cargo
cargoVegetable.property.1=id
cargoVegetable.property.1.param.1=2
cargoVegetable.property.2=name
cargoVegetable.property.2.param.1=Vegetable
cargoVegetable.property.3=weight
cargoVegetable.property.3.param.1=30
cargoVegetable.property.4=storageSpecification
cargoVegetable.property.4.param.1=vegetableStorageSpecification


#        Cargo cargoParameterized = new Cargo(new ParameterizedStorageSpecification(3,2));
#        cargoParameterized.setId(3);
#        cargoParameterized.setName("Milk");
#        cargoParameterized.setWeight(20);
#        Bootstraper.cargoes.add(cargoParameterized);

bean.id.7=parameterizedStorageSpecification
parameterizedStorageSpecification.class=exemple_eric_and_martin.ParameterizedStorageSpecification
parameterizedStorageSpecification.property.1=maxWeight
parameterizedStorageSpecification.property.1.param.1=2
parameterizedStorageSpecification.property.2=maxTemp
parameterizedStorageSpecification.property.2.param.1=3

bean.id.8=cargoParameterized
cargoParameterized.class=exemple_eric_and_martin.Cargo
cargoParameterized.property.1=id
cargoParameterized.property.1.param.1=3
cargoParameterized.property.2=name
cargoParameterized.property.2.param.1=Milk
cargoParameterized.property.3=weight
cargoParameterized.property.3.param.1=20
cargoParameterized.property.4=storageSpecification
cargoParameterized.property.4.param.1=parameterizedStorageSpecification


#   private static void generateContainers(){
#        for (int i = 0; i < 10; i++){
#            Container container = new Container();
#            container.setId(i);
#            container.setMaxWeight(i*2);
#            container.setHasRefrigerator(i/2 == 0);
#            container.setInternalTemperature(i-1);
#            containers.add(container);
#        }
#   }

bean.id.9=container0
container0.class=exemple_eric_and_martin.Container
container0.property.1=id
container0.property.1.param.1=0
container0.property.2=maxWeight
container0.property.2.param.1=0
container0.property.3=hasRefrigerator
container0.property.3.param.1=true
container0.property.4=internalTemperature
container0.property.4.param.1=-1

bean.id.10=container1
container1.class=exemple_eric_and_martin.Container
container1.property.1=id
container1.property.1.param.1=1
container1.property.2=maxWeight
container1.property.2.param.1=2
container1.property.3=hasRefrigerator
container1.property.3.param.1=false
container1.property.4=internalTemperature
container1.property.4.param.1=0

bean.id.11=container2
container2.class=exemple_eric_and_martin.Container
container2.property.1=id
container2.property.1.param.1=2
container2.property.2=maxWeight
container2.property.2.param.1=4
container2.property.3=hasRefrigerator
container2.property.3.param.1=true
container2.property.4=internalTemperature
container2.property.4.param.1=1

bean.id.12=container3
container3.class=exemple_eric_and_martin.Container
container3.property.1=id
container3.property.1.param.1=3
container3.property.2=maxWeight
container3.property.2.param.1=6
container3.property.3=hasRefrigerator
container3.property.3.param.1=false
container3.property.4=internalTemperature
container3.property.4.param.1=2

bean.id.13=container4
container4.class=exemple_eric_and_martin.Container
container4.property.1=id
container4.property.1.param.1=4
container4.property.2=maxWeight
container4.property.2.param.1=8
container4.property.3=hasRefrigerator
container4.property.3.param.1=true
container4.property.4=internalTemperature
container4.property.4.param.1=3

bean.id.14=container5
container5.class=exemple_eric_and_martin.Container
container5.property.1=id
container5.property.1.param.1=5
container5.property.2=maxWeight
container5.property.2.param.1=10
container5.property.3=hasRefrigerator
container5.property.3.param.1=false
container5.property.4=internalTemperature
container5.property.4.param.1=4

bean.id.15=container6
container6.class=exemple_eric_and_martin.Container
container6.property.1=id
container6.property.1.param.1=6
container6.property.2=maxWeight
container6.property.2.param.1=12
container6.property.3=hasRefrigerator
container6.property.3.param.1=true
container6.property.4=internalTemperature
container6.property.4.param.1=5

bean.id.16=container7
container7.class=exemple_eric_and_martin.Container
container7.property.1=id
container7.property.1.param.1=7
container7.property.2=maxWeight
container7.property.2.param.1=14
container7.property.3=hasRefrigerator
container7.property.3.param.1=false
container7.property.4=internalTemperature
container7.property.4.param.1=6

bean.id.17=container8
container8.class=exemple_eric_and_martin.Container
container8.property.1=id
container8.property.1.param.1=8
container8.property.2=maxWeight
container8.property.2.param.1=16
container8.property.3=hasRefrigerator
container8.property.3.param.1=true
container8.property.4=internalTemperature
container8.property.4.param.1=7

bean.id.18=container9
container9.class=exemple_eric_and_martin.Container
container9.property.1=id
container9.property.1.param.1=9
container9.property.2=maxWeight
container9.property.2.param.1=18
container9.property.3=hasRefrigerator
container9.property.3.param.1=false
container9.property.4=internalTemperature
container9.property.4.param.1=8

