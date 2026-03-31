package hospital_management_system;

public class HospitalManagementSystem {
	public static void main(String[] args) {

        HospitalService service = new Service();

        Patient p1 = new Patient(1, "Rahul", "Fever");
        p1.addHistory("2024: Viral fever");

        Doctor d1 = new Doctor(101, "Dr. Sharma", "Physician");
        Doctor d2 = new Doctor(102, "Dr. Mehta", "Dentist");

        service.addPatient(p1);
        service.addDoctor(d1);
        service.addDoctor(d2);

        try {
            service.bookAppointment(p1, d1, "10-Jan");
            service.bookAppointment(p1, d1, "10-Jan"); 
        } catch (AppointmentNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        service.viewMedicalHistory(p1);
    }
}
