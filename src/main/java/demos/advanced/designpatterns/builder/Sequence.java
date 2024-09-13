package demos.advanced.designpatterns.builder;

public class Sequence {
    private String sequence;
    private String accession;
    private String name;
    private SequenceType type;


    public static void main(String[] args) {
//        Sequence sequence = Sequence.builder("GAATTC")
//                .accession("GB|123456")
//                .name("RNA Polymerase III")
//                .type(SequenceType.DNA)
//                .build();
//        System.out.println(sequence);

        Sequence seq2 = Sequence.builder("FTRWSQA")
                .type(SequenceType.PROTEIN)
                .build();
        System.out.println("seq2 = " + seq2);
    }

    public static class Builder {
        //required parameter
        private final String sequence;
        //optional parameters
        private String name = "_ANONYMOUS_";
        private String accession = "_UNKNOWN_ACCNO_";
        private SequenceType type = SequenceType.UNKNOWN;

        private Builder(String sequence) {
            this.sequence = sequence;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder accession(String accession) {
            this.accession = accession;
            return this;
        }

        public Builder type(SequenceType type) {
            this.type = type;
            return this;
        }

        public Sequence build() {
            return new Sequence(this);
        }
    }

    public static Builder builder(String sequence) {
        return new Builder(sequence);
    }

    private Sequence(Builder builder) {
        this.sequence = builder.sequence;
        this.accession = builder.accession;
        this.name = builder.name;
        this.type = builder.type;
    }

    public String getSequence() {
        return sequence;
    }

    public String getName() {
        return name;
    }

    public SequenceType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "sequence='" + sequence + '\'' +
                ", accession='" + accession + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    enum SequenceType {
        DNA,
        RNA,
        PROTEIN,
        UNKNOWN;
    }


//    public Sequence(String sequence) {
//        this(sequence, "_UNKNOWN_ACCNO_");
//    }
//
//    public Sequence(String sequence, String accession) {
//        this(sequence, accession, "_ANONYMOUS_");
//    }
//
//    public Sequence(String sequence, String accession, String name) {
//        this(sequence, accession, name, SequenceType.UNKNOWN);
//    }
//
//    public Sequence(String sequence,
//                    String accession,
//                    String name,
//                    SequenceType type) {
//        this.sequence = sequence;
//        this.accession = accession;
//        this.name = name;
//        this.type = type;
//    }
}
