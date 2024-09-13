package demos.advanced.junit;

public class TextUtils {
    /**
     * This method searches for the longest word in
     * a given string.
     * It will split the String on all spaces and
     * removes all punctuation characters (matching
     * the pattern "[:;,.?!]"). If multiple words
     * have the same length, it will return the
     * first of these.
     *
     * @param text the text to analyze
     * @return the longest word
     * @throws IllegalArgumentException when
     *                                  a null value, an empty string or a single space is passed
     */
    public static String getLongestWord(String text) {
        if (isIllegalInput(text)) {
            throw new IllegalArgumentException("text cannot be null or empty");
        }

        text = stripNonWordCharacters(text);
        String[] words = text.split(" ");
        String longest = "";
        for (String word : words) {
            if (word.length() >= longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    private static boolean isIllegalInput(String text) {
        return null == text || text.isEmpty() || text.equals(" ");
    }

    public static String stripNonWordCharacters(String text) {
        return text.replaceAll("[?,.:;]", "");
    }
}