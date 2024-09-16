package section5_adv_apis.part1_junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LineTest {

    // Delta for comparing double values
    private static final double DELTA = 1E-15;

    // Test for getSlope() method
    @Test
    public void testGetSlope() {
        // Test case 1: A simple positive slope
        Line line1 = new Line(0, 0, 2, 2);  // slope = 1
        assertEquals(1.0, line1.getSlope(), DELTA, "Slope of line1 should be 1.0");

        // Test case 2: A negative slope
        Line line2 = new Line(0, 0, 2, -2); // slope = -1
        assertEquals(-1.0, line2.getSlope(), DELTA, "Slope of line2 should be -1.0");

        // Test case 3: Horizontal line (slope = 0)
        Line line3 = new Line(0, 0, 5, 0);  // slope = 0
        assertEquals(0.0, line3.getSlope(), DELTA, "Slope of line3 should be 0.0");
    }

    // Test for getDistance() method
    @Test
    public void testGetDistance() {
        // Test case 1: Horizontal distance
        Line line1 = new Line(0, 0, 4, 0);  // distance = 4
        assertEquals(4.0, line1.getDistance(), DELTA, "Distance of line1 should be 4.0");

        // Test case 2: Vertical distance
        Line line2 = new Line(0, 0, 0, 3);  // distance = 3
        assertEquals(3.0, line2.getDistance(), DELTA, "Distance of line2 should be 3.0");

        // Test case 3: Diagonal distance (Pythagoras' theorem)
        Line line3 = new Line(0, 0, 3, 4);  // distance = 5 (3-4-5 triangle)
        assertEquals(5.0, line3.getDistance(), DELTA, "Distance of line3 should be 5.0");
    }

    // Test for parallelTo() method
    @Test
    public void testParallelTo() {
        // Test case 1: Parallel lines (same slope)
        Line line1 = new Line(0, 0, 2, 2);  // slope = 1
        Line line2 = new Line(1, 1, 3, 3);  // slope = 1
        assertTrue(line1.parallelTo(line2), "line1 should be parallel to line2");

        // Test case 2: Non-parallel lines (different slopes)
        Line line3 = new Line(0, 0, 1, 1);  // slope = 1
        Line line4 = new Line(0, 0, 1, 2);  // slope = 2
        assertFalse(line3.parallelTo(line4), "line3 should not be parallel to line4");

        // Test case 3: Parallel lines with negative slope
        Line line5 = new Line(0, 0, 1, -1);  // slope = -1
        Line line6 = new Line(2, 2, 3, 1);   // slope = -1
        assertTrue(line5.parallelTo(line6), "line5 should be parallel to line6");
    }
}
