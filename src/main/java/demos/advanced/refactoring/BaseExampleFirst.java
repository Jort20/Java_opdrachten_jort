package demos.advanced.refactoring;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Minesweeper game, where the board is
 * represented by a List of cells. The cells are
 * represented by int arrays, where index 0 holds
 * the cell status: 4 means “flagged”
 */
public class BaseExampleFirst {

    private List<int[]> theList;

    public List<int[]> getThem() {
        List<int[]> list1 = new ArrayList<>();
        for (int[] x : theList) {
            if (x[0] == 4) {
                list1.add(x);
            }
        }
        return list1;
    }
}
