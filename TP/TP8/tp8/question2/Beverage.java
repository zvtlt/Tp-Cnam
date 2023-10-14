package question2;
/**
 * extrait de http://www.oreilly.com/catalog/hfdesignpat/
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public String toString(){
        return this.getDescription() + " $" + this.cost();
    }

}
