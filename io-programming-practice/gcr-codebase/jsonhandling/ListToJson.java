package jsonhandling;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() { return name; }
    public int getAge() { return age; }
}

public class ListToJson {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 22));
        people.add(new Person("Charlie", 28));
        JSONArray jsonArray = new JSONArray();
        for (Person person : people) {
            JSONObject obj = new JSONObject();
            obj.put("name", person.getName());
            obj.put("age", person.getAge());
            jsonArray.put(obj);
        }
        System.out.println(jsonArray.toString(2)); 
    }
}
