package jsonhandling;
import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJson {
    public static void main(String[] args) {
        String jsonStr = "[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":22},{\"name\":\"Charlie\",\"age\":28}]";

        JSONArray jsonArray = new JSONArray(jsonStr);
        JSONArray filteredArray = new JSONArray();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            if (obj.getInt("age") > 25) {
                filteredArray.put(obj);
            }
        }

        System.out.println(filteredArray.toString(2));
    }
}
