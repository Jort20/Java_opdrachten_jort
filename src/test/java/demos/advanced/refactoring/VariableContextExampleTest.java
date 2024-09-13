package demos.advanced.refactoring;

import demos.advanced.refactoring.VariableContextExample;
import org.junit.jupiter.api.Test;

public class VariableContextExampleTest {

    @Test
    public void printGuessStatistics() {
        VariableContextExample ex = new VariableContextExample();
        ex.printCharacterStatistics('V', 4);
    }
}