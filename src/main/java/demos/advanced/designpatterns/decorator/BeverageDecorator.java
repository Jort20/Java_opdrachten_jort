package demos.advanced.designpatterns.decorator;

/**
 * Creation date: Jul 08, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public abstract class BeverageDecorator implements Beverage {
    private final Beverage decoratedBeverage;

    public BeverageDecorator(Beverage beverage) {
        this.decoratedBeverage = beverage;
    }

    @Override
    public void prepare() {
        decoratedBeverage.prepare();
    }
}
