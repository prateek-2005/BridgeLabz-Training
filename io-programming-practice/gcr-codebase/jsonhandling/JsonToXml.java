package jsonhandling;
import org.json.JSONObject;
import org.json.XML;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
public class JsonToXml {
    public static void main(String[] args) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get("data.json")));
            JSONObject jsonObject = new JSONObject(jsonData);
            String xmlData = XML.toString(jsonObject);
            System.out.println(xmlData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
