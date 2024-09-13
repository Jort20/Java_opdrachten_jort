package demos.basic.oop;

import demos.basic.oop.DNASequence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequencesTest {

    @Test
    void testSequenceCreation() {
        DNASequence dna = new DNASequence("GAATACCAGAT", "dna");
        System.out.println(dna.complement().reverse());
        System.out.println(dna.reverseComplement());

        assertEquals(dna.complement().reverse().sequence, dna.reverseComplement().sequence);
    }

}