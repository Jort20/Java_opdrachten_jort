package demos.advanced.generics;

public class Mammal extends Animal{

    public Mammal(String name) {
        super(name, (short)4);
    }

    public void giveBirth() {
        System.out.println("Giving birth to live young");
    }
}
