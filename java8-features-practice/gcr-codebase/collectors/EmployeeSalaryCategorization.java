package collectors;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeSalaryCategorization {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee("Amit", "IT", 60000),
            new Employee("Ravi", "HR", 45000),
            new Employee("Neha", "IT", 70000),
            new Employee("Priya", "Finance", 50000),
            new Employee("Suresh", "HR", 55000)
        );

        Map<String, Double> avgSalaryByDept =
            employees.stream()
                     .collect(Collectors.groupingBy(
                         Employee::getDepartment,
                         Collectors.averagingDouble(Employee::getSalary)
                     ));

        System.out.println(avgSalaryByDept);
    }
}
