package section6_design.part0_refactoring;

public class ScoreCalculator {
    public double calculateScore(String firstLine, String secondLine) {
        if (firstLine.length() != secondLine.length()) {
            throw new IllegalArgumentException("Sequences are not of equal length.");
        }

        double score = 0;
        for (int i = 0; i < firstLine.length(); i++) {
            char t = firstLine.charAt(i);
            char b = secondLine.charAt(i);

            if (isWordCharacter(t) || isWordCharacter(b)) {
                throw new IllegalArgumentException("Illegal character at position " + i + ": " + t + "/" + b);
            }

            score += calculatePairScore(t, b);
        }
        return score;
    }

    private boolean isWordCharacter(char ch) {
        return !Character.isLetter(ch);
    }

    private double calculatePairScore(char t, char b) {
        if (Character.isUpperCase(t) && Character.isUpperCase(b)) {
            return t == b ? 1 : -1;
        } else {
            char tUp = Character.toUpperCase(t);
            char bUp = Character.toUpperCase(b);
            return tUp == bUp ? 0.5 : -0.5;
        }
    }
}
