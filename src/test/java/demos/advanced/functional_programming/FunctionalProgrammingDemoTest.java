package demos.advanced.functional_programming;

import org.junit.jupiter.api.Test;

public class FunctionalProgrammingDemoTest {

    @Test
    public void mapSortedUsersToStringAndPrint() {
        FunctionalProgrammingDemo.mapSortedUsersToStringAndPrint();
    }

    @Test
    public void groupByStreetAndListName() {
        FunctionalProgrammingDemo.groupByStreetAndListName();
    }

    @Test
    public void groupByStreetAndCount() {
        FunctionalProgrammingDemo.groupByStreetAndCount();
    }

    @Test
    public void mapToObjectDemo() {
        String alignment = "   - !  !   ";
        FunctionalProgrammingDemo.mapToObjectDemo("   - !  !   ");
    }

    @Test
    public void getLongestWordOfLine() {
        String input = "foo bar ag bbababa gstgsg bbababa bbababc";
        System.out.println(FunctionalProgrammingDemo.getLongestWordOfLine(input));
    }

    @Test
    public void streamFileContents() {
        FunctionalProgrammingDemo.streamFileContents();
    }

    @Test
    public void findLongestWordAlice() {
        FunctionalProgrammingDemo.findLongestWordAlice();
    }

}