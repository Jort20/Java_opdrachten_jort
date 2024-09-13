package demos.advanced.functional_programming;

public class AdditionCombiner implements NumberCombiner{
    @Override
    public int combine(int i, int j) {
        return i + j;
    }
}
