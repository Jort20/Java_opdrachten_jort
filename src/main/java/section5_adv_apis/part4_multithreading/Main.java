package section5_adv_apis.part4_multithreading;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "data/seq_test.fq";

        try {
            // Create a FastQReader to read the FastQ file
            FastQReader reader = new FastQReader(filePath);
            List<String[]> sequences = reader.readSequences();

            // Create a FastQCAnalyzer to analyze the sequences
            FastQCAnalyzer analyzer = new FastQCAnalyzer(sequences);
            analyzer.analyze();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
