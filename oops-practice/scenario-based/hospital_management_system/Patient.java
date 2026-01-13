package hospital_management_system;

public class Patient extends Person {
	private String disease;
	private String medicalHistory;
	Patient(int id,String name,String disease){
		super(id,name);
		this.disease=disease;
		this.medicalHistory="";
	}
	void addHistory(String record) {
		medicalHistory+=record+"\n";
	}
	String getMedicalHistory() {
		return medicalHistory;
	}
}
