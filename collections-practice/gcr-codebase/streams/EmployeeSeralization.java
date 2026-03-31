import java.io.*;
import java.util.*;
public class EmployeeSeralization {
    static class Employee implements Serializable {
        private static final long serialVersionUID = 1L;
        private int id;
        private String name;
        private String department;
        private double salary;
        public void EmployeeSeralization(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        @Override
        public String toString() {
            return "Employee { " +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", salary=" + salary +
                    " }";
        }
    }
    public static void main(String[] args) {
        String fileName = "employees.dat";
        List<EmployeeSeralization> employeeSeralizations = new ArrayList<>();
        employeeSeralizations.add(new EmployeeSeralization(101, "Amit", "IT", 60000));
        employeeSeralizations.add(new EmployeeSeralization(102, "Neha", "HR", 50000));
        employeeSeralizations.add(new EmployeeSeralization(103, "Rahul", "Finance", 55000));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employeeSeralizations);
            System.out.println("Employees saved successfully.\n");
        } catch (IOException e) {
            System.out.println("Error during serialization.");
            e.printStackTrace();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<EmployeeSeralization> savedEmployees = (List<EmployeeSeralization>) ois.readObject();
            System.out.println("Employees retrieved from file:");
            for (EmployeeSeralization emp : savedEmployees) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization.");
            e.printStackTrace();
        }
    }
}
