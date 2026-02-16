package model;

import java.util.ArrayList;
import java.util.List;

public class CompanyEmpWage {

	private String name;
	private int wagePerHour;
	private int maxDays;
	private int maxHours;

	private int totalWage;

	private List<Integer> dailyWage = new ArrayList<>();

	public CompanyEmpWage(String name, int wage, int days, int hours) {

		this.name = name;
		this.wagePerHour = wage;
		this.maxDays = days;
		this.maxHours = hours;
	}

	public void addDailyWage(int wage) {

		dailyWage.add(wage);
	}

	public String getName() {
		return name;
	}

	public int getWagePerHour() {
		return wagePerHour;
	}

	public int getMaxDays() {
		return maxDays;
	}

	public int getMaxHours() {
		return maxHours;
	}

	public int getTotalWage() {
		return totalWage;
	}

	public void setTotalWage(int totalWage) {

		this.totalWage = totalWage;
	}
}
