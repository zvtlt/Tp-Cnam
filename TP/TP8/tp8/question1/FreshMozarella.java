package question1;

 


/**
 * D�crivez votre classe Mozarella ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class FreshMozarella extends PizzaDecorator{

	public FreshMozarella(Pizza p){
	  super(p);
	}

	public String getDescription(){
	  return pizza.getDescription() + ", fresh mozarella";
	}
	 
  public double cost(){
    return pizza.cost() + .50;
  }

}
