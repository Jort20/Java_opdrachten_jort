/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package section4_oop.part3_consensus_creator;

import java.util.*;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class ConsensusSequenceCreator {
    private String[] sequences;
    private boolean iupac;
    private String[] ambiguities;
    private String consensus = "";

    public static void main(String[] args) {
        String[] sequences = new String[4];
        sequences[0] = "GAAT";
        sequences[1] = "GAAA";
        sequences[2] = "GATT";
        sequences[3] = "GAAC";

        ConsensusSequenceCreator csc = new ConsensusSequenceCreator();
        String consensus;
        consensus = csc.createConsensus(sequences, true);
        System.out.println("consensus = " + consensus); // Should print "GAWH"
        consensus = csc.createConsensus(sequences, false);
        System.out.println("consensus = " + consensus); // Should print "GA[A/T][A/C/T]"
    }

    public String createConsensus(String[] sequences, boolean iupac) {
        this.sequences = sequences;
        this.iupac = iupac;
        this.ambiguities = new String[sequences[0].length()];
        buildAmbiguities();
        buildConsensus();
        return this.consensus;
    }

    private void buildAmbiguities() {
        int length = sequences[0].length();
        for (int i = 0; i < length; i++) {
            Set<Character> uniqueNucleotides = new HashSet<>();
            for (String seq : sequences) {
                uniqueNucleotides.add(seq.charAt(i));
            }
            List<Character> sortedNucleotides = new ArrayList<>(uniqueNucleotides);
            Collections.sort(sortedNucleotides);
            StringBuilder sb = new StringBuilder();
            for (char nucleotide : sortedNucleotides) {
                sb.append(nucleotide);
            }
            ambiguities[i] = sb.toString();
        }
    }

    private void buildConsensus() {
        StringBuilder sb = new StringBuilder();
        for (String ambiguity : ambiguities) {
            if (ambiguity.length() == 1) {
                sb.append(ambiguity);
            } else {
                if (iupac) {
                    sb.append(getIUPACCode(ambiguity));
                } else {
                    String sortedNucleotides = sortNucleotides(ambiguity);
                    sb.append('[').append(String.join("/", sortedNucleotides.split(""))).append(']');
                }
            }
        }
        this.consensus = sb.toString();
    }
    private String sortNucleotides(String nucleotides) {
        char[] chars = nucleotides.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    private String getIUPACCode(String nucleotides) {
        switch (nucleotides) {
            case "AC":
                return "M";
            case "AG":
                return "R";
            case "AT":
                return "W";
            case "CG":
                return "S";
            case "CT":
                return "Y";
            case "GT":
                return "K";
            case "ACG":
                return "V";
            case "ACT":
                return "H";
            case "AGT":
                return "D";
            case "CGT":
                return "B";
            case "ACGT":
                return "N";
            default:
                return nucleotides;
        }
    }
}
