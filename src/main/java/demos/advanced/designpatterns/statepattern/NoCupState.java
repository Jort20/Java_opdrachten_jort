package demos.advanced.designpatterns.statepattern;

/**
 * Creation date: Jul 07, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class NoCupState implements CupState {
    @Override
    public void coffeeRequest(CoffeeMachine context) {
        System.out.println("Placing a cup first..");
        context.setCupState(new EmptyCupState());
        context.coffeeRequest();
    }
}
