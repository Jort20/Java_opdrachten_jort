package demos.advanced.junit;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class GeneralDemos {

    @Test
    public void testDoubleEquals() {
        double one = 0.234566;
        double two = 0.234567;

        assertEquals(one, two, 0.00001);
    }

    @Test
    public void testImportant() {
        String first = "Michiel";
        String second = "Michiel";
        assertSame(first, second);
    }

    /**
     * parameterized test with single value
     */
    @DisplayName("Palindrome finding")
    @ParameterizedTest(name = "\"{0}\" should be a palindrome")
    @ValueSource(strings = {"racecar", "radarr", "able was I ere I saw elba"})
    void palindromes(String candidate) {
        assertTrue(isPalindrome(candidate), () -> candidate + " should be a palindrome!");
    }

    private boolean isPalindrome(String candidate) {
        if (candidate.equals("radarr")) return false;
        else return true;
    }

    /**
     * parameterized test with two values
     */
    @DisplayName("Roman numeral")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({"I, 1", "II, 2", "V, 5"})
    void withNiceName(String word, int number) {
        //DO TESTING WORK
    }

    class Person {
        String firstName;
        String LastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            LastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return LastName;
        }
    }

    @DisplayName("Testing the name elements of Person")
    @Test
    void groupedAssertions() {

        Person person = new Person("Jane", "Goodall");
        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("person",
                () -> assertEquals("Jane", person.getFirstName()),
                () -> assertEquals("Goodall", person.getLastName())
        );
    }


    @Test
    void dependentAssertions() {
        Person person = new Person("Jane", "Goodall");

        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);

                    // Executed only if the previous assertion is valid.
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("e"))
                    );
                },
                () -> {
                    // Grouped assertion, so processed independently
                    // of results of first name assertions.
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    // Executed only if the previous assertion is valid.
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("G")),
                            () -> assertTrue(lastName.endsWith("l"))
                    );
                }
        );
    }

    @Tag("sometimes")
    @DisplayName("Tag demo method 1: 'sometimes'")
    @Test
    public void tagDemo1() {
        System.out.println("Tag demo 1 running");
    }

    @Tag("rarely")
    @DisplayName("Tag demo method 2: 'rarely'")
    @Test
    public void tagDemo2() {
        System.out.println("Tag demo 2 running.");
    }

}
