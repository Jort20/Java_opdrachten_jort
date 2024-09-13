package demos.basic.enums;

import demos.basic.enums.Nucleotide;
import org.junit.jupiter.api.Test;

class NucleotideTest {

    @Test
    void getMolecularWeight() {
        Nucleotide nuc = Nucleotide.T;
        System.out.println(nuc.getMolecularWeight());
    }
}