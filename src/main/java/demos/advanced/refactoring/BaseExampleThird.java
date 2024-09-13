package demos.advanced.refactoring;

import java.util.ArrayList;
import java.util.List;

public class BaseExampleThird {
    private List<int[]> gameBoard;
    private static final int STATUS_VALUE_INDEX = 0;
    private static final int STATUS_FLAGGED = 4;

    public List<int[]> getFlaggedCells() {
        List<int[]> flaggedCells = new ArrayList<>();
        for (int[] x : gameBoard) {
            if (x[STATUS_VALUE_INDEX] == STATUS_FLAGGED) {
                flaggedCells.add(x);
            }
        }
        return flaggedCells;
    }
}
