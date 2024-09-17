/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package section4_oop.part1_inheritance;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class AnimalSimulator {

    public static void main(String[] args) {
        AnimalSimulator anSim = new AnimalSimulator();
        anSim.start(args);
    }

    private void start(String[] args) {
        // Controleer of er geen argumenten zijn of het argument 'help' is
        if (args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase("help"))) {
            printHelp();
            return;
        }

        // Verwerking van de command-line argumenten
        try {
            for (int i = 0; i < args.length; i += 2) {
                String species = args[i];
                int age = Integer.parseInt(args[i + 1]);
                Animal animal = createAnimal(species, age);
                System.out.println(getArticle(species) + " " + species + " of age " + age + " moving in "
                        + animal.getMovementType() + " at " + String.format("%.1f", animal.getSpeed()) + " km/h");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void printHelp() {
        System.out.println("Usage: java AnimalSimulator <Species age Species age ...>");
        System.out.println("Supported species (in alphabetical order):");
        System.out.println("1: Elephant");
        System.out.println("2: Horse");
        System.out.println("3: Mouse");
        System.out.println("4: Tortoise");
    }

    private Animal createAnimal(String species, int age) {
        switch (species.toLowerCase()) {
            case "horse":
                return new Horse(age);
            case "elephant":
                return new Elephant(age);
            case "mouse":
                return new Mouse(age);
            case "tortoise":
                return new Tortoise(age);
            default:
                throw new IllegalArgumentException("animal species " + species + " is not known. run with single parameter \"help\" to get a listing of available species. Please give new values");
        }
    }

    private String getArticle(String species) {
        return "AEIOUaeiou".indexOf(species.charAt(0)) != -1 ? "An" : "A";
    }

    public List<String> getSupportedAnimals() {
        List<String> animals = new ArrayList<>();
        animals.add("Elephant");
        animals.add("Horse");
        animals.add("Mouse");
        animals.add("Tortoise");
        animals.sort(String::compareTo);
        return animals;
    }
}
