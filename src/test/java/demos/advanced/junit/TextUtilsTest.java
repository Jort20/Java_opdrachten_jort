package demos.advanced.junit;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TextUtilsTest {

//    @Test
//    void getLongestWord() {
//        fail("Not implemented yet");
//    }


    @BeforeEach
    public void beforeEachTest() {
        System.out.println("starting a new test..");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("test ended..");
    }

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("starting a new test class..");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("test class finished..");
    }

    @Test
    public void getLongestWordSunny() {
        final String input = "Hello JUnit testing world";
        final String expected = "testin";
        final String observed = TextUtils.getLongestWord(input);
//        assertEquals(expected, observed);
        fail();
    }


    @Tag("sometimes")
    @DisplayName("When a tie occurs")
    @Test
    public void getLongestWordTie() {
        System.out.println("getLongestWordTie() should be skipped!");
        final String longestWordTie = "de kat krabt alle krullen krallen krollen van de trap";
        final String expectedLongest = "krollen";
        final String givenLongest = TextUtils.getLongestWord(longestWordTie);
        assertEquals(expectedLongest, givenLongest);
    }

    @Test
    public void getLongestWordPunctuation() {
        final String punctuated = "de kat krabt, maar soms.";
        final String expected = "krabt";
        final String givenLongest = TextUtils.getLongestWord(punctuated);
        assertEquals(expected, givenLongest);
    }

    @Test
    public void stripPunctuationTest() {
        final String input = "de kat krabt, maar soms.";
        final String expected = "de kat krabt maar soms";
        final String returned = TextUtils.stripNonWordCharacters(input);
        assertEquals(expected, returned);
    }


    @Test
    void shouldThrowException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> TextUtils.getLongestWord(null));
        assertEquals(exception.getMessage(), "text cannot be null or empty");
    }


    @Tag("rarely") //tag used for selecting which subset of tests to run
    @Test
    public void shouldThrowExceptionOldSchool() {
        try {
            TextUtils.getLongestWord(null);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("text cannot be null or empty", e.getMessage());
        }
    }

}