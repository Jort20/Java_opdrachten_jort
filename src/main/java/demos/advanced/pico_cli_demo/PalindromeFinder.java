package demos.advanced.pico_cli_demo;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.Arrays;


@Command(name = "PalindromeFinder", version = "PalindromeFinder 0.0.1", mixinStandardHelpOptions = true)
public class PalindromeFinder implements Runnable {
    @Option(names = {"-m", "--min"},
            description = "Minimum length of palindrome",
            required = true)
    private int minimumLength;

    @Option(names = {"-i", "--ignore-case"},
            description = "Ignore case when checking for palindromes",
            defaultValue = "false")
    private boolean ignoreCase;

    @Option(names = {"-f", "--file"},
            description = "Input file with words")
    private String filename;

    @Parameters(arity = "0..*", paramLabel = "WORD", description = "Words to check for palindromicity")
    private String[] words;

    @Override
    public void run() {
        System.out.println("ignoring words below " + minimumLength + " characters");
        System.out.println("ignoreCase = " + ignoreCase);
        System.out.println("filename = " + filename);
        System.out.println("words = " + Arrays.toString(words));

        if (filename != null) {
            System.out.println("Reading words from file " + filename);
            //not implemented yet
        }
        if (words != null && words.length > 0) {
            System.out.println("Checking words from command-line " + Arrays.toString(words));
            reportPalindromes(words);
        } else {
            System.out.println("No words given from command line or file");
        }
    }

    private void reportPalindromes(String[] words) {
        for (String word : words) {
            if (word.length() < minimumLength) continue;
            if (isPalindrome(word)) System.out.println(word + " is a palindrome");
            else System.out.println(word + " is not a palindrome");
        }
    }

    private boolean isPalindrome(String word) {
        if (word.length() < minimumLength) {
            return false;
        }
        if (ignoreCase) {
            word = word.toLowerCase();
        }
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new PalindromeFinder()).execute(args);
        System.exit(exitCode);
    }
}
