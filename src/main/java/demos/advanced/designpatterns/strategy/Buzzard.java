package demos.advanced.designpatterns.strategy;

/**
 * Created by michiel on 02/03/2017.
 */
public class Buzzard extends AbstractBird {
    public Buzzard() {
        super.setName("Buizerd");
    }

    public void getShot() {
        super.setFlyBehaviour(new NoFlyBehaviour());
    }
}
