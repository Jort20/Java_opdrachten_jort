package section5_adv_apis.part1_junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProteinTest {

    private Protein protein;

    @BeforeEach
    public void setUp() {
        protein = new Protein();
    }

    @Test
    public void testSetSequenceSunnyDay() {
        protein.setSequence("ACDEFGHIKLMNPQRSTVWY");
        assertEquals("ACDEFGHIKLMNPQRSTVWY", protein.getSequence());
    }

    @Test
    public void testSetSequenceInvalidCharacter() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            protein.setSequence("ACDEFGHIKLMNPQRSTVWZ"); // Z is not a legal amino acid
        });
        assertEquals("bla", thrown.getMessage());
    }

    @Test
    public void testSetSequenceNull() {
        assertThrows(NullPointerException.class, () -> {
            protein.setSequence(null);
        });
    }

    @Test
    public void testGetAminoAcidFractionSunnyDay() {
        protein.setSequence("AACCGGTT");
        assertEquals(0.25, protein.getAminoAcidFraction('A'), 0.0001);
        assertEquals(0.25, protein.getAminoAcidFraction('C'), 0.0001);
        assertEquals(0.25, protein.getAminoAcidFraction('G'), 0.0001);
        assertEquals(0.25, protein.getAminoAcidFraction('T'), 0.0001);
    }

    @Test
    public void testGetAminoAcidFractionNoOccurrence() {
        protein.setSequence("AACCGGTT");
        assertEquals(0.0, protein.getAminoAcidFraction('X'), 0.0001);
    }

    @Test
    public void testGetAminoAcidFractionEmptySequence() {
        protein.setSequence("");
        assertEquals(0.0, protein.getAminoAcidFraction('A'), 0.0001);
    }

    @ParameterizedTest
    @CsvSource({
            "A, 0.0",
            "C, 0.0",
            "G, 0.0",
            "T, 0.0"
    })
    public void testGetAminoAcidFractionParameterized(char aminoAcid, double expectedFraction) {
        protein.setSequence("");
        assertEquals(expectedFraction, protein.getAminoAcidFraction(aminoAcid), 0.0001);
    }
}

