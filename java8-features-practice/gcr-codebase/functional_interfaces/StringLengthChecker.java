package functional_interfaces;
import java.util.function.Function;

public class StringLengthChecker {

    public static void main(String[] args) {

        String message = "Welcome to the notification system";
        int limit = 20;
        Function<String, Integer> lengthFunction = msg -> msg.length();

        int length = lengthFunction.apply(message);

        if (length > limit) {
            System.out.println("Message exceeds character limit");
        } else {
            System.out.println("Message is within character limit");
        }
    }
}
