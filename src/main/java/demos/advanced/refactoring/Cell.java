package demos.advanced.refactoring;

class Cell {
    static final int STATUS_FLAGGED = 4;
    private int status;

    public boolean isFlagged() {
        return status == STATUS_FLAGGED;
    }

    private Cell() {  }

    public static Cell createFlaggedCell() {
        Cell cell = new Cell();
        cell.status = STATUS_FLAGGED;
        return cell;
    }

    public static Cell fromStatusCode(int status) {
        Cell cell = new Cell();
        cell.status = status;
        return cell;
    }
}
