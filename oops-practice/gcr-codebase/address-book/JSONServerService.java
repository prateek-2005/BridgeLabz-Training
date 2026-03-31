package address_book;
import java.util.List;
public class JSONServerService {
    public static void saveToServer(List<Contact> contacts) {
        System.out.println("Connecting to JSON Server...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Contacts uploaded to server.");
    }
    public static void fetchFromServer() {
        System.out.println("Fetching contacts from server...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Contacts downloaded.");
    }
}
