import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AddressBook book = new AddressBook();

        int choice;

        do {

            System.out.println("\n====== ADDRESS BOOK SYSTEM ======");

            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Search by City");
            System.out.println("6. Search by State");
            System.out.println("7. Count by City");
            System.out.println("8. Sort by Name");
            System.out.println("9. Sort by City");

            System.out.println("10. Save to TXT File");
            System.out.println("11. Load from TXT File");

            System.out.println("12. Save to CSV File");
            System.out.println("13. Load from CSV File");

            System.out.println("14. Save to JSON File");

            System.out.println("15. Async Save (Multithreading)");

            System.out.println("16. Save to JSON Server");

            System.out.println("17. Save to Database");

            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    book.addContact();
                    break;

                case 2:
                    book.editContact();
                    break;

                case 3:
                    book.deleteContact();
                    break;

                case 4:
                    book.display();
                    break;

                case 5:
                    System.out.print("Enter City: ");
                    book.searchCity(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter State: ");
                    book.searchState(sc.nextLine());
                    break;

                case 7:
                    System.out.print("Enter City: ");
                    book.countCity(sc.nextLine());
                    break;

                case 8:
                    book.sortName();
                    break;

                case 9:
                    book.sortCity();
                    break;

                case 10:
                    FileService.writeToFile("contacts.txt", book.contacts);
                    break;

                case 11:
                    FileService.readFromFile("contacts.txt", book.contacts);
                    break;

                case 12:
                    CSVService.writeCSV("contacts.csv", book.contacts);
                    break;

                case 13:
                    CSVService.readCSV("contacts.csv", book.contacts);
                    break;

                case 14:
                    JSONService.writeJSON("contacts.json", book.contacts);
                    break;

                case 15:
                    ThreadedIOService.writeAsync("contacts.txt", book.contacts);
                    break;

                case 16:
                    JSONServerService.saveToServer(book.contacts);
                    break;

                case 17:
                    DatabaseService.saveContacts(book.contacts);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
