package section4_oop.part2_palindrome_finder;

public class KPalindromeFinder {
    private String originalString;
    private int k;

    // Constructor om de originele string en K-waarde te initialiseren
    public KPalindromeFinder(String originalString, int k) {
        this.originalString = originalString;
        this.k = k;
    }

    // Methode om te controleren of de string een K-palindrome is
    public boolean isKPalindrome() {
        int mismatches = countMismatches();
        return mismatches <= k;
    }

    // Hulp-methode om het aantal mismatches te tellen
    private int countMismatches() {
        int left = 0;
        int right = originalString.length() - 1;
        int mismatches = 0;

        while (left < right) {
            if (originalString.charAt(left) != originalString.charAt(right)) {
                mismatches++;
            }
            left++;
            right--;
        }

        return mismatches;
    }

    // Methode om de uitvoer te genereren
    public String generateOutput() {
        StringBuilder output = new StringBuilder();
        StringBuilder mismatchLine = new StringBuilder();
        int n = originalString.length();

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            if (originalString.charAt(left) == originalString.charAt(right)) {
                output.append(Character.toUpperCase(originalString.charAt(left)));
                mismatchLine.append(left < right ? '>' : ' ');
            } else {
                output.append(Character.toLowerCase(originalString.charAt(left)));
                mismatchLine.append('*');
            }
            left++;
            right--;
        }

        return output.toString() + "\n" + mismatchLine.toString();
    }

    // Hoofdmethode om de functionaliteit te testen
    public static void main(String[] args) {
        String originalString = "GGATAGCCGG";
        int k = 2;
        KPalindromeFinder finder = new KPalindromeFinder(originalString, k);

        if (finder.isKPalindrome()) {
            System.out.println("De string is een K-Palindrome.");
            System.out.println(finder.generateOutput());
        } else {
            System.out.println("De string is geen K-Palindrome.");
        }
    }
}
