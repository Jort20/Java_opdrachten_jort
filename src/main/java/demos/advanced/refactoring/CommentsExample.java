package demos.advanced.refactoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommentsExample {
    public final static int MINIMUM_COMPLETE_PENSION_WORK_PERIOD = 40;

    /**
     * The employee that is being dealt with
     */
    private Employee employee;

    void demo() {
        if (employee.getWorkingYears() >= MINIMUM_COMPLETE_PENSION_WORK_PERIOD
                && employee.getFteSize() >= 0.95) {

        }

        if (employee.isEligibleForFullPension()) {

        }

    }

    private static final class Employee {

        private int workingYears;
        private double fteSize;
        private boolean eligibleForFullPension;

        public int getWorkingYears() {
            return workingYears;
        }

        public double getFteSize() {
            return fteSize;
        }

        /**
         * This method returns whether the employee is eligible for full pension.
         *
         * @return eligible
         */
        public boolean isEligibleForFullPension() {
            return eligibleForFullPension;
        }
    }


    public static void wordCount() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int lineCount = 0;
        int charCount = 0;
        int wordCount = 0;
        try {
            while ((line = in.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String words[] = line.split(" \\W");
                wordCount += words.length;
            } //while
        } //try
        catch (IOException ex) {
            System.err.println("Error : " + ex.getMessage());
        } //catch
        System.out.println("wordCount = " + wordCount);
        System.out.println("lineCount = " + lineCount);
        System.out.println("charCount = " + charCount);
    } //wordCount


}
