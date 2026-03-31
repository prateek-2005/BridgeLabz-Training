package service;

public interface IEmpWageService {

    void addCompany(
            String name,
            int wage,
            int days,
            int hours);

    void computeWage();

    int getTotalWage(String name);
}
