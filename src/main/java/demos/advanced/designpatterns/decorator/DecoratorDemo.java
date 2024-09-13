package demos.advanced.designpatterns.decorator;

/**
 * Creation date: Jul 08, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        //create coffee with milk and sugar
        Beverage coffee = new MilkDecorator(
                new SugarDecorator(
                        new Coffee()));
        coffee.prepare();

        //create tea with sugar only
        Beverage tea = new SugarDecorator(
                new Tea());
        tea.prepare();
    }
}
