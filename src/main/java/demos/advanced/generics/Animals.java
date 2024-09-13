package demos.advanced.generics;

import java.util.List;

public class Animals {

    static void breather(List<? extends Animal> animals) { //<T extends Animal>
        for (Animal animal : animals) {
            animal.breathe();
        }
    }
}
