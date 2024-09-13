package demos.advanced.designpatterns.template_method;

abstract class NucleicAcidSequence{
    protected String sequence;
    protected String name;

    public NucleicAcidSequence(String sequence, String name) {
        this.sequence = sequence;
        this.name = name;
    }

//    public String getSequence() {
//        return sequence;
//    }
//
//    public String getName() {
//        return name;
//    }

    //ABSTRACT METHOD!
    public abstract char getComplementCharacter(char c);

    public NucleicAcidSequence complement() {
        StringBuilder newSequence = new StringBuilder();
        for (int i = 0; i < sequence.length(); i++) {
            //CALL ABSTRACT METHOD THAT DOES NOT EXIST YET!
            newSequence.append(getComplementCharacter(sequence.charAt(i)));
        }
        return new DNASequence(newSequence.toString(), name);
    }

    public NucleicAcidSequence reverse() {
        String newSeq = new StringBuilder(sequence).reverse().toString();
        if (this instanceof DNASequence)
            return new DNASequence(newSeq, name);
        else if (this instanceof RNASequence)
            return new RNASequence(newSeq, name);
        else
            throw new IllegalArgumentException("Unknown sequence type");
    }

    public NucleicAcidSequence reverseComplement(){
        return complement().reverse();
    }

//    @Override
//    public String toString() {
//        return getClass().getSimpleName() + " (" + name + "): " + sequence;
//    }
}