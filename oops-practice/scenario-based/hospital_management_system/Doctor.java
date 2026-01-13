package hospital_management_system;

public class Doctor extends Person {
	private String specialization;
	Doctor(int id,String name,String specialization){
		super(id,name);
		this.specialization=specialization;
	}
	String getSpecialization() {
		return specialization;
	}
	double calculateFee() {
		if(specialization.equalsIgnoreCase("physician")) {
			return 1000;
		}
		else if(specialization.equalsIgnoreCase("dentist")) {
			return 500;
		}
		else {
			return 250;
		}
	}
}
