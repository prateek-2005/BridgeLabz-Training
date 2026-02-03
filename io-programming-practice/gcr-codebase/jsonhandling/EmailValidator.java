package jsonhandling;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EmailValidator{
    public static void main(String[] args) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get("user.json")));
            JSONObject jsonObject = new JSONObject(jsonData);

            String schemaData = new String(Files.readAllBytes(Paths.get("schema.json")));
            JSONObject jsonSchema = new JSONObject(new JSONTokener(schemaData));
            Schema schema = SchemaLoader.load(jsonSchema);

            schema.validate(jsonObject);
            System.out.println("JSON is valid! ");

        } catch (org.everit.json.schema.ValidationException e) {
            System.out.println("JSON is invalid! ");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
