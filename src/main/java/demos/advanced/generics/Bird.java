package demos.advanced.generics;

public class Bird extends Animal{

        public Bird(String name) {
            super(name, (short)2);
        }

        public void layEggs() {
            System.out.println("Laying eggs");
        }
}
