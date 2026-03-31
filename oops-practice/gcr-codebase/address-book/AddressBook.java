package address_book;
import java.util.*;

public class AddressBook {

    ArrayList<Contact> contacts = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void addContact() {

        System.out.println("Enter First Name:");
        String first = sc.nextLine();

        System.out.println("Enter Last Name:");
        String last = sc.nextLine();

        Contact newContact = new Contact(first,last,"","","","","","");

        if(contacts.contains(newContact)) {

            System.out.println("Duplicate Contact!");
            return;
        }

        System.out.println("Enter Address:");
        String address = sc.nextLine();

        System.out.println("Enter City:");
        String city = sc.nextLine();

        System.out.println("Enter State:");
        String state = sc.nextLine();

        System.out.println("Enter Zip:");
        String zip = sc.nextLine();

        System.out.println("Enter Phone:");
        String phone = sc.nextLine();

        System.out.println("Enter Email:");
        String email = sc.nextLine();

        contacts.add(new Contact(first,last,address,city,state,zip,phone,email));

        System.out.println("Contact Added");
    }

    public void editContact() {

        System.out.println("Enter name:");
        String name = sc.nextLine();

        for(Contact c:contacts) {

            if(c.getFullName().equalsIgnoreCase(name)) {

                System.out.println("Enter new city:");
                c.city=sc.nextLine();

                System.out.println("Enter new phone:");
                c.phone=sc.nextLine();

                System.out.println("Updated");
                return;
            }
        }
        System.out.println("Not Found");
    }

    public void deleteContact() {

        System.out.println("Enter name:");
        String name=sc.nextLine();

        contacts.removeIf(c->c.getFullName().equalsIgnoreCase(name));

        System.out.println("Deleted");
    }

    public void display() {

        for(Contact c:contacts)
            c.display();
    }

    public void searchCity(String city) {

        contacts.stream()
                .filter(c->c.city.equalsIgnoreCase(city))
                .forEach(Contact::display);
    }

    public void searchState(String state) {

        contacts.stream()
                .filter(c->c.state.equalsIgnoreCase(state))
                .forEach(Contact::display);
    }

    public void countCity(String city) {

        long count=contacts.stream()
                .filter(c->c.city.equalsIgnoreCase(city))
                .count();

        System.out.println("Count:"+count);
    }

    public void sortName() {

        contacts.sort(Comparator.comparing(c->c.firstName));

        display();
    }

    public void sortCity() {

        contacts.sort(Comparator.comparing(c->c.city));

        display();
    }
}
