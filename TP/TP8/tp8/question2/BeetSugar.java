package question2;

/**
 * extrait de http://www.oreilly.com/catalog/hfdesignpat/
 */
public class BeetSugar extends CondimentDecorator  { // à rendre concrete
    public BeetSugar(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return super.getDescription() + ", Beet Sugar";
    }

    public double cost() {
        return .10 + super.cost();
    }

}