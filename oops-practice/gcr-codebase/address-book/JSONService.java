package address_book;
import java.io.*;
import java.util.List;
public class JSONService {
    public static void writeJSON(String fileName, List<Contact> contacts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("[\n");
            for (int i = 0; i < contacts.size(); i++) {
                Contact c = contacts.get(i);
                writer.write("{\n");
                writer.write("\"firstName\":\"" + c.firstName + "\",\n");
                writer.write("\"lastName\":\"" + c.lastName + "\",\n");
                writer.write("\"city\":\"" + c.city + "\"\n");
                writer.write("}");
                if (i != contacts.size() - 1)
                    writer.write(",");
                writer.write("\n");
            }
            writer.write("]");
            System.out.println("JSON file created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
