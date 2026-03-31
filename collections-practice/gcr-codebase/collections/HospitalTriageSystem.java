import java.util.*;
class Patient {
    String name;
    int severity;
    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}
public class HospitalTriageSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine();
        PriorityQueue<Patient> pq = new PriorityQueue<>((a, b) -> b.severity - a.severity);
        System.out.println("Enter patient name and severity:");
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int severity = sc.nextInt();
            sc.nextLine();
            pq.add(new Patient(name, severity));
        }
        System.out.print("Treatment Order: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll().name);
            if (!pq.isEmpty()) System.out.print(", ");
        }
        sc.close();
    }
}
