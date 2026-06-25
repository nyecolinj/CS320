package ContactService;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) throw new IllegalArgumentException("Duplicate ID");
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact c = contacts.get(contactId);
        if (c == null) throw new IllegalArgumentException("Contact not found");
        if (firstName != null) c.setFirstName(firstName);
        if (lastName != null) c.setLastName(lastName);
        if (phone != null) c.setPhone(phone);
        if (address != null) c.setAddress(address);
    }
}