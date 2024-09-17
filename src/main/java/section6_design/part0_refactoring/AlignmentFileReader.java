package section6_design.part0_refactoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class AlignmentFileReader {
    private final Path path;

    public AlignmentFileReader(Path path) {
        this.path = path;
    }

    public String[] readAlignmentFile() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String[] lines = new String[2];
            int index = 0;
            String line;
            while ((line = reader.readLine()) != null && index < 2) {
                lines[index++] = line;
            }
            return lines;
        }
    }
}
