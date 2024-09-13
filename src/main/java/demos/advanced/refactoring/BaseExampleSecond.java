package demos.advanced.refactoring;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Mine sweaper game, where the board is
 * represented by a List of cells. The celles are
 * represented by int arrays, where index 0 holds
 * the cell status: 4 means “flagged”
 */
public class BaseExampleSecond {

    private List<int[]> gameBoard;

    public List<int[]> getFlaggedCells() {
        List<int[]> flaggedCells = new ArrayList<>();
        for (int[] x : gameBoard) {
            if (x[0] == 4) {
                flaggedCells.add(x);
            }
        }
        return flaggedCells;
    }
}
