package section1_intro.part1_language_basics;

public class GeometryAnalyser {
    public static void main(String[] args) {
        // Parse the command-line arguments into Point instances
        Point p1 = new Point();
        p1.x = Integer.parseInt(args[0]);
        p1.y = Integer.parseInt(args[1]);

        Point p2 = new Point();
        p2.x = Integer.parseInt(args[2]);
        p2.y = Integer.parseInt(args[3]);

        // Determine the operation (either "surf" or "dist")
        String operation = args[4];

        if (operation.equals("surf")) {
            // Calculate the surface area of the rectangle
            int width = Math.abs(p2.x - p1.x);
            int height = Math.abs(p2.y - p1.y);
            int surface = width * height;
            System.out.println(surface);
        } else if (operation.equals("dist")) {
            // Calculate the distance between the two points
            double distance = Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
            // Round the result to 1 decimal place
            System.out.printf("%.1f%n", distance);
        }
    }
}
