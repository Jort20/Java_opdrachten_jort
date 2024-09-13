package demos.advanced.oop_basics.basic_oo;

import java.util.ArrayList;
import java.util.List;

public class PartyPooper {

    public static void main(String[] args) {
        List<Dippable> snacks = createSnacks();
        for (Dippable d : snacks) {
            if (d instanceof Veggie) {
                System.out.println("Yeah, healthy snackin' going on!");
            }
            for (Dip dip : Dip.values()) {
                try {
                    d.dip(dip);
                } catch (IllegalDipOperation ido) {
                    System.out.println(d + " was illegally dipped in " + dip);
                }
            }
        }
    }


    public static List<Dippable> createSnacks() {
        List<Dippable> snacks = new ArrayList<>();
        Croquette croquette = new Croquette();
        snacks.add(croquette);

        Chips chips = new Chips();
        snacks.add(chips);

        Cheese cheese = new Cheese();
        snacks.add(cheese);

//        try {
//            cheese.dip(Dip.GUACEMOLE);
//        } catch (IllegalDipOperation ido) {
//            //ido.printStackTrace();
//            System.out.println("Cheese was illegally dipped in Guacemole");
//        }

        Cucumber cucumber = new Cucumber();
        snacks.add(cucumber);

        Carrot carrot = new Carrot();
        snacks.add(carrot);
        return snacks;
    }
}


