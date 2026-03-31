package lambda_expression;
import java.util.*;
class Patient {
    int id;
    String name;

    Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int getId() {
        return id;
    }
}

public class HospitalAdmin {

    public static void main(String[] args) {

        List<Patient> patients = List.of(
            new Patient(101, "Amit"),
            new Patient(102, "Neha"),
            new Patient(103, "Rahul")
        );

        patients.stream().map(Patient::getId).forEach(System.out::println);
    }
}
