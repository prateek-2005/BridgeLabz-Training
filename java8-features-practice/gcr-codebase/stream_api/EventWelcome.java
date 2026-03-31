package stream_api;
import java.util.*;
import java.util.stream.*;

public class EventWelcome {

    public static void main(String[] args) {

        List<String> attendees = Arrays.asList(
            "Amit", "Riya", "Karan", "Neha", "Vikas"
        );

        attendees.stream()
                 .forEach(name ->
                     System.out.println("Welcome to the event, " + name + "!")
                 );
    }
}
