package demos.advanced.generics;

import java.util.Objects;

public abstract class Animal {
    public String name;
    public short legs;

    public Animal(String name, short legs) {
        this.name = name;
        this.legs = legs;
    }

    public String getName() {
        return name;
    }

    public short getLegs() {
        return legs;
    }

    public void breathe() {
        System.out.println(getClass().getSimpleName() + ", breathing");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", legs=" + legs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return legs == animal.legs && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, legs);
    }
}
