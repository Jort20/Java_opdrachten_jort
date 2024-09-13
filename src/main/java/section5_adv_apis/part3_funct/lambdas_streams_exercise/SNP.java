package section5_adv_apis.part3_funct.lambdas_streams_exercise;

import java.util.ArrayList;
import java.util.List;

public class SNP {
    private final long position;
    private final char reference;
    private final char alternative;
    private final double minorAlleleFrequency;

    public SNP(long position, char reference, char alternative, double minorAlleleFrequency) {
        this.position = position;
        this.reference = reference;
        this.alternative = alternative;
        this.minorAlleleFrequency = minorAlleleFrequency;
    }

    public long getPosition() {
        return position;
    }

    public char getReference() {
        return reference;
    }

    public char getAlternative() {
        return alternative;
    }

    public double getMinorAlleleFrequency() {
        return minorAlleleFrequency;
    }

    @Override
    public String toString() {
        return "Snp{" +
                "position=" + position +
                ", reference=" + reference +
                ", alternative=" + alternative +
                ", minorAlleleFrequency=" + minorAlleleFrequency +
                '}';
    }

    public final static List<SNP> getSnpCollection() {
        List<SNP> snps = new ArrayList<>();
        snps.add(new SNP(100273, 'A', 'G', 0.0123));
        snps.add(new SNP(100275, 'A', 'C', 0.00323));
        snps.add(new SNP(117807, 'T', 'G', 0.1915));
        snps.add(new SNP(162889, 'C', 'G', 0.000872));
        snps.add(new SNP(190199, 'T', 'C', 0.1019));
        snps.add(new SNP(277614, 'A', 'G', 0.0168));
        snps.add(new SNP(372778, 'C', 'A', 0.0000424));
        snps.add(new SNP(417752, 'A', 'G', 1.8474e-10));
        snps.add(new SNP(478808, 'A', 'G', 1.535689e-8));
        snps.add(new SNP(556920, 'T', 'G', 0.1097));
        snps.add(new SNP(676255, 'G', 'C', 1.6672e-3));
        snps.add(new SNP(667280, 'A', 'G', 0.00287));
        snps.add(new SNP(719876, 'C', 'A', 0.006649));
        snps.add(new SNP(828771, 'A', 'C', 0.097706));
        return snps;
    }
}

