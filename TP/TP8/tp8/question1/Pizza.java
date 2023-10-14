package question1;

 
/** exemple inspir� de Head First Design Pattern, page92 
 * Pattern d�corateur, ici le "Component"
 */
public interface Pizza{
	/** Une description textuelle de la Pizza */
  abstract public String getDescription();
  
  /** le prix de vente */
  abstract public double cost();
}
