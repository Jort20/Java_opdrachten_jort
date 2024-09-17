package section6_design.part1_encaps_abstr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SnpTest {

    @Test
    public void testCreateSnp() {
        Snp snp = new Snp.Builder()
                .setPosition(1000)
                .setReferenceNucleotide('A')
                .addVariant('A', 50)
                .addVariant('T', 20)
                .addVariant('G', 30)
                .build();

        assertNotNull(snp);
    }

    @Test
    public void testGetVariants() {
        Snp snp = new Snp.Builder()
                .setPosition(1000)
                .setReferenceNucleotide('A')
                .addVariant('A', 50)
                .addVariant('T', 20)
                .addVariant('G', 30)
                .build();

        List<String> variants = snp.getVariants();
        assertEquals(3, variants.size());
        assertTrue(variants.contains("A (50)"));
        assertTrue(variants.contains("T (20)"));
        assertTrue(variants.contains("G (30)"));
    }

    @Test
    public void testGetFrequency() {
        Snp snp = new Snp.Builder()
                .setPosition(1000)
                .setReferenceNucleotide('A')
                .addVariant('A', 50)
                .addVariant('T', 20)
                .addVariant('G', 30)
                .build();

        assertEquals(0.50, snp.getFrequency('A'), 0.01);
        assertEquals(0.20, snp.getFrequency('T'), 0.01);
        assertEquals(0.30, snp.getFrequency('G'), 0.01);
    }

    @Test
    public void testGetMinorAllele() {
        Snp snp = new Snp.Builder()
                .setPosition(1000)
                .setReferenceNucleotide('A')
                .addVariant('A', 50)
                .addVariant('T', 20)
                .addVariant('G', 30)
                .build();

        assertEquals('T', snp.getMinorAllele());
    }

    @Test
    public void testGetMinorAlleleFrequency() {
        Snp snp = new Snp.Builder()
                .setPosition(1000)
                .setReferenceNucleotide('A')
                .addVariant('A', 50)
                .addVariant('T', 20)
                .addVariant('G', 30)
                .build();

        assertEquals(0.20, snp.getMinorAlleleFrequency(), 0.01);
    }
}
