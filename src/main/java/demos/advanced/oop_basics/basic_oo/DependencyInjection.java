package demos.advanced.oop_basics.basic_oo;

import java.util.Objects;

public class DependencyInjection {

    static class Car {
        private Wheel wheel;
        private Battery battery;

        // Constructor Based DI
        Car(Wheel wh, Battery bt) {
            this.wheel = Objects.requireNonNull(wh, "Wheel should be non-null!");
            this.battery = bt;
        }

        // Setter Based DI
        void setWheel(Wheel wh) {
            this.wheel = wh;
        }

        // Rest of code
    }

    private static class Wheel {
    }

    private static class Battery {
    }

    public static void main(String[] args) {
        Car car = new Car(null, new Battery());
    }
}
