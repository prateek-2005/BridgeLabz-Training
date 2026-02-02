package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
public class ValidateCSV {
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PHONE_REGEX =
            "\\d{10}";
    public static void main(String[] args) {
        String filePath = "users.csv";
        String line;
        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Pattern phonePattern = Pattern.compile(PHONE_REGEX);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String email = data[2];
                String phone = data[3];
                boolean isValid = true;
                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Invalid Email  | Row: " + line);
                    isValid = false;
                }
                if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Invalid Phone  | Row: " + line);
                    isValid = false;
                }
                if (!isValid) {
                    System.out.println("----------------------------------");
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
