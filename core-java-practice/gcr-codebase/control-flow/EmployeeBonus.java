import java.util.*;
public class EmployeeBonus {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double Salary=sc.nextInt();
		int YearsOfService=sc.nextInt();
		double bonus=0;
		if(YearsOfService>5) {
			bonus=0.05*Salary;
		}
		System.out.println("Bonus Amount "+bonus);
		sc.close();
	}

}
