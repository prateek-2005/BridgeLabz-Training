import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
    public static void main(String[] args) {
        LocalDate Date = LocalDate.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        System.out.println("Current Date in dd/MM/yyyy format: " + Date.format(formatter1));
        System.out.println("Current Date in yyyy-MM-dd format: " + Date.format(formatter2));
        System.out.println("Current Date in EEE, MMM dd, yyyy format: " + Date.format(formatter3));
    }
}