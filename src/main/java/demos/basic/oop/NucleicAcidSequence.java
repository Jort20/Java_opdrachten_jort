package demos.basic.oop;

abstract class NucleicAcidSequence {
    protected String sequence;
    protected String name;

    public NucleicAcidSequence(String sequence, String name) {
        this.sequence = sequence;
        this.name = name;
    }

    public abstract char getComplementCharacter(char c);

    public DNASequence complement() {
        StringBuilder newSequence = new StringBuilder();
        for (int i = 0; i < sequence.length(); i++) {
            newSequence.append(getComplementCharacter(sequence.charAt(i)));
        }
        return new DNASequence(newSequence.toString(), name);
    }

    /*
     * Note this is not general-purpose; you will need introspection
     * for a more sophisticated solution.
     */
    public NucleicAcidSequence reverse() {
        String newSeq = new StringBuilder(sequence).reverse().toString();
        if (this instanceof DNASequence)
            return new DNASequence(newSeq, name);
        else if (this instanceof RNASequence)
            return new RNASequence(newSeq, name);
        else
            throw new IllegalArgumentException("Unknown sequence type");
    }

    public NucleicAcidSequence reverseComplement() {
        return complement().reverse();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (" + name + "): " + sequence;
    }
}
