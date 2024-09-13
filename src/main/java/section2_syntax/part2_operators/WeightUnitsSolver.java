/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package section2_syntax.part2_operators;

public class WeightUnitsSolver {

    /**
     * Returns the number of Pounds, Ounces and Grams represented by this quantity of grams,
     * encapsulated in a BritishWeightUnits object.
     * @param grams the grams quantity
     * @return a BritishWeightUnits instance
     * @throws IllegalArgumentException when the Grams quantity is less than or equal to 0
     */
    public BritishWeightUnits convertFromGrams(int grams) {
        final int gramsInPound = 454;
        final int gramsInOunce = 28;

        if (grams <= 0) {
            throw new IllegalArgumentException("Error: grams should be above 0. Given: grams=" + grams);
        }

        int pounds = grams / gramsInPound;
        int remainingGrams = grams % gramsInPound;

        int ounces = remainingGrams / gramsInOunce;
        remainingGrams = remainingGrams % gramsInOunce;

        return new BritishWeightUnits(pounds, ounces, remainingGrams);
    }
}

