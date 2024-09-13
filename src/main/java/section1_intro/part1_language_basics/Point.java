package section1_intro.part1_language_basics;


public class Point {
    int x;
    int y;

    /**
     * Create an instance of class point that is located at the same coordinates as the current object, but in the
     * diagonally opposing quadrant of coordinate space.
     * So, when the current point is at (4, 4), this method will return Point(-4, -4)
     * and when the current point is at (2, -5) it will return Point(-2, 5).
     * @return inverse Point
     */

    Point createInversePoint() {
        Point p = new Point();

        p.x = x * -1;
        p.y = y * -1;
        return p;
    }

    /**
     * This method returns the Euclidean distance of the current point (this) to the given point (otherPoint).
     * GIYF if you forgot what Euclidean distance is and how it is calculated.
     * @param otherPoint
     * @return euclidean distance
     */
    double euclideanDistanceTo(Point otherPoint) {
        Point p = new Point();
        int andereX = otherPoint.x - p.x;
        int andereY = otherPoint.y -p.y;
        return Math.sqrt(andereX * andereX + andereY * andereY);
    }
    public static void main(String[] args) {
        // Create two points
        Point p1 = new Point();
        p1.x = 3;
        p1.y = 4;

        Point p2 = new Point();
        p2.x = 7;
        p2.y = 1;

        // Calculate and print the Euclidean distance between p1 and p2
        double distance = p1.euclideanDistanceTo(p2);
        System.out.println("Euclidean Distance between p1 and p2: " + distance);

        // Create and print the inverse of p1
        Point inverseP1 = p1.createInversePoint();
        System.out.println("Inverse of p1: (" + inverseP1.x + ", " + inverseP1.y + ")");

        // Create and print the inverse of p2
        Point inverseP2 = p2.createInversePoint();
        System.out.println("Inverse of p2: (" + inverseP2.x + ", " + inverseP2.y + ")");
    }
}


