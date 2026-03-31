package hospital_management_system;

public class Appointment {
	private Patient patient;
	private Doctor doctor;
	private String date;

	Appointment(Patient patient, Doctor doctor, String date) {
		this.patient = patient;
		this.doctor = doctor;
		this.date = date;
	}

	public Patient getPatient() {
		return patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public String getDate() {
		return date;
	}
}
