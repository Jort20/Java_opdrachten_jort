package demos.advanced.designpatterns.commandpattern;

/**
 * Creation date: Jul 07, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class NucleotideSequenceReceiver {
    private static final NucleotideSequenceReceiver instance = new NucleotideSequenceReceiver();
    private StringBuilder sequence = new StringBuilder();
    private boolean isUpperCase = true;

    public static NucleotideSequenceReceiver getInstance() {
        return instance;
    }

    public void append(char c) {
        if (sequence.isEmpty()) {
            this.isUpperCase = Character.isUpperCase(c);
            this.sequence.append(c);
        }
        else {
            if (this.isUpperCase) {
                this.sequence.append(Character.toUpperCase(c));
            } else {
                this.sequence.append(Character.toLowerCase(c));
            }
        }
    }

    public int length() {
        return this.sequence.length();
    }

    public boolean isUpperCase() {
        return isUpperCase;
    }

    public void clearAll() {
        this.sequence = new StringBuilder();
    }

    public char deleteLast() {
        char last = this.sequence.charAt(this.sequence.length() - 1);
        this.sequence.deleteCharAt(this.sequence.length() - 1);
        return last;
    }

    public void toggleCase() {
        if (this.sequence.length() > 0) {
            String temp = this.sequence.toString();
            if (this.isUpperCase) {
                temp = temp.toLowerCase();
                this.isUpperCase = false;
            } else {
                temp = temp.toUpperCase();
                this.isUpperCase = true;
            }
            this.sequence = new StringBuilder(temp);
        }
        //have call on empty sequence pass silently
    }


    @Override
    public String toString() {
        return "sequence=" + sequence;
    }


    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("ABCDE");
        stringBuilder.append("F");
        System.out.println("stringBuilder = " + stringBuilder);
        StringBuilder sb2 = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println("stringBuilder = " + stringBuilder);
        System.out.println("sb2 = " + sb2);
    }
}
