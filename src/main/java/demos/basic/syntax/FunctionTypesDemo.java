package demos.basic.syntax;

import java.util.ArrayList;
import java.util.List;

public class FunctionTypesDemo {
    static List<String> zoo;
    List<String> fruits = new ArrayList<>();

    /*CLASS INITIALIZER*/
    static{
        zoo = new ArrayList<>(List.of("Giraffe", "Mouse", "Scorpion", "Zebra"));
    }

    /*OBJECT INITIALIZER -- RUNS BEFORE ANY CONSTRUCTOR*/
    {
        /*A LAMBDA:    f -> fruits.add(f)*/
        List.of("Kiwi", "Orange", "Mango", "Pear")
                .stream()
                .forEach(f -> fruits.add(f));

        // of course this would have been better,
        // but then there would have been no lambda:
        // fruits.addAll(List.of("Kiwi", "Orange", "Mango", "Pear"));
    }

    /*OVERLOADED CONSTRUCTOR*/
    FunctionTypesDemo() {
        fruits.add("apple");
    }

    /*OVERLOADED CONSTRUCTOR*/
    FunctionTypesDemo(String fruit) {
        fruits.add(fruit);
    }

    /*INSTANCE METHOD*/
    String getFruit(int index) {
        return this.fruits.get(index);
    }

    /*A STATIC (CLASS) METHOD*/
    static void addAnimal(String animal) {
        FunctionTypesDemo.zoo.add(animal);
    }

    /*A SPECIAL CASE CLASS METHOD*/
    public static void main(String[] args) {
        FunctionTypesDemo demo = new FunctionTypesDemo();
        System.out.println(demo.fruits);
        System.out.println("Fruit at index 1 is " + demo.getFruit(1));
        FunctionTypesDemo.addAnimal("Platypus");
        System.out.println(FunctionTypesDemo.zoo);
    }
}
