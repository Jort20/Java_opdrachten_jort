package demos.advanced.designpatterns.decorator;

/**
 * Creation date: Jul 08, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("..adding milk");
    }
}
