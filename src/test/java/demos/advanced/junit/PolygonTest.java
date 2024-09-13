package demos.advanced.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolygonTest {
    @Tag("never")
    @DisplayName("Length of Polygon")
    @Test
    public void getLength() {
        Polygon polygon = new Polygon();
        double expectedLength = 0;
        assertEquals(expectedLength, polygon.getLength());
    }

    private Polygon polygon;

    @BeforeEach
    public void resetPolygon() {
        polygon = new Polygon();
        polygon.addCoordinate(new Coordinate(1, 2));
        polygon.addCoordinate(new Coordinate(3, 6));
    }
}
