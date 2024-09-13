package demos.advanced.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {
    public static void main(String[] args) {
        //preGenericsDemo();
        //postGenericsDemo();
        collectionGenericsDemo();
    }

    private static void collectionGenericsDemo() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Mammal("Mouse"));
        animals.add(new Mammal("Elephant"));
        animals.add(new Bird("Buzzard"));

        Animals.breather(animals); //OK

        List<Mammal> mammals = new ArrayList<>();
        mammals.add(new Mammal("Mouse"));
        mammals.add(new Mammal("Elephant"));
        Animals.breather(mammals); //Compile error before refactor to generics

        Animals.breather(animals); //OK after refactor to generics

    }

    static void preGenericsDemo() {
        //creating a List which holds no specific type
        List animals = new ArrayList();

        //adding some animals to the list
        animals.add(new Mammal("Mouse"));
        animals.add(new Mammal("Elephant"));
        animals.add(new Bird("Buzzard"));
        animals.add("Imposter");

        //retrieving the animals from the list
        for (Object object: animals) {
            if (object instanceof Animal) {
                Animal animal = (Animal) object;
                animal.breathe();
            } else {
                System.out.println("Not an animal: " + object.getClass().getSimpleName());
            }
        }
    }

    static void postGenericsDemo() {
        //creating a List which holds no specific type
        List<Animal> animals = new ArrayList<>();

        //adding some animals to the list
        animals.add(new Mammal("Mouse"));
        animals.add(new Mammal("Elephant"));
        animals.add(new Bird("Buzzard"));
        //animals.add("Imposter");

        //retrieving the animals from the list
        for (Animal animal: animals) {
            animal.breathe();
        }
    }
}
