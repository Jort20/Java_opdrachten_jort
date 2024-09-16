package section5_adv_apis.part1_junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SphereTest {

    @Test
    public void testVolume() {
        // Test with radius = 1 (Expected volume = 4/3 * pi * r^3)
        Sphere sphere1 = new Sphere(1);
        assertEquals(4.0 / 3.0 * Math.PI, sphere1.getVolume(), 0.0001);

        // Test with radius = 2 (Expected volume = 4/3 * pi * 2^3)
        Sphere sphere2 = new Sphere(2);
        assertEquals(32.0 / 3.0 * Math.PI, sphere2.getVolume(), 0.0001);

        // Test with radius = 3 (Expected volume = 4/3 * pi * 3^3)
        Sphere sphere3 = new Sphere(3);
        assertEquals(4.0 / 3.0 * Math.PI * Math.pow(3, 3), sphere3.getVolume(), 0.0001);
    }

    @Test
    public void testSurfaceArea() {
        // Test with radius = 1 (Expected surface area = 4 * pi * r^2)
        Sphere sphere1 = new Sphere(1);
        assertEquals(4 * Math.PI * Math.pow(1, 2), sphere1.getSurfaceArea(), 0.0001);

        // Test with radius = 2 (Expected surface area = 4 * pi * 2^2)
        Sphere sphere2 = new Sphere(2);
        assertEquals(4 * Math.PI * Math.pow(2, 2), sphere2.getSurfaceArea(), 0.0001);

        // Test with radius = 3 (Expected surface area = 4 * pi * 3^2)
        Sphere sphere3 = new Sphere(3);
        assertEquals(4 * Math.PI * Math.pow(3, 2), sphere3.getSurfaceArea(), 0.0001);
    }
}
