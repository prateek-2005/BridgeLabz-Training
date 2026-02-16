package repository;

import model.CompanyEmpWage;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {

	private List<CompanyEmpWage> companies;

	public CompanyRepository() {

		companies = new ArrayList<>();
	}

	public void addCompany(CompanyEmpWage company) {

		companies.add(company);
	}

	public List<CompanyEmpWage> getCompanies() {

		return companies;
	}

	public int getTotalWage(String name) {

		for (CompanyEmpWage company : companies) {

			if (company.getName().equals(name)) {

				return company.getTotalWage();
			}
		}

		return -1;
	}
}
