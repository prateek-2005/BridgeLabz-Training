package jsonhandling;
import java.io.FileReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
public class ReadJsonFile {
    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("user.json");

            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            String name = jsonObject.get("name").getAsString();
            String email = jsonObject.get("email").getAsString();

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
