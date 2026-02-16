package address_book;
import java.util.List;
public class ThreadedIOService {
    public static void writeAsync(String fileName, List<Contact> contacts) {
        Thread thread = new Thread(() -> {
            FileService.writeToFile(fileName, contacts);
            System.out.println("Async write completed.");
        });
        thread.start();
    }
    public static void readAsync(String fileName, List<Contact> contacts) {
        Thread thread = new Thread(() -> {
            FileService.readFromFile(fileName, contacts);
            System.out.println("Async read completed.");
        });
        thread.start();
    }
}
