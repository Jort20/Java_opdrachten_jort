package section6_design.part2_patterns.strategy;

public class Primer {
    private String sequence;
    private String id = "ANONYMOUS PRIMER";

    public Primer(String sequence) {
        this.sequence = sequence;
    }

    public Primer(String sequence, String id) {
        this.sequence = sequence;
        this.id = id;
    }

    //DO YOU MAGIC HERE
    public double getMeltingTemperature() {
        throw new UnsupportedOperationException("not implemented yet");
    }


    public String getSequence() {
        return sequence;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Primer{" +
                "sequence='" + sequence + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Primer primer = (Primer) o;

        if (getSequence() != null ? !getSequence().equals(primer.getSequence()) : primer.getSequence() != null)
            return false;
        return getId() != null ? getId().equals(primer.getId()) : primer.getId() == null;
    }

    @Override
    public int hashCode() {
        int result = getSequence() != null ? getSequence().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        return result;
    }
}
