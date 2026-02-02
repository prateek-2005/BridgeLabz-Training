package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
class Student {

    private int id;
    private String name;
    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [ID=" + id +
               ", Name=" + name +
               ", Age=" + age +
               ", Marks=" + marks + "]";
    }
}

public class ConvertCSV {
    public static void main(String[] args) {

        String filePath = "students.csv";
        String line;
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);
                Student student = new Student(id, name, age, marks);
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
        System.out.println("Student Objects:\n");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
