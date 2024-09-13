package section5_adv_apis.part1_junit;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Protein {
    private static Set<Character> legalCharacters = new HashSet<>();
    private String sequence;

    static {
        legalCharacters.add('A');
        legalCharacters.add('C');
        legalCharacters.add('D');
        legalCharacters.add('E');
        legalCharacters.add('F');
        legalCharacters.add('G');
        legalCharacters.add('H');
        legalCharacters.add('I');
        legalCharacters.add('K');
        legalCharacters.add('L');
        legalCharacters.add('M');
        legalCharacters.add('N');
        legalCharacters.add('P');
        legalCharacters.add('Q');
        legalCharacters.add('R');
        legalCharacters.add('S');
        legalCharacters.add('T');
        legalCharacters.add('V');
        legalCharacters.add('W');
        legalCharacters.add('Y');
    }

    /**
     * Sets the amino acid sequence of this object.
     *
     * @param sequence
     */
    public void setSequence(String sequence) {
        /*
        TODO Assignment 1 added Objects.requireNonNull and changed to uppercase
         */
        Objects.requireNonNull(sequence);

        sequence = sequence.toUpperCase();
        if (!isLegalProteinSequence(sequence)) {
            throw new IllegalArgumentException("bla");
        }
        this.sequence = sequence;
    }

    public String getSequence() {
        return sequence;
    }

    /**
     * Returns the fraction of the given amino acid in the protein sequence
     *
     * @param aminoAcid
     * @return fraction the fraction
     */
    public double getAminoAcidFraction(char aminoAcid) {
        Pattern p = Pattern.compile(Character.toString(aminoAcid));
        Matcher m = p.matcher(this.sequence);
        double count = 0;
        while (m.find()) {
            count += 1;
        }
        return count / this.sequence.length();
    }

    /**
     * Checks whether the given sequence consists of only legal amino acid characters.
     *
     * @param proteinCandidate
     * @return
     */
    protected static boolean isLegalProteinSequence(String proteinCandidate) {
        List<Character> charList = proteinCandidate
                .chars()
                .mapToObj((i) -> Character.valueOf((char) i))
                .collect(Collectors.toList());
        return Protein.legalCharacters.containsAll(charList);
    }
}