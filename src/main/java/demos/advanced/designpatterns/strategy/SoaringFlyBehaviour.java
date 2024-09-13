package demos.advanced.designpatterns.strategy;

/**
 * Created by michiel on 02/03/2017.
 */
public class SoaringFlyBehaviour implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("I am soaring on thermal vents");
    }
}
