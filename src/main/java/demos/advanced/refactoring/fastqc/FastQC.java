package demos.advanced.refactoring.fastqc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

public class FastQC {
    //static class variables
    private static final int AVERAGE_QUALITY_CUTOFF = 30;
    private static final int LOW_QUALITY_BASES_CUTOFF = 10;
    private static final int ILLUMINA_ENCODING = 33;
    private static final int LOW_QUALITY_SCORE = 20;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("No file provided! \nUsage: java -jar fastqc.jar <fastq file>");
            return;
        }
        File fastqFile = Paths.get(args[0]).toFile();
        if (! fileIsOk(fastqFile)) {
            System.out.println("File " + fastqFile + " does not exis or is not readable");
            return;
        }

        FastQC fastQC = new FastQC();
        FastQfileQuality qualityReport = fastQC.readFile(fastqFile);
        System.out.println("Done reading file " + fastqFile);
        System.out.print("Number of failed sequences: " + qualityReport.failedSequenceCount()
                + " out of " + qualityReport.sequenceCount + " sequences (" +
                (qualityReport.fractionFailed()*100) + "%)");
    }

    private record SequenceQuality(int lowCount, int summedScore) { }
    public record FastQfileQuality(long sequenceCount, long failedSequenceCount) {
        public double fractionFailed() {
            return (double) failedSequenceCount / sequenceCount * 100;
        }
    }

    private static boolean fileIsOk(File fastqFile) {
        if(!fastqFile.exists() || !fastqFile.isFile() || !fastqFile.canRead()) {
            System.out.println("File " + fastqFile + " does not exist");
            return false;
        }
        return true;
    }

    private FastQfileQuality readFile(File fastqFile) {
        try(BufferedReader reader = Files.newBufferedReader(fastqFile.toPath())) {
            String line;
            long sequenceCount = 0;
            long failedSequenceCount = 0;
            boolean inQualityLine = false;
            while((line = reader.readLine()) != null) {
                if (isHeaderLine(line)) {
                    sequenceCount++;
                    continue;
                }
                if (isQualityLine(line)) {
                    inQualityLine = true;
                    continue;
                }

                if (inQualityLine) {
                    SequenceQuality sq = getSequenceQuality(line);
                    double averageQuality = (double) sq.summedScore() / line.length();
                    if (isFailedSequence(averageQuality, sq.lowCount())) {
                        failedSequenceCount++;
                    }
                    inQualityLine = false;
                }
            }
            return new FastQfileQuality(sequenceCount, failedSequenceCount);

        } catch (IOException e) {
            throw new RuntimeException("Error while reading file " + fastqFile, e);
        }
    }


    public SequenceQuality getSequenceQuality(String line) {
        int lowCount = 0;
        int summedScore = 0;
        for (int i = 0; i < line.length(); i++) {
            char qualityChar = line.charAt(i);
            int qualityScore = getQualityScore(qualityChar);
            summedScore += qualityScore;
            if (isLowQualityBase(qualityChar)) {
                lowCount++;
            }
        }
        return new SequenceQuality(lowCount, summedScore);
    }

    boolean isQualityLine(String line) {
        return line.startsWith("+");
    }

    boolean isHeaderLine(String line) {
        return line.startsWith("@");
    }

    boolean isLowQualityBase(char qualityChar) {
        return qualityChar < LOW_QUALITY_SCORE;
    }

    int getQualityScore(char qualityChar) {
        return qualityChar - ILLUMINA_ENCODING;
    }

    static boolean isFailedSequence(double averageQuality, int lowCount) {
        return averageQuality <= AVERAGE_QUALITY_CUTOFF || lowCount >= LOW_QUALITY_BASES_CUTOFF;
    }
}
