package demos.advanced.refactoring;

import java.util.ArrayList;
import java.util.List;

public class BaseExampleFourth {
    private List<Cell> gameBoard;
    private static final int STATUS_VALUE_INDEX = 0;

    public List<Cell> getFlaggedCells() {
        List<Cell> flaggedCells = new ArrayList<>();
        for (Cell cell : gameBoard) {
            if (cell.isFlagged()) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }

    void showFactoryAdvantage() {
//        Cell cell1 = new Cell(4);
//        //OR
//        Cell cell2 = new Cell(Cell.STATUS_FLAGGED);
        //BETTER!
        Cell cell3 = Cell.createFlaggedCell();

    }

}
