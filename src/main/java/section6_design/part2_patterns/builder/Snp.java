package section6_design.part2_patterns.builder;

import java.util.List;

public class Snp {
    //REQUIRED
    Coordinate coordinate;
    //REQUIRED
    char reference;
    //OPTIONAL
    List<Character> alternatives;
    //OPTIONAL
    List<Integer> counts;
    //OPTIONAL; defaults to HARMLESS
    Pathogenicity pathogenicity;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public char getReference() {
        return reference;
    }

    public void setReference(char reference) {
        this.reference = reference;
    }

    public List<Character> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<Character> alternatives) {
        this.alternatives = alternatives;
    }

    public List<Integer> getCounts() {
        return counts;
    }

    public void setCounts(List<Integer> counts) {
        this.counts = counts;
    }

    public Pathogenicity getPathogenicity() {
        return pathogenicity;
    }

    public void setPathogenicity(Pathogenicity pathogenicity) {
        this.pathogenicity = pathogenicity;
    }
}

