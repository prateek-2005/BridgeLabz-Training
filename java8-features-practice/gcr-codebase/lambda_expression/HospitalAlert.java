package lambda_expression;
import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;     
    String message;

    Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return type + " ALERT: " + message;
    }
}

public class HospitalAlert {

    public static void main(String[] args) {

        List<Alert> alerts = List.of(
            new Alert("EMERGENCY", "Heart rate critical"),
            new Alert("MEDICATION", "Time to take insulin"),
            new Alert("GENERAL", "Doctor appointment tomorrow"),
            new Alert("EMERGENCY", "Low oxygen level")
        );

        Predicate<Alert> emergencyOnly =alert -> alert.type.equals("EMERGENCY");

        System.out.println("Filtered Alerts:");
        alerts.stream().filter(emergencyOnly).forEach(System.out::println);
    }
}
