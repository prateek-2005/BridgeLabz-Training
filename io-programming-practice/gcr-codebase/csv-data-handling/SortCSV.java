package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
public class SortCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String line;
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String department = data[2];
                double salary = Double.parseDouble(data[3]);
                employees.add(new Employee(id, name, department, salary));
            }
            employees.sort(Comparator.comparingDouble(e -> -e.salary));
            System.out.println("Top 5 Highest Paid Employees:\n");
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                Employee e = employees.get(i);
                System.out.println("ID         : " + e.id);
                System.out.println("Name       : " + e.name);
                System.out.println("Department : " + e.department);
                System.out.println("Salary     : " + e.salary);
                System.out.println("----------------------------");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
