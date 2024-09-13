package demos.advanced.refactoring.fastqc;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

public class FastQCbad {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("No file provided! \nUsage: java -jar fastqc.jar <fastq file>");
            return;
        }
        File fastqFile = Paths.get(args[0]).toFile();
        if(!fastqFile.exists() || !fastqFile.isFile() || !fastqFile.canRead()) {
            System.out.println("File " + fastqFile + " does not exist");
            return;
        }
        try(BufferedReader reader = Files.newBufferedReader(fastqFile.toPath())) {
            String line;
            String headerLine = "";
            long sequenceCount = 0;
            long failedSequenceCount = 0;
            boolean inQualityLine = false;
            while((line = reader.readLine()) != null) {
                // header lines start with @
                if (line.startsWith("@")) {
                    //System.out.println("Header line: " + line);
                    headerLine = line;
                    sequenceCount++;
                    continue;
                }
                // quality lines start with +
                if (line.startsWith("+")) {
                    //System.out.println("Next is quality line: " + line);
                    inQualityLine = true;
                    continue;
                }

                if (inQualityLine) {
                    //System.out.println("Quality line: " + line);

                    //read the quality line and determine the average quality score
                    //and number of low-quality bases
                    //if the average quality score is below 30, or the number of low-quality
                    //bases higher than 10, mark as failed
                    //score = ascii - 33
                    int lowCount = 0;
                    int summedScore = 0;
                    for (int i = 0; i < line.length(); i++) {
                        char qualityChar = line.charAt(i);
                        int qualityScore = qualityChar - 33;
                        summedScore += qualityScore;
                        if (qualityScore < 20) {
                            lowCount++;
                        }
                    }
                    double averageQuality = (double) summedScore / line.length();
                    //System.out.println("Average Quality: " + +averageQuality + ", low count: " + lowCount);
                    if (averageQuality <= 30 || lowCount >= 10) {
                        failedSequenceCount++;
                        //System.out.println("Warning: " + headerLine + " has low quality");
                    }
                    inQualityLine = false;
                }
            }
            //report results
            double fraction = (double) failedSequenceCount / sequenceCount * 100;
            System.out.println("Done reading file " + fastqFile);
            System.out.print("Number of failed sequences: " + failedSequenceCount
                    + " out of " + sequenceCount + " sequences ( " +
                    fraction + "%)");
        } catch (Exception e) {
            System.out.println("Error while reading file " + fastqFile);
            e.printStackTrace();
        }
    }
}
