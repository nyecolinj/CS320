package ContactService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testValidContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
    }

    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("123", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("123", "VeryLongName", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testInvalidPhoneAndAddress() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("123", "John", "Doe", "12345", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("123", "John", "Doe", "1234567890", null));
    }
}