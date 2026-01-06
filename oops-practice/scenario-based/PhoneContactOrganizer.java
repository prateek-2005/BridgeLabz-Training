import java.util.*;
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}
public class PhoneContactOrganizer {

    static ArrayList<Contact> contacts = new ArrayList<>();
    public static void addContact(String name, String phoneNumber) throws InvalidPhoneNumberException {
        if (!phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException(
                    "Phone number must be exactly 10 digits");
        }

        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Duplicate contact not allowed!");
                return;
            }
        }

        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully.");
    }
    public static void deleteContact(String phoneNumber) {
        Iterator<Contact> it = contacts.iterator();
        while (it.hasNext()) {
            if (it.next().getPhoneNumber().equals(phoneNumber)) {
                it.remove();
                System.out.println("Contact deleted.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
    public static void searchContact(String phoneNumber) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("Contact not found.");
    }
    public static void main(String[] args) {
        try {
            addContact("Rahul", "9876543210");
            addContact("Amit", "9876543210");
            addContact("Neha", "12345");     
        } catch (InvalidPhoneNumberException e) {
            System.out.println(e.getMessage());
        }
        searchContact("9876543210");
        deleteContact("9876543210");
        searchContact("9876543210");
    }
}
