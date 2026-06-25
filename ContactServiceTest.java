package ContactService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    void testAddContact() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    void testDeleteContact() {
        service.addContact(contact);
        service.deleteContact("C001");
        // No exception expected on re-delete
        service.deleteContact("C001");
    }

    @Test
    void testUpdateContact() {
        service.addContact(contact);
        service.updateContact("C001", "Jane", "Smith", "0987654321", "456 Oak Ave");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> 
            service.updateContact("XXX", "Jane", null, null, null));
    }
}