package section5_adv_apis.part4_multithreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FastQReader {
    private BufferedReader reader;

    public FastQReader(String filePath) throws IOException {
        reader = new BufferedReader(new FileReader(filePath));
    }

    // Reads sequences from the FastQ file and returns them as a list of String arrays
    public List<String[]> readSequences() throws IOException {
        List<String[]> sequences = new ArrayList<>();
        String line;

        // Read each block of four lines
        while ((line = reader.readLine()) != null) {
            String sequence = reader.readLine(); // Sequence line
            reader.readLine(); // Optional line (skipped)
            String quality = reader.readLine(); // Quality score line
            sequences.add(new String[]{sequence, quality});
        }
        reader.close();
        return sequences;
    }
}

