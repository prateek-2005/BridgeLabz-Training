package address_book;
import java.io.*;
import java.util.List;
public class CSVService {
    public static void writeCSV(String fileName, List<Contact> contacts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("FirstName,LastName,Address,City,State,Zip,Phone,Email");
            for (Contact c : contacts) {
                writer.println(c.toFileString());
            }
            System.out.println("CSV file created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readCSV(String fileName, List<Contact> contacts) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine(); // skip header
            String line;
            while ((line = reader.readLine()) != null) {
                contacts.add(Contact.fromFileString(line));
            }
            System.out.println("CSV file loaded.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
