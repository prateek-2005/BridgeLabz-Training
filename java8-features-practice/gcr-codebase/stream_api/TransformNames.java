package stream_api;
import java.util.*;
import java.util.stream.*;

public class TransformNames {

    public static void main(String[] args) {

        List<String> customerNames = Arrays.asList(
            "Rohit", "anita", "Vikas", "neha", "Amit"
        );

        customerNames.stream()
                     .map(String::toUpperCase)
                     .sorted()
                     .forEach(System.out::println);
    }
}
