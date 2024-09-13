package demos.advanced.designpatterns.statepattern;

/**
 * Creation date: Jul 07, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class CoffeeMachine {
    private CupState cupState;

    protected void setCupState(CupState cupState) {
        this.cupState = cupState;
    }

    protected CupState getCupState() {
        return this.cupState;
    }

    public void coffeeRequest() {
        this.cupState.coffeeRequest(this);
    }
}
