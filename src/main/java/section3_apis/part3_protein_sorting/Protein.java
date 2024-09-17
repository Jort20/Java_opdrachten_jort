/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package section3_apis.part3_protein_sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class Protein implements Comparable<Protein> {
    private final String name;
    private final String accession;
    private final String aminoAcidSequence;
    private GOannotation goAnnotation;

    // Gewicht van aminozuren gebaseerd op WebQC
    private static final Map<Character, Double> AMINO_ACID_WEIGHTS = new HashMap<>();

    static {
        // Initialiseren van aminozuurgewichten
        AMINO_ACID_WEIGHTS.put('A', 71.08);
        AMINO_ACID_WEIGHTS.put('C', 103.15);
        AMINO_ACID_WEIGHTS.put('D', 115.09);
        AMINO_ACID_WEIGHTS.put('E', 129.12);
        AMINO_ACID_WEIGHTS.put('F', 147.18);
        AMINO_ACID_WEIGHTS.put('G', 57.05);
        AMINO_ACID_WEIGHTS.put('H', 137.14);
        AMINO_ACID_WEIGHTS.put('I', 113.16);
        AMINO_ACID_WEIGHTS.put('K', 128.17);
        AMINO_ACID_WEIGHTS.put('L', 113.16);
        AMINO_ACID_WEIGHTS.put('M', 131.19);
        AMINO_ACID_WEIGHTS.put('N', 114.11);
        AMINO_ACID_WEIGHTS.put('P', 97.12);
        AMINO_ACID_WEIGHTS.put('Q', 128.13);
        AMINO_ACID_WEIGHTS.put('R', 156.19);
        AMINO_ACID_WEIGHTS.put('S', 87.08);
        AMINO_ACID_WEIGHTS.put('T', 101.11);
        AMINO_ACID_WEIGHTS.put('V', 99.14);
        AMINO_ACID_WEIGHTS.put('W', 186.21);
        AMINO_ACID_WEIGHTS.put('Y', 163.18);
    }

    /**
     * Constructs without GO annotation.
     * @param name the protein name
     * @param accession the accession number
     * @param aminoAcidSequence the proteins amino acid sequence
     */
    public Protein(String name, String accession, String aminoAcidSequence) {
        this(name, accession, aminoAcidSequence, null);
    }

    /**
     * Constructs with main properties.
     * @param name the protein name
     * @param accession the accession number
     * @param aminoAcidSequence the proteins amino acid sequence
     * @param goAnnotation the GO annotation
     */
    public Protein(String name, String accession, String aminoAcidSequence, GOannotation goAnnotation) {
        this.name = name;
        this.accession = accession;
        this.aminoAcidSequence = aminoAcidSequence;
        this.goAnnotation = goAnnotation;
    }

    @Override
    public int compareTo(Protein other) {
        return this.name.compareTo(other.name);
    }

    /**
     * Provides a range of possible sorters, based on the type that is requested.
     * @param type the sorting type that is required
     * @return proteinSorter
     */
    public static Comparator<Protein> getSorter(SortingType type) {
        if (type == null) {
            throw new IllegalArgumentException("SortingType cannot be null");
        }

        switch (type) {
            case PROTEIN_NAME:
                return Comparator.naturalOrder();

            case ACCESSION_NUMBER:
                return Comparator.comparing(
                        Protein::getAccession,
                        String.CASE_INSENSITIVE_ORDER
                );

            case GO_ANNOTATION:
                return Comparator.comparing((Protein p) -> p.getGoAnnotation().getBiologicalProcess())
                        .thenComparing(p -> p.getGoAnnotation().getCellularComponent())
                        .thenComparing(p -> p.getGoAnnotation().getMolecularFunction());

            case PROTEIN_WEIGHT:
                // Sorting by molecular weight in ascending order
                return Comparator.comparingDouble(Protein::getMolecularWeight);

            default:
                throw new IllegalArgumentException("Unknown SortingType: " + type);
        }
    }


    /**
     * Calculates the molecular weight of the amino acid sequence.
     * @return the molecular weight
     */
    private double getMolecularWeight() {
        double weight = 0.0;
        for (char aminoAcid : aminoAcidSequence.toCharArray()) {
            double aminoAcidWeight = AMINO_ACID_WEIGHTS.getOrDefault(Character.toUpperCase(aminoAcid), 0.0);
            weight += aminoAcidWeight;
            if (aminoAcidWeight == 0.0) {
                throw new IllegalArgumentException("Invalid amino acid: " + aminoAcid);
            }
        }
        return weight;
    }

    public String getName() {
        return name;
    }

    public String getAccession() {
        return accession;
    }

    public String getAminoAcidSequence() {
        return aminoAcidSequence;
    }

    public GOannotation getGoAnnotation() {
        return goAnnotation;
    }

    @Override
    public String toString() {
        return "Protein{" + "name=" + name + ", accession=" + accession + ", aminoAcidSequence=" + aminoAcidSequence + '}';
    }
}
