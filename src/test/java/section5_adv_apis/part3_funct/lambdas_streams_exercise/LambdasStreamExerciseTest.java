package section5_adv_apis.part3_funct.lambdas_streams_exercise;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Creation date: 7-2-2018
 *
 * @author Michiel Noback (&copy; 2018)
 * @version 0.01
 */
public class LambdasStreamExerciseTest {
    private static final double DELTA = 1E-4;
    @Test
    public void dnaToAbbreviatedNames() throws Exception {
        String input = "ACGT";
        String expected = "Ade.Cyt.Gua.Thy";
        String observed = LambdasStreamExercise.dnaToAbbreviatedNames(input);
        assertEquals(expected, observed);

        input = "GAAAAAT";
        expected = "Gua.Ade.Ade.Ade.Ade.Ade.Thy";
        observed = LambdasStreamExercise.dnaToAbbreviatedNames(input);
        assertEquals(expected, observed);
    }

    @Test//(expected = IllegalArgumentException.class)
    public void dnaToAbbreviatedNamesIllegalDna() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> LambdasStreamExercise.dnaToAbbreviatedNames("ABGT"));
//        String input = "ABGT";
//        String observed = LambdasStreamExercise.dnaToAbbreviatedNames(input);
    }

    @Test
    public void dnaToWeight() throws Exception {
        String input = "ACGTU";
        double expected = 1235.8;
        double observed = LambdasStreamExercise.dnaToWeight(input);
        assertEquals(expected, observed, DELTA);

        expected = 29723.39999;
        observed = LambdasStreamExercise.dnaToWeight(LambdasStreamExercise.DNA_THREE);
        assertEquals(expected, observed, DELTA);
    }

    @Test
    public void countNucleotide() throws Exception {
        String input = "GGAATCGGTAACGT";
        int expected = 4;
        int observed = LambdasStreamExercise.countNucleotide(input, 'A');
        assertEquals(expected, observed);

        expected = 19;
        observed = LambdasStreamExercise.countNucleotide(LambdasStreamExercise.DNA_TWO, 'A');
        assertEquals(expected, observed);
    }

}