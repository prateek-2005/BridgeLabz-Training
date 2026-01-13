package hospital_management_system;

public class Service implements HospitalService {
	private Patient[] patients=new Patient[10];
	private Doctor[] doctors=new Doctor[10];
	private Appointment[] appointments = new Appointment[10];

    private int patientCount = 0;
    private int doctorCount = 0;
    private int appointmentCount = 0;

    @Override
    public void addPatient(Patient patient) {
        patients[patientCount++] = patient;
        System.out.println("Patient added: " + patient.getName());
    }

    @Override
    public void deletePatient(int patientId) {
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getId() == patientId) {
                patients[i] = patients[patientCount - 1];
                patientCount--;
                System.out.println("Patient deleted");
                return;
            }
        }
        System.out.println("Patient not found");
    }
    @Override
    public void addDoctor(Doctor doctor) {
        doctors[doctorCount++] = doctor;
        System.out.println("Doctor added: " + doctor.getName());
    }

    @Override
    public void bookAppointment(Patient patient, Doctor doctor, String date) throws AppointmentNotAvailableException {
        for (int i = 0; i < appointmentCount; i++) {
            if (appointments[i].getDoctor() == doctor &&
                appointments[i].getDate().equals(date)) {
                throw new AppointmentNotAvailableException("Doctor not available on " + date);
            }
        }

        appointments[appointmentCount++] = new Appointment(patient, doctor, date);
        System.out.println("Appointment booked. Fee: ₹" + doctor.calculateFee());
    }
    @Override
    public void viewMedicalHistory(Patient patient) {
        System.out.println("Medical History of " + patient.getName());
        System.out.println(patient.getMedicalHistory());
    }
}
