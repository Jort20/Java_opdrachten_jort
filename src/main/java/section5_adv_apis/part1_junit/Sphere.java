package section5_adv_apis.part1_junit;

// Sphere.java
public class Sphere {
    private double radius;

    // Constructor
    public Sphere(double radius) {
        this.radius = radius;
    }

    // Method to calculate volume: V = (4/3) * pi * r^3
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    // Method to calculate surface area: A = 4 * pi * r^2
    public double getSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    // Optional: Getter for radius
    public double getRadius() {
        return radius;
    }

    // Optional: Setter for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }
}

