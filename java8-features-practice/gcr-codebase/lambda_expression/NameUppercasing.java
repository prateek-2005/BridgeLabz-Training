package lambda_expression;
import java.util.*;

public class NameUppercasing {

    public static void main(String[] args) {
    	
    	
        List<String> employeeNames =List.of("Amit", "Neha", "Rahul", "Priya");
        employeeNames.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
