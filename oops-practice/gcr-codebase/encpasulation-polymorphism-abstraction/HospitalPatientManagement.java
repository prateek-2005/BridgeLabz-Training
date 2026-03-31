abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    Patient(String patientId, String name, int age) {
        setPatientId(patientId);
        setName(name);
        setAge(age);
    }
    public void setPatientId(String patientId) {
    	this.patientId=patientId;
    }
    public void setName(String name) {
    	this.name=name;
    }
    public void setAge(int age) {
    	this.age=age;
    }
    public String getPatientId() { 
    	return patientId;
    }
    public String getName() {
    	return name;
    }
    public int getAge() { 
    	return age;
    }
    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
    abstract double calculateBill();
}
interface MedicalRecord {
    void addRecord(String diagnosis);
    String viewRecords();
}
class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int daysAdmitted;
    private String diagnosis; 
    InPatient(String patientId, String name, int age, double dailyRate, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyRate = dailyRate;
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    double calculateBill() {
        return dailyRate * daysAdmitted;
    }

    @Override
    public void addRecord(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String viewRecords() {
        return "Diagnosis: " + getDiagnosis();
    }

    private String getDiagnosis() {
        return diagnosis;
    }
}
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String diagnosis;
    OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    double calculateBill() {
        return consultationFee; 
    }

    @Override
    public void addRecord(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String viewRecords() {
        return "Diagnosis: " + getDiagnosis();
    }

    private String getDiagnosis() {
        return diagnosis;
    }
}
class Display {
    static void display(Patient p) {
        System.out.println(p.getPatientDetails());
        System.out.println("Bill Amount: " + p.calculateBill());
        if (p instanceof MedicalRecord) {
            MedicalRecord mr = (MedicalRecord) p;
            System.out.println("Medical Record: " + mr.viewRecords());
        }
        System.out.println("End Of Patient Record\n");
    }
}
public class HospitalPatientManagement{
    public static void main(String[] args) {
        Patient p1 = new InPatient("P101","Aditya",30,2000,5);
        Patient p2 = new OutPatient("P202","Rose",40,500);
        ((MedicalRecord)p1).addRecord("Denque");
        ((MedicalRecord)p2).addRecord("Flu And Fever");
        Display.display(p1);
        Display.display(p2);
    }
}