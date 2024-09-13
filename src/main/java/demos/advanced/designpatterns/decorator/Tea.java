package demos.advanced.designpatterns.decorator;

/**
 * Creation date: Jul 08, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class Tea implements Beverage {
    @Override
    public void prepare() {
        System.out.println("Making plain tea");
    }
}
