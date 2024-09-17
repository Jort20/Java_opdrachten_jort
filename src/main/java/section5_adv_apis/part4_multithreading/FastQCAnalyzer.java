package section5_adv_apis.part4_multithreading;

import java.util.List;

public class FastQCAnalyzer {
    private List<String[]> sequences;

    public FastQCAnalyzer(List<String[]> sequences) {
        this.sequences = sequences;
    }

    public void analyze() {
        if (sequences.isEmpty()) {
            System.out.println("No sequences found.");
            return;
        }

        int numSequences = sequences.size();
        int totalLength = 0;
        int totalQualitySum = 0;
        int numBases = 0;
        int sequenceLength = sequences.get(0)[0].length(); // Assuming all sequences are the same length
        int[] qualitySums = new int[sequenceLength];

        // Process each sequence
        for (String[] seq : sequences) {
            String sequence = seq[0];
            String quality = seq[1];
            totalLength += sequence.length();

            for (int i = 0; i < sequence.length(); i++) {
                int qualityScore = quality.charAt(i) - 33; // Convert ASCII to Phred quality score
                totalQualitySum += qualityScore;
                qualitySums[i] += qualityScore;
                numBases++;
            }
        }

        System.out.println("Number of sequences: " + numSequences);
        System.out.println("Average sequence length: " + (double) totalLength / numSequences);
        System.out.println("Average quality score: " + (double) totalQualitySum / numBases);

        System.out.print("Average quality score per base: ");
        for (int i = 0; i < qualitySums.length; i++) {
            System.out.print((double) qualitySums[i] / numSequences + " ");
        }
        System.out.println();
    }
}

