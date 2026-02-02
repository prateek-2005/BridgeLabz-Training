package csv_data_handling;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
class Student {
    public int id;
    public String name;
    public int age;
    public int marks;
    public Student() {}
    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
}

public class ConvertCSVToJSON {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Student> students = mapper.readValue(
                new File("students.json"),
                new TypeReference<List<Student>>() {}
        );
        try (FileWriter writer = new FileWriter("students.csv")) {
            writer.write("ID,Name,Age,Marks\n");
            for (Student s : students) {
                writer.write(
                        s.id + "," +
                        s.name + "," +
                        s.age + "," +
                        s.marks + "\n"
                );
            }
        }
        System.out.println("JSON converted to CSV successfully!");
    }
}
