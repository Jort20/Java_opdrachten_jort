package demos.advanced.refactoring.fastqc;

import demos.advanced.refactoring.fastqc.FastQC;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FastQCTest {

    @Test
    void isFailedSequence_true() {
        assertTrue(FastQC.isFailedSequence(20, 0));
        assertTrue(FastQC.isFailedSequence(29, 0));
        assertTrue(FastQC.isFailedSequence(35, 11));
        assertTrue(FastQC.isFailedSequence(30, 10));
    }

    @Test
    void isFailedSequence_false() {
        assertFalse(FastQC.isFailedSequence(31, 0));
        assertFalse(FastQC.isFailedSequence(40, 9));
    }
}