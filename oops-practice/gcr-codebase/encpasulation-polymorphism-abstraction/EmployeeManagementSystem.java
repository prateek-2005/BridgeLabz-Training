abstract class Employee {
    private String employeeId;
    private String name;
    protected double baseSalary;

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }
    public String getName() {
        return name;
    }
    public double getBaseSalary() {
        return baseSalary;
    }

    Employee(String employeeId, String name, double baseSalary) {
        setEmployeeId(employeeId);
        setName(name);
        setBaseSalary(baseSalary);
    }

    abstract double calculateSalary();

    void displayDetails() {
        System.out.println("Employee Id: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}

interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(String employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return this.department;
    }
}

class PartTimeEmployee extends Employee implements Department {
    private String department;
    int workingHours;
    double wagePerHour;
    PartTimeEmployee(String employeeId, String name, double baseSalary,
                     int workingHours, double wagePerHour) {
        super(employeeId, name, baseSalary);
        this.workingHours = workingHours;
        this.wagePerHour = wagePerHour;
    }
    @Override
    double calculateSalary() {
        return workingHours * wagePerHour;
    }
    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }
    @Override
    public String getDepartmentDetails() {
        return this.department;
    }
}

public class EmployeeManagementSystem{
    public static void main(String[] args) {
        FullTimeEmployee e1 = new FullTimeEmployee("E101", "Rahul", 50000);
        PartTimeEmployee e2 = new PartTimeEmployee("E102", "Anita", 0, 80, 500);
        e1.assignDepartment("IT");
        e2.assignDepartment("HR");
        Employee[] emp = new Employee[2];
        emp[0] = e1;
        emp[1] = e2;
        for (Employee e : emp) {
            e.displayDetails();
            if (e instanceof Department) {
                Department d = (Department) e;   
                System.out.println("Department: " + d.getDepartmentDetails());
            }
            System.out.println("----------------------");
        }

    }
}
