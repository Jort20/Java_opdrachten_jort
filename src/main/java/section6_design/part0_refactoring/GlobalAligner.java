package section6_design.part0_refactoring;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
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
    private String firstLine;
    private String secondLine;

    public static void main(String[] args) {
        //TODO remove hack of hardcoded variable
        //TODO assignment 2b removed hack
        //args = new String[]{"data/data.txt"};
        if (args.length != 1) {
            //TODO assignment 2b changed to err
            System.err.println("Error, no data file provided!");
            System.exit(0);
        }
        GlobalAligner dataProcessor = new GlobalAligner(args[0]);
        dataProcessor.align();
        System.out.println("Alignment score = " + dataProcessor.getScore());
    }

    double getScore() {
        return score;
    }

    public GlobalAligner(String pathToDataFile) {
        this.pathToDataFile = pathToDataFile;
        doFileCheck();
    }

    public void align() {
        Path path = Paths.get(pathToDataFile);
        readAlignmentFile(path);

        //Only regular alphabet characters are accepted here
        //Weight-masked (== lower-case) characters in any of the two sequences means the position should be weighted at 50%
        //ASCII codes uppercase letters: 65-90
        //ASCII codes lowercase letters: 97-122

        if (firstLine.length() != secondLine.length()) {
            System.out.println("Error: The two aligned sequences are not of equal length: \n\tTop=" + firstLine + "\n\tBtm=" + secondLine);
            System.exit(0);
        }
        char[] topArr = firstLine.toCharArray();
        char[] btmArr = secondLine.toCharArray();
        double localScore = 0;
        for (int i = 0; i < topArr.length; i++) {
            char t = topArr[i];
            char b = btmArr[i];

            if (! (isWordCharacter(t) && (isWordCharacter(b)))) {
                //illegal character
                throw new IllegalArgumentException("Illegal character at " + i + ": " + t + "/" + b);
//                System.err.println();
//                System.exit(0);
            }

            if (Character.isUpperCase(t) && Character.isUpperCase(b)) {//((t > 64 && t < 91) && (b > 64 && b < 91)) {
                //both are upper-case letters
                if (t == b) {
                    localScore += 1;
                } else {
                    localScore -= 1;
                }
            } else {
                //one of the two is a lower-case letter
                char tUp = Character.toUpperCase(t);
                char bUp = Character.toUpperCase(b);
                if (tUp == bUp) {
                    localScore += 0.5;
                } else {
                    localScore -= 0.5;
                }
            }
        }
        this.score = localScore;

    }

    private boolean isWordCharacter(char t) {
        return (t > 64 && t < 91) || (t > 96 && t < 123);
    }

    private void readAlignmentFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {
                if (firstLine == null) {
                    firstLine = currentLine;
                } else if (secondLine == null) {
                    secondLine = currentLine;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("TOP = " + firstLine);
        System.out.println("BTM = " + secondLine);
    }

    private void doFileCheck() {
        Path dataPath = Paths.get(pathToDataFile);
        if (!Files.exists(dataPath)) {
            System.err.println("Error: no such file: " + pathToDataFile);
            System.exit(0);
        }
        if (!Files.isReadable(dataPath)) {
            System.err.println("Error: file is not readable: " + pathToDataFile);
            System.exit(0);
        }
        if (!Files.isRegularFile(dataPath)) {
            System.err.println("Error: file is not a regular file: " + pathToDataFile);
            System.exit(0);
        }
    }
}

