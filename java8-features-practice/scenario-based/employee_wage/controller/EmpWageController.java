package controller;

import service.EmpWageServiceImpl;
import service.IEmpWageService;

public class EmpWageController {

    private IEmpWageService service = new EmpWageServiceImpl();

    public void addCompany(
            String name,
            int wage,
            int days,
            int hours) {

        service.addCompany(name, wage, days, hours);
    }

    public void computeWage() {
        service.computeWage();
    }

    public int getTotalWage(String name) {
        return service.getTotalWage(name);
    }
}
