class Employee {
    public int employeeID;
    protected String department;
    private double salary;
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
            System.out.println("Salary updated to: $" + salary);
        } else {
            System.out.println("Invalid salary amount.");
        }
    }
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
        System.out.println();
    }
}
class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayManagerDetails() {
        System.out.println("Manager ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + getSalary());
        System.out.println();
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Employee employee= new Employee(10113, "Finance", 50000);
        employee.displayDetails();
        employee.setSalary(55000);
        System.out.println("Updated Salary:" + employee.getSalary());
        employee.displayDetails();
        Manager mgr1 = new Manager(13381, "IT", 80000);
        mgr1.displayManagerDetails();
    }
}