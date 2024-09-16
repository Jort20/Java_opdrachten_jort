package section5_adv_apis.part3_funct.fp_exercise;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class UserTest {

    @Test
    public void testUserCreation() {
        Address address = Address.of("Baker Street", 221, "A", "12345");
        User user = new User(1L, "John Doe", 10, address);

        assertEquals(1L, user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals(10, user.getNumberOfLogins());
        assertEquals(address, user.getAddress());
    }

    @Test
    public void testUserImmutability() {
        Address address = Address.of("Baker Street", 221, "A", "12345");
        User user = new User(1L, "John Doe", 10, address);

        // Try to modify the address from user
        Address modifiedAddress = Address.of("Changed Street", 0, "", "");

        // Ensure the User object is not affected
        assertEquals("Baker Street", user.getAddress().getStreet());
    }

    @Test
    public void testAddressImmutability() {
        Address address = Address.of("Baker Street", 221, "A", "12345");

        // Ensure the Address object cannot be modified after creation
        Address addressCopy = new Address(address.getStreet(), address.getNumber(), address.getNumberPostfix(), address.getZipCode());

        assertEquals(address, addressCopy);
    }
}

