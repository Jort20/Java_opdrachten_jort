package section5_adv_apis.part1_junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class PrimerParameterizedTest {

    // Delta for comparing double values (to handle precision issues)
    private static final double DELTA = 1E-6;

    @ParameterizedTest
    @CsvSource({
            "ATGC, 0.5",     // 50% GC
            "AAAA, 0.0",     // 0% GC
            "GGGG, 1.0",     // 100% GC
            "GCGCGC, 1.0",   // 100% GC
            "AATTCCGG, 0.5"  // 50% GC
    })
    public void testGetGcPercentage(String sequence, double expectedGcPercentage) {
        // Arrange
        Primer primer = new Primer(sequence);

        // Act
        double actualGcPercentage = primer.getGcPercentage();

        // Assert
        assertEquals(expectedGcPercentage, actualGcPercentage, DELTA,
                "GC percentage should match expected value for primer: " + sequence);
    }
}
