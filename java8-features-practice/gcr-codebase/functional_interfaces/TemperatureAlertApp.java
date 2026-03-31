package functional_interfaces;
import java.util.function.Predicate;

public class TemperatureAlertApp {

    public static void main(String[] args) {

        double temperature = 39.5;
        double threshold = 37.0;

        Predicate<Double> isHighTemperature =temp -> temp > threshold;

        if (isHighTemperature.test(temperature)) {
            System.out.println("Alert: Temperature crossed threshold!");
        } else {
            System.out.println("Temperature is normal.");
        }
    }
}

