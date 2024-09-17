package section6_design.part1_encaps_abstr;

import java.util.ArrayList;
import java.util.List;

public class Snp {

    // Encapsulated private fields
    private final long position;
    private final char referenceNucleotide;
    private final List<VariantCount> variantCounts;

    // Private constructor to enforce encapsulation
    private Snp(Builder builder) {
        this.position = builder.position;
        this.referenceNucleotide = builder.referenceNucleotide;
        this.variantCounts = builder.variantCounts;
    }

    // Inner class representing a variant and its count
    private static class VariantCount {
        private final char nucleotide;
        private final int count;

        public VariantCount(char nucleotide, int count) {
            this.nucleotide = nucleotide;
            this.count = count;
        }

        public char getNucleotide() {
            return nucleotide;
        }

        public int getCount() {
            return count;
        }
    }

    // Public API Method: Using Builder pattern instead of factory method
    public static class Builder {
        private long position;
        private char referenceNucleotide;
        private List<VariantCount> variantCounts = new ArrayList<>();

        public Builder setPosition(long position) {
            this.position = position;
            return this;
        }

        public Builder setReferenceNucleotide(char referenceNucleotide) {
            this.referenceNucleotide = referenceNucleotide;
            return this;
        }

        public Builder addVariant(char nucleotide, int count) {
            this.variantCounts.add(new VariantCount(nucleotide, count));
            return this;
        }

        public Snp build() {
            return new Snp(this);
        }
    }

    // Public API Method: Returns a list of variants (including the reference)
    public List<String> getVariants() {
        List<String> variants = new ArrayList<>();
        for (VariantCount vc : variantCounts) {
            variants.add(vc.getNucleotide() + " (" + vc.getCount() + ")");
        }
        return variants;
    }

    // Public API Method: Returns the frequency of a specific variant
    public double getFrequency(char variant) {
        int total = variantCounts.stream().mapToInt(VariantCount::getCount).sum();
        return variantCounts.stream()
                .filter(vc -> vc.getNucleotide() == variant)
                .mapToDouble(vc -> (double) vc.getCount() / total)
                .findFirst()
                .orElse(0.0);
    }

    // Public API Method: Returns the minor allele (lowest frequency)
    public char getMinorAllele() {
        return variantCounts.stream()
                .min((vc1, vc2) -> Integer.compare(vc1.getCount(), vc2.getCount()))
                .map(VariantCount::getNucleotide)
                .orElse(referenceNucleotide);
    }

    // Public API Method: Returns the frequency of the minor allele
    public double getMinorAlleleFrequency() {
        int total = variantCounts.stream().mapToInt(VariantCount::getCount).sum();
        return variantCounts.stream()
                .min((vc1, vc2) -> Integer.compare(vc1.getCount(), vc2.getCount()))
                .map(vc -> (double) vc.getCount() / total)
                .orElse(0.0);
    }
}
