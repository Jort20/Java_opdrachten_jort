package demos.advanced.designpatterns.strategy;

/**
 * Created by michiel on 02/03/2017.
 */
public class NoFlyBehaviour implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("I have really stupid wings so I only walk.");
    }
}
