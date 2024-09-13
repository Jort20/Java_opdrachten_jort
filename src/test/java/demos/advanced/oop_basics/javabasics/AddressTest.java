package demos.advanced.oop_basics.javabasics;
import demos.advanced.oop_basics.javabasics.Address;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Creation date: Jun 14, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class AddressTest {
    private Address address;

    @BeforeEach
    public void createAddress() {
        this.address = new Address("Hoofdweg", 122);
    }

    @Test//(expected = java.lang.IllegalArgumentException.class)
    public void setZipCodeNull() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> this.address.setZipCode(null));
    }

    @Test//(expected = java.lang.IllegalArgumentException.class)
    public void setZipCodeEmpty() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            this.address.setZipCode("");
        });
//        this.address.setZipCode("");
    }

    @Test
    public void setZipCodeDutch() throws Exception {
        this.address.setZipCode("1111AB");
        assertEquals("1111 AB", this.address.getZipCode());

        this.address.setZipCode("2222 CZ");
        assertEquals("2222 CZ", this.address.getZipCode());

        this.address.setZipCode(" 3333DQ ");
        assertEquals("3333 DQ", this.address.getZipCode());
    }

    @Test//(expected = java.lang.IllegalArgumentException.class)
    public void setZipCodeUS() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            this.address.setZipCode("90210");
        });
        //this.address.setZipCode("90210");
    }

    @Test//(expected = java.lang.IllegalArgumentException.class)
    public void setZipCodeDutchBadFormatted1() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            this.address.setZipCode("11111 AB");
        });
        //this.address.setZipCode("11111 AB");
    }

    @Test//(expected = java.lang.IllegalArgumentException.class)
    public void setZipCodeDutchBadFormatted2() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            this.address.setZipCode("1111  AB");
        });
        //this.address.setZipCode("1111  AB");
    }

//    @Test//(expected = java.lang.IllegalArgumentException.class)
//    public void setZipCodeDutchBadFormatted3() throws Exception {
//        assertThrows(IllegalArgumentException.class, () -> {
//            this.address.setZipCode("1111AB ");
//        });
//        //this.address.setZipCode("1111 A8");
//    }

}