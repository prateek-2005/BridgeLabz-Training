package jsonhandling;
import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJson {
    public static void main(String[] args) {

        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Physics");

        JSONObject student = new JSONObject();
        student.put("name", "Rahul");
        student.put("age", 21);
        student.put("subjects", subjects);

        System.out.println(student.toString(2));
    }
}
