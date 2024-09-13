package demos.advanced.designpatterns.statepattern;

import demos.advanced.designpatterns.statepattern.CoffeeMachine;
import demos.advanced.designpatterns.statepattern.EmptyCupState;
import demos.advanced.designpatterns.statepattern.FullCupState;
import demos.advanced.designpatterns.statepattern.NoCupState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Creation date: Jul 07, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class CoffeeMachineTest {
    @Test
    public void coffeeRequest() throws Exception {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        //machine is empty
        coffeeMachine.setCupState(new NoCupState());
        coffeeMachine.coffeeRequest(); //request 1
        coffeeMachine.coffeeRequest(); //request 2
        coffeeMachine.setCupState(new EmptyCupState());
        coffeeMachine.coffeeRequest(); //request 3

        assertEquals(FullCupState.class, coffeeMachine.getCupState().getClass());
    }

}