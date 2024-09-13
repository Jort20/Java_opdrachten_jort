package section5_adv_apis.part3_funct.lambdas_streams_exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Nucleotide {
    private static final Map<Character, String> NAMES = new HashMap<>();
    private static final Map<Character, Double> WEIGHTS = new HashMap<>();
    private static final Map<Character, Character> COMPLEMENTS = new HashMap<>();
    private static final Map<Character, Integer> COUNTS = new HashMap<>();
    private static final Set<Character> LEGAL_CHARACTERS = new HashSet<>();
    private char letter;

    static {
        NAMES.put('A', "Adenine");
        NAMES.put('C', "Cytosine");
        NAMES.put('G', "Guanine");
        NAMES.put('T', "Thymine");

        WEIGHTS.put('A', 313.2);
        WEIGHTS.put('C', 289.2);
        WEIGHTS.put('G', 329.2);
        WEIGHTS.put('T', 304.2);

        COMPLEMENTS.put('A', 'T');
        COMPLEMENTS.put('C', 'G');
        COMPLEMENTS.put('G', 'C');
        COMPLEMENTS.put('T', 'A');

        LEGAL_CHARACTERS.add('A');
        LEGAL_CHARACTERS.add('C');
        LEGAL_CHARACTERS.add('G');
        LEGAL_CHARACTERS.add('T');
    }

    public Nucleotide(char letter) {
        if (! LEGAL_CHARACTERS.contains(letter)) {
            throw new IllegalArgumentException(letter + " is not a legal DNA character");
        }
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public String getName() {
        return NAMES.get(this.letter);
    }

    public static boolean isLegalNucleotide(char candidateNucleotide) {
        return LEGAL_CHARACTERS.contains(candidateNucleotide);
    }

    public double getWeight() {
        return WEIGHTS.get(this.letter);
    }

    @Override
    public String toString() {
        return "Nucleotide{" +
                "letter=" + letter +
                "; name=" + getName() +
                '}';
    }
}
