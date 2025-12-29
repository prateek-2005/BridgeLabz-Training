import java.util.*;
public class EmployeeWageComputation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Employee Wage Computation Program on Master Branch");
		// Use-Case 1
		int Attendance = (int) (Math.random() * 2);
		boolean IsPresent = Attendance == 1;// 0-Absent 1-Present
		if(IsPresent) {
			System.out.println("Employee Is Present");
		}
		else {
			System.out.println("Employee Is Absent");
		}
		// Use-Case 2
		System.out.println("Enter Wage Per Hour: ");
		int WagePerHour = sc.nextInt();
		System.out.println("Enter Hours Per Day: ");
		int HoursPerDay = sc.nextInt();
		int TotalWagePerDay = WagePerHour * HoursPerDay;
		System.out.println("Total Wage Earned In a Day:  " + TotalWagePerDay);
		// Use-Case 3
		System.out.println("Enter Employee Type: (1 for Full Time,2 For Part Time)  ");
		int Emp_Type = sc.nextInt();
		String EmployeeType = " ";
		int workingHours = 0;
		if (Emp_Type == 1) {
			EmployeeType = "FullTime";
			workingHours = 8;
		} else if (Emp_Type == 2) {
			EmployeeType = "PartTime";
			workingHours = 4;
		} else {
			EmployeeType = "NotEmployee";
			workingHours = 0;
		}
		System.out.println("Normal Calculation: Employee Type: " + EmployeeType + " And Woring Hours: " + workingHours);
		// Use-Case 4
		System.out.println("Enter Employee Type: (1 for Full Time,2 For Part Time)  ");
		int Emp_TypeSwitch = sc.nextInt();
		String EmployeeTypeSwitch = " ";
		int workingHoursSwitch = 0;
		switch (Emp_TypeSwitch) {
		case 1:
			EmployeeTypeSwitch = "FullTime";
			workingHoursSwitch = 8;
		case 2:
			EmployeeTypeSwitch = "PartTime";
			workingHoursSwitch = 4;
		default:
			EmployeeTypeSwitch = "NotEmployee";
			workingHoursSwitch = 0;
		}
		System.out.println("Switch Case Calculation: Employee Type: " + EmployeeTypeSwitch + " And Woring Hours: "
				+ workingHoursSwitch);
		// Use-Case 5
		int totalWage = 0;
		System.out.println("Enter Working Days in a month:");
		int WorkingDays = sc.nextInt();
		if (Emp_Type == 1) {
			for (int i = 1; i <= WorkingDays; i++) {
				totalWage += workingHours * WagePerHour;
			}
		}
		if (Emp_Type == 2) {
			for (int i = 1; i <= WorkingDays; i++) {
				totalWage += workingHours * WagePerHour;
			}
		}
		System.out.println("TotalWage in A Month:  " + totalWage);
		//Use-Case 6
		int totalHours = 0;
		int totalDays= 0;
		int totalWageConditional= 0;
		int wagePerHour = 20;
		while (totalHours < 100 && totalDays < 20) {
			totalDays++;
			int hours = Emp_Type==1?8:4;
			totalHours += hours;
			totalWageConditional+= hours * wagePerHour;
			System.out.println(
					"Day " + totalDays + " | Hours Worked: " + hours + " | Daily Wage: " + (hours * wagePerHour));
		}
		System.out.println("\nTotal Days  : " + totalDays);
		System.out.println("Total Hours : " + totalHours);
		System.out.println("Total Wage  : " + totalWageConditional);
		sc.close();
	}
}
