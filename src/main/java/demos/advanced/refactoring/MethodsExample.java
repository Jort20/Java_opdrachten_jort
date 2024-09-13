package demos.advanced.refactoring;

public abstract class MethodsExample {

    abstract Circle createCircle(double x, double y, double radius);

    abstract Circle createCircle(Point center, double radius);


    private static final class Circle {

    }

    private static final class Point {

    }
}
