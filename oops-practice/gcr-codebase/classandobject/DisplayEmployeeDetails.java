class Employee{
	String EmployeeName;
	int Employeeid;
	int Salary;
	Employee(String EmployeeName,int Employeeid,int Salary){
		this.EmployeeName=EmployeeName;
		this.Employeeid=Employeeid;
		this.Salary=Salary;
	}
	void Display() {
		System.out.println("EmployeeName: "+EmployeeName);
		System.out.println("EmployeeId: "+Employeeid);
		System.out.println("Salary Of Employee: "+Salary);
	}
}
public class DisplayEmployeeDetails {

	public static void main(String[] args) {
		Employee employee1=new Employee("Rohan",5152,10000);
		employee1.Display();
		System.out.println();
		Employee employee2=new Employee("Prateek",5050,50000);
		employee2.Display();
	}
}
