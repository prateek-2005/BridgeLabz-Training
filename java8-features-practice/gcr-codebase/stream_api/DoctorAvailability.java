package stream_api;
import java.util.*;
import java.util.stream.*;

public class DoctorAvailability {

    static class Doctor {
        String name;
        String specialty;
        boolean availableOnWeekend;

        Doctor(String name, String specialty, boolean availableOnWeekend) {
            this.name = name;
            this.specialty = specialty;
            this.availableOnWeekend = availableOnWeekend;
        }

        @Override
        public String toString() {
            return name + " | " + specialty + " | Weekend Available: " + availableOnWeekend;
        }
    }

    public static void main(String[] args) {

        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. Sharma", "Cardiology", true),
            new Doctor("Dr. Mehta", "Neurology", false),
            new Doctor("Dr. Rao", "Orthopedics", true),
            new Doctor("Dr. Singh", "Dermatology", true),
            new Doctor("Dr. Verma", "Cardiology", false)
        );

        doctors.stream()
               .filter(d -> d.availableOnWeekend)
               .sorted(Comparator.comparing(d -> d.specialty))
               .forEach(System.out::println);
    }
}
