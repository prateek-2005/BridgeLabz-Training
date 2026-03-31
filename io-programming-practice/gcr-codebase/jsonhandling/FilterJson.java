package jsonhandling;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
public class FilterJson {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("data.json")));
            JSONArray users = new JSONArray(content);
            System.out.println("Users older than 25:");
            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);
                int age = user.getInt("age");
                if (age > 25) {
                    System.out.println(user.toString(2));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
