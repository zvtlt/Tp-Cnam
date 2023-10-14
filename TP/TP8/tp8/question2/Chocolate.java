package question2;

/**
 * extrait de http://www.oreilly.com/catalog/hfdesignpat/
 */
public class Chocolate extends Beverage { // à rendre concréte
    public Chocolate() {
        description = "Chocolate";
    }

    public double cost() {
        return 2.10;
    }
}

