package demos.basic.testtube;

import demos.basic.testtube.TestTube;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTubeTest {

    @Test
    void growCells() {
        TestTube testTube = new TestTube(10);
        assertTrue(testTube.cells.length == 10);
    }

    @Test
    void growCells_withZeroInput() {
        assertThrows(IllegalArgumentException.class, () -> new TestTube(0));
    }
}