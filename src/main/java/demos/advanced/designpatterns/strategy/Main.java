package demos.advanced.designpatterns.strategy;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<AbstractBird> birds = new ArrayList<>();
        SoaringFlyBehaviour sfb = new SoaringFlyBehaviour();
        NoFlyBehaviour nfb = new NoFlyBehaviour();
        Buzzard b = new Buzzard();
        b.setFlyBehaviour(sfb);
        Eagle e = new Eagle();
        e.setFlyBehaviour(sfb);
        Kiwi k = new Kiwi();
        k.setFlyBehaviour(nfb);
        birds.add(b);
        birds.add(e);
        birds.add(k);


        for (AbstractBird ab : birds) {
            ab.fly();
        }
        b.getShot();

        for (AbstractBird ab : birds) {
            ab.fly();
        }

    }
}
