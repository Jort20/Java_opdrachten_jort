package demos.basic.enums;

import java.util.Map;

public enum Nucleotide {
    A("Adenine"),
    C("Guanine"),
    G("Cytosine"),
    T("Thymine"),
    U("Uracil") {
        /*yes! a CONSTANT-SPECIFIC CLASS BODY! An override for single nucleotide*/
        @Override
        public boolean isExclusiveRNA() {
            return true;
        }
    };;

    private static final Map<Nucleotide, Double> MOLECULAR_WEIGHTS =
            Map.of(A, 313.2, C, 304.2, G, 329.2, T, 304.2);
    private String name;

    Nucleotide(final String fullName) {
        this.name = fullName;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * returns the molecular weight of the nucleotide, in Daltons.
     * @return molecularWeight
     */
    public double getMolecularWeight() {
        return MOLECULAR_WEIGHTS.get(this);
    }

    /**
     * returns whether this nucleotide is only found in RNA.
     * @return isExclusiveRNA
     */
    public boolean isExclusiveRNA() {
        return false;
    }
}