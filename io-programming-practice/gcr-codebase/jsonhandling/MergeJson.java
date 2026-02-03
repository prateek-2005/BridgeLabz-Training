package jsonhandling;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MergeJson {
    public static void main(String[] args) {

        Gson gson = new Gson();

        JsonObject json1 = new JsonObject();
        json1.addProperty("name", "Rahul");
        json1.addProperty("email", "rahul@gmail.com");
        JsonObject json2 = new JsonObject();
        json2.addProperty("age", 22);
        json2.addProperty("city", "Delhi");

        for (String key : json2.keySet()) {
            json1.add(key, json2.get(key));
        }
        System.out.println(json1.toString());
    }
}
