package demos.advanced.designpatterns.statepattern;

/**
 * Creation date: Jul 07, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class EmptyCupState implements CupState {
    @Override
    public void coffeeRequest(CoffeeMachine context) {
        System.out.println("Pouring a nice Java!");
        context.setCupState(new FullCupState());
    }
}
