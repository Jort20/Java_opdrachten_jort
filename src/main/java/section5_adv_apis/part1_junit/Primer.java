/*
 * Copyright (c) 2015 Michiel Noback
 * All rights reserved
 * www.bioinf.nl, www.cellingo.net
 */
package section5_adv_apis.part1_junit;

/**
 * @author michiel
 */
public class Primer {

    private String sequence;

    public Primer(String sequence) {
//        this.sequence = sequence.toUpperCase();
        this.setSequence(sequence);
    }

    public Primer() {
    }

    /**
     * N?
     * @return
     */

    public double getGcPercentage() {
        if (sequence == null || sequence.isEmpty()) {
            throw new IllegalArgumentException("Sequence is null or empty");
        }
//      solve this the Java 8 way
        return (double) getGCcount() / this.sequence.length();
    }
    /**
     * This very simple method assigns 2°C to each A-T pair and 4°C to each G-C pair. The Tm then is the sum of these
     * values for all individual pairs in a DNA double strand. This takes into account that the G-C bond is stronger
     * than the A-T bond. Note that the 2+4 rule is valid for a small length range only, about 20-40 nt.
     *
     * @return meltTemp the melting temperature
     */
    public double getMeltingTemperature() {
        if (sequence == null || sequence.isEmpty()) {
            throw new IllegalArgumentException("Sequence is null or empty");
        }
        //solve this the Java 8 way
        final int gcCount = getGCcount();
        return (gcCount * 4) + ((this.sequence.length() - gcCount) * 2);
    }

    private int getGCcount() {
        final int[] gcCount = new int[]{0};
        this.sequence.chars().forEach(
                (n) -> {
                    if (n == 'C' || n == 'G') {
                        gcCount[0]++;
                    } else if (n != 'A' && n != 'T') {
                        throw new IllegalArgumentException("Invalid character in sequence: " + (char) n);
                    }
                }
        );
        return gcCount[0];
    }

    public int getLength() {
        if (sequence == null) {
            return 0;
        }
        return sequence.length();
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        if (sequence == null) {
            throw new IllegalArgumentException("Sequence cannot be null");
        }
        sequence = sequence.toUpperCase();
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "Primer{GC%=" + getGcPercentage()
                + ", Tm=" + getMeltingTemperature()
                + ", length=" + sequence.length() + '}';
    }
}
