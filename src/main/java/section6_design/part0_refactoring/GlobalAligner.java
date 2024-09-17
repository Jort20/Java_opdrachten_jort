package section6_design.part0_refactoring;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class reads a global alignment (without gaps) from file and reports
 * the alignment score of it.
 * All word characters are acceptable: [a-zA-Z]
 * When one or two of the corresponding characters is in lower case, this position
 * is considered masked and that position will only add 50% of the maximum alignment
 * score for that position.
 */


public class GlobalAligner {
    private final String pathToDataFile;
    private double score;

    public GlobalAligner(String pathToDataFile) {
        this.pathToDataFile = pathToDataFile;
        validateFile();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Error, no data file provided!");
            System.exit(1);
        }

        GlobalAligner aligner = new GlobalAligner(args[0]);
        try {
            aligner.align();
            System.out.println("Alignment score = " + aligner.getScore());
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    public double getScore() {
        return score;
    }

    public void align() throws IOException {
        Path path = Paths.get(pathToDataFile);
        AlignmentFileReader fileReader = new AlignmentFileReader(path);
        String[] lines = fileReader.readAlignmentFile();
        String firstLine = lines[0];
        String secondLine = lines[1];
        System.out.println("TOP = " + firstLine);
        System.out.println("BTM = " + secondLine);

        ScoreCalculator calculator = new ScoreCalculator();
        this.score = calculator.calculateScore(firstLine, secondLine);
    }

    private void validateFile() {
        Path dataPath = Paths.get(pathToDataFile);
        if (!Files.exists(dataPath)) {
            throw new IllegalArgumentException("No such file: " + pathToDataFile);
        }
        if (!Files.isReadable(dataPath)) {
            throw new IllegalArgumentException("File is not readable: " + pathToDataFile);
        }
        if (!Files.isRegularFile(dataPath)) {
            throw new IllegalArgumentException("File is not a regular file: " + pathToDataFile);
        }
    }
}


