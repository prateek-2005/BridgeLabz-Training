package address_book;
import java.io.*;
import java.util.List;
public class FileService {
    public static void writeToFile(String fileName, List<Contact> contacts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Contact c : contacts) {
                writer.write(c.toFileString());
                writer.newLine();
            }
            System.out.println("Contacts saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
    public static void readFromFile(String fileName, List<Contact> contacts) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contacts.add(Contact.fromFileString(line));
            }
            System.out.println("Contacts loaded from file.");
        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
