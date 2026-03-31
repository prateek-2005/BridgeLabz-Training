class Employee {
    String name;
    final int id; 
    String designation;
    static int totalEmployee; 
    static String companyName = "Tech Solutions Inc.";
    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployee++;
    }
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployee);
    }
    void display() {
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("Thamarai", 101, "Software Engineer");
        Employee e2 = new Employee("Rohan", 102, "Project Manager");
        Employee.displayTotalEmployees();
        e1.display();
        e2.display();
    }
}