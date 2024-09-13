package demos.advanced.oop_basics.solid;

/**
 * Creation date: Jul 06, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class LspDemo {

    public static abstract class Bird {
        public abstract void fly();
    }

    public static class Parrot extends Bird {
        public void fly() { /* implementation */ }

        public void speak() { /* implementation */ }
    }

    public static class Penguin extends Bird {
        public void fly() {
            throw new UnsupportedOperationException();
        }
    }

    public static void playWith(Bird bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        Parrot myPet = new Parrot();
        playWith(myPet); // myPet "is-a" bird and can fly()
        Penguin myOtherPet = new Penguin();
        playWith(myOtherPet); // myOtherPet "is-a" bird
        // and cannot fly()?!
    }
}
