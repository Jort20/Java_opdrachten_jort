package section6_design.part1_encaps_abstr;

import java.util.List;

public class Snp {
    long position;
    char referenceNucleotide;
    List<VariantCount> variantCounts;

    /**
     * A private constructor! You should implement the factory method of the public API.
     */
    private Snp() {
    }

    /**
     * a dedicated inner class; tightly bound to its enclosing class
     */
    private static class VariantCount {
        char nucleotide;
        int count;

        public VariantCount(char nucleotide, int count) {
            this.nucleotide = nucleotide;
            this.count = count;
        }
    }


    /*THE PUBLIC API METHODS TO BE SUPPORTED. DO NOT CHANGE THE SIGNATURE OF THESE!*/

    /**
     * This is a factory method. Much better is the builder pattern here.
     * This is an extra challenge you could take.
     *
     * @return
     */
    public static Snp createSnp(long position, char referenceNucleotide, char[] variants, int[] counts) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Returns a list of variants for this position - including the reference nucleotide
     *
     * @return variants-list
     */
    public List<String> getVariants() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Returns the frequency (a value between 0 and 1) of the given variant.
     *
     * @param variant
     * @return
     */
    public double getFrequency(char variant) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Returns the minor allele: the variant with the lowest frequency
     *
     * @return
     */
    public char getMinorAllele() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Returns the minor allele frequency: the frequency of the variant which is lowest in frequency.
     * Frequency is a value between 0 and 1.
     *
     * @return minor allele frequency
     */
    public double getMinorAlleleFrequency() {
        throw new UnsupportedOperationException("not implemented yet");
    }

}
