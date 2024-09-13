package section6_design.part0_refactoring;

import org.junit.jupiter.api.Test;
import section6_design.part0_refactoring.Rectangle.Point;
import section6_design.part0_refactoring.Rectangle.View;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {
    private static final double DELTA = 1e-15;
    @Test
    public void getCenter() throws Exception {
        View v = new View();
        Rectangle r = new Rectangle(v, 0, 0, 10, 20);
        Point observedP = r.getCenter();
        Point expectedP = new Point(5, 10);
        assertEquals(expectedP.x, observedP.x, DELTA);
        assertEquals(expectedP.y, observedP.y, DELTA);
    }

    @Test
    public void contains() throws Exception {
        View v = new View();
        Rectangle innerR = new Rectangle(v, 5, 8, 10, 20);
        Rectangle outerR = new Rectangle(v, 4, 7, 11, 21);
        assertTrue(outerR.contains(innerR));
        assertFalse(innerR.contains(outerR));
    }

    @Test
    public void accommodate() throws Exception {
        View v = new View();
        Rectangle innerR = new Rectangle(v, 5, 8, 10, 20);
        Rectangle outerR = new Rectangle(v, 4, 7, 11, 21);

        innerR.accommodate(outerR);
        assertTrue(innerR.contains(outerR));
    }

}