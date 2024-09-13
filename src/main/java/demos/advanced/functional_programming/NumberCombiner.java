package demos.advanced.functional_programming;

/**
 * Creation date: 31-1-2018
 *
 * @author Michiel Noback (&copy; 2018)
 * @version 0.01
 */
@FunctionalInterface
public interface NumberCombiner {
    int combine(int i, int j);
}
