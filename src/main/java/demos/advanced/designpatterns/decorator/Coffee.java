package demos.advanced.designpatterns.decorator;

/**
 * Creation date: Jul 08, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class Coffee implements Beverage {
    @Override
    public void prepare() {
        System.out.println("Preparing a nice hot Java!");
    }
}
