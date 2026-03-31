package jsonhandling;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidate {
    public static void main(String[] args) {

        String json = "{ \"name\": \"Rahul\", \"email\": \"rahul@gmail.com\" }";

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(json); 
            System.out.println("Valid JSON");
        } catch (Exception e) {
            System.out.println("Invalid JSON");
        }
    }
}
