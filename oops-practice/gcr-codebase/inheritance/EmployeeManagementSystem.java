class Employee{
    String name;
    String id;
    int salary;
    Employee(String name,String id,int salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }
    void displayDetails(){
        System.out.println("Employee Name: "+name);
        System.out.println("Employee ID: "+id);
        System.out.println("Salary: "+salary);
    }
}
class Manager extends Employee{
    int size;
    Manager(String name, String id, int salary, int size) {
        super(name, id, salary);
        this.size=size;
    }
    @Override
    void displayDetails() {
        System.out.println("Manager Name: "+name);
        System.out.println("Employee ID: "+id);
        System.out.println("Salary: "+salary);
        System.out.println("Team Size: "+size);
    }
}
class Developer extends  Employee{
    String ProgrammingLanguage;
    Developer(String name, String id, int salary,String programmingLanguage) {
        super(name, id, salary);
        this.ProgrammingLanguage=programmingLanguage;
    }

    @Override
    void displayDetails() {
        System.out.println("Developer Name: "+name);
        System.out.println("Employee ID: "+id);
        System.out.println("Salary: "+salary);
        System.out.println("Programming Language: "+ProgrammingLanguage);
    }
}
class Intern extends  Employee{

    Intern(String name, String id, int salary) {
        super(name, id, salary);
    }
    @Override
    void displayDetails() {
        System.out.println("Intern Name: "+name);
        System.out.println("Employee ID: "+id);
        System.out.println("Salary: "+salary);
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee employee=new Employee("CEO","ID5153",1000000);
        Manager manager=new Manager("Ravi","ID1235",100000,5);
        Developer developer=new Developer("Prateek","ID127246",50000,"Java");
        Intern intern=new Intern("Dipanshu","ID789",10000);
        employee.displayDetails();
        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();

    }
}
