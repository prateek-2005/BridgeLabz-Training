class Patient {
    String name;
    int age;
    String ailment;
    final String patientID;   
    static String hospitalName = "City Hospital";
    static int totalPatients;
    Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }
    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }
    void display() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println();
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient p1 = new Patient("Lathika", 30, "Flu", "P001");
        Patient p2 = new Patient("Lidiya", 45, "Fracture", "P002");
        Patient.getTotalPatients();
        p1.display();
        p2.display();
    }
}