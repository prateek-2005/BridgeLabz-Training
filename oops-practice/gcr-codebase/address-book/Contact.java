package address_book;
import java.util.Objects;

public class Contact {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phone;
    String email;

    public Contact(String firstName, String lastName,
                   String address, String city,
                   String state, String zip,
                   String phone, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String toFileString() {

        return firstName + "," + lastName + "," +
               address + "," + city + "," +
               state + "," + zip + "," +
               phone + "," + email;
    }

    public static Contact fromFileString(String line) {

        String[] data = line.split(",");

        return new Contact(
                data[0], data[1], data[2],
                data[3], data[4], data[5],
                data[6], data[7]);
    }

    public void display() {

        System.out.println("\nName: " + getFullName());
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip: " + zip);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }

    @Override
    public boolean equals(Object o) {

        Contact c = (Contact) o;

        return firstName.equalsIgnoreCase(c.firstName)
                && lastName.equalsIgnoreCase(c.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);
    }
}
