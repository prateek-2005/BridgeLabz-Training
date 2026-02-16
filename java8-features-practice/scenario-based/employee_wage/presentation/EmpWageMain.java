package presentation;

import controller.EmpWageController;

import java.util.Scanner;

public class EmpWageMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		EmpWageController controller = new EmpWageController();

		System.out.println("Welcome to Employee Wage Program");

		System.out.print("Enter number of companies: ");

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.println("\nEnter details for Company " + (i + 1));

			System.out.print("Enter Company Name: ");
			String name = sc.next();

			System.out.print("Enter Wage per Hour: ");
			int wage = sc.nextInt();

			System.out.print("Enter Max Working Days: ");
			int days = sc.nextInt();

			System.out.print("Enter Max Working Hours: ");
			int hours = sc.nextInt();

			try {

				controller.addCompany(name, wage, days, hours);

				System.out.println("Company Added Successfully");

			} catch (IllegalArgumentException e) {

				System.out.println("Error: " + e.getMessage());

				i--;
			}
		}

		controller.computeWage();

		System.out.println("\nTotal Wage Results:");

		for (int i = 0; i < n; i++) {

			System.out.print("Enter company name to get wage: ");

			String company = sc.next();

			int total = controller.getTotalWage(company);

			if (total != -1)

				System.out.println("Total Wage: " + total);

			else

				System.out.println("Company not found");
		}

		sc.close();
	}
}
