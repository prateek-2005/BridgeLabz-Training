package healthclinicapp;
import java.util.Scanner;

public class HealthClinicApp {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect Role:");
            System.out.println("1. Receptionist");
            System.out.println("2. Doctor");
            System.out.println("3. Admin");
            System.out.println("4. Exit");

            int role = sc.nextInt();
            sc.nextLine();

            switch (role) {

                case 1:
                    System.out.println("1. Register Patient");
                    System.out.println("2. Book Appointment");
                    int r = sc.nextInt(); sc.nextLine();
                    if (r == 1) PatientService.registerPatient(sc);
                    else if (r == 2) AppointmentService.bookAppointment(sc);
                    break;

                case 2:
                    VisitService.recordVisit(sc);
                    break;

                case 3:
                    System.out.println("Admin module (Add Doctor)");
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}
