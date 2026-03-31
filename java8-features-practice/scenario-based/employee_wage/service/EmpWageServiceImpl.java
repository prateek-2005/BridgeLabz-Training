package service;

import model.CompanyEmpWage;
import repository.CompanyRepository;
import util.RegexValidator;

import java.util.Random;

public class EmpWageServiceImpl implements IEmpWageService {

	CompanyRepository repo = new CompanyRepository();

	public void addCompany(String name, int wage, int days, int hours) {

		if (!RegexValidator.validateCompany(name))
			throw new IllegalArgumentException("Invalid Company");

		repo.addCompany(new CompanyEmpWage(name, wage, days, hours));
	}

	public void computeWage() {

		Random random = new Random();

		for (CompanyEmpWage company : repo.getCompanies()) {

			int total = 0;
			int days = 0;
			int hours = 0;

			while (days < company.getMaxDays() && hours < company.getMaxHours()) {

				int attendance = random.nextInt(3);

				int workHours = attendance == 1 ? 8 : attendance == 2 ? 4 : 0;

				int daily = workHours * company.getWagePerHour();

				company.addDailyWage(daily);

				total += daily;

				hours += workHours;
				days++;
			}

			company.setTotalWage(total);
		}
	}

	public int getTotalWage(String name) {

		return repo.getTotalWage(name);
	}
}
