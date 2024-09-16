package section5_adv_apis.part1_junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimerFilterTest {

    // Test for the isOK() method
    @Test
    public void testIsOKValidPrimer() {
        Primer primer = new Primer("ATCGATCG");
        HomopolymerFilter filter = new HomopolymerFilter();

        assertTrue(filter.isOK(primer), "Expected the primer to be valid (no homopolymers).");
    }

    @Test
    public void testIsOKWithHomopolymers() {
        Primer primer = new Primer("AAAAAAA");  // homopolymer sequence
        HomopolymerFilter filter = new HomopolymerFilter();

        assertFalse(filter.isOK(primer), "Expected the primer to be invalid due to homopolymer.");
    }

    @Test
    public void testIsOKMixedSequence() {
        Primer primer = new Primer("ATCGAAAAATCG"); // partially homopolymer
        HomopolymerFilter filter = new HomopolymerFilter();

        assertFalse(filter.isOK(primer), "Expected the primer to be invalid due to partial homopolymer.");
    }

    @Test
    public void testIsOKShortPrimer() {
        Primer primer = new Primer("A");  // A very short sequence
        HomopolymerFilter filter = new HomopolymerFilter();

        assertTrue(filter.isOK(primer), "Expected the short primer to be valid (too short to have homopolymers).");
    }

    // Test for the getName() method
    @Test
    public void testGetName() {
        HomopolymerFilter filter = new HomopolymerFilter();

        assertEquals("Homopolymer Filter", filter.getName(), "Expected filter name to be 'Homopolymer Filter'.");
    }
}
