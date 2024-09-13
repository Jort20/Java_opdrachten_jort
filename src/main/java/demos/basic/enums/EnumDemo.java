package demos.basic.enums;

import java.util.Arrays;

public final class EnumDemo {
    public static void main(final String[] args) {
        EnumDemo enumDemo = new EnumDemo();
        enumDemo.start();
    }

    private void start() {
        // declare a specific instance of the type
        Nucleotide nucA = Nucleotide.A;

        Nucleotide otherNucA = Nucleotide.A;

        // both variables point to the same object!
        System.out.println("nucA and otherNucA are the same: " + (nucA == otherNucA));

        // print it to show the constant value (this can be overridden -- see below)
        System.out.println("nucA = " + nucA);

        // get its ordinal (the rank in the declaration list)
        System.out.println("nucA.ordinal() = " + nucA.ordinal());
        System.out.println("Nucleotide.G.ordinal() = " + Nucleotide.G.ordinal());

        // get all possible values
        System.out.println("Nucleotide.values() = " + Arrays.toString(Nucleotide.values()));

        // convert from string
        Nucleotide nuc = Nucleotide.valueOf("C");
        System.out.println("created from String with valueOf() = " + nuc);

        // switch on it
        switchOnNucleotide(nuc);
    }

    private void switchOnNucleotide(final Nucleotide nuc) {
        switch (nuc) {
            case A:
                System.out.println("It is an A");
                break;
            case C:
                System.out.println("It is a C");
                break;
            case G:
                System.out.println("It is a G");
                break;
            case T:
                System.out.println("It is a T");
                break;
        }
    }
}