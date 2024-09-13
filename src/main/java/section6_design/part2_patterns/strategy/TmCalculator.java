package section6_design.part2_patterns.strategy;

import section5_adv_apis.part1_junit.Primer;

public interface TmCalculator {

    /**
     * The single method of this interface. Takes a primer sequence and returns its meling temperature assuming
     * standard salt concentrations.
     * @param primer
     * @return melting temperature
     * @throws IllegalArgumentException ex when the primer contains any characters other than G, A, T or C
     */
    double calculateTm(Primer primer);
}
