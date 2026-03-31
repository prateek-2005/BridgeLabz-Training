package jsonhandling;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Iterator;
public class ReadJson {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("data.json")));
            if (content.trim().startsWith("[")) {
                JSONArray jsonArray = new JSONArray(content);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    printJSONObject(obj);
                }
            } else {
                JSONObject jsonObject = new JSONObject(content);
                printJSONObject(jsonObject);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void printJSONObject(JSONObject jsonObject) {
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = jsonObject.get(key);

            if (value instanceof JSONObject) {
                System.out.println(key + ": ");
                printJSONObject((JSONObject) value);
            } else if (value instanceof JSONArray) {
                System.out.println(key + ": ");
                printJSONArray((JSONArray) value);
            } else {
                System.out.println(key + ": " + value);
            }
        }
    }

    public static void printJSONArray(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            Object item = jsonArray.get(i);
            if (item instanceof JSONObject) {
                printJSONObject((JSONObject) item);
            } else if (item instanceof JSONArray) {
                printJSONArray((JSONArray) item);
            } else {
                System.out.println(item);
            }
        }
    }
}
