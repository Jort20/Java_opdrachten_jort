package section5_adv_apis.part3_funct.lambdas_streams_exercise;

/**
 * Creation date: 7-2-2018
 *
 * @author Michiel Noback (&copy; 2018)
 * @version 0.01
 */
public class LambdasStreamExercise {
    public static final String DNA_ONE = "GTATTCATAC";
    public static final String DNA_TWO = "CATCATGAAATCGCTTGTCGCACTACTGCTGCTTTTAGTCGCTACTTCTGCCTTTGCTGACCAGTATGTAAATGGCTCTGGAGTCCTCTCCTTGCCAAA";
    public static final String DNA_THREE = "CATCATGAAATCGCTTGTCGCAYTACTGCTGCTTTTANTCGCTACTTCTGCCTTTGCTGACCKAGTATGTAAATGGCTCTGGAGTCCTCTCCTTGWCCAAA";



    public static String dnaToAbbreviatedNames(String DNA) {
        return DNA.chars()  // Convert the DNA string to an IntStream of character codes
                .mapToObj(c -> (char) c)  // Convert int codes to Character objects
                .map(Nucleotide::new)  // Convert characters to Nucleotide objects
                .map(n -> n.getName().substring(0, 3))  // Get the first 3 letters of each nucleotide's name
                .reduce((s1, s2) -> s1 + "." + s2)  // Concatenate with dots
                .orElse("");  // Return an empty string if DNA is empty
    }


    public static double dnaToWeight(String DNA) {
        long[] countInvalid = {0};  // Array to keep track of invalid nucleotides count

        double weight = DNA.chars()
                .mapToObj(c -> (char) c)
                .peek(c -> {
                    if (!Nucleotide.isLegalNucleotide(c)) {
                        countInvalid[0]++;
                    }
                })
                .filter(Nucleotide::isLegalNucleotide)
                .map(Nucleotide::new)
                .mapToDouble(Nucleotide::getWeight)
                .sum();

        System.out.println("Number of rejected nucleotides: " + countInvalid[0]);
        return weight;
    }


    public static int countNucleotide(String DNA, char nucleotide) {
        Nucleotide targetNucleotide = new Nucleotide(nucleotide);

        return (int) DNA.chars()
                .mapToObj(c -> (char) c)
                .map(Nucleotide::new)
                .filter(n -> n.getLetter() == targetNucleotide.getLetter())
                .count();
    }

}
