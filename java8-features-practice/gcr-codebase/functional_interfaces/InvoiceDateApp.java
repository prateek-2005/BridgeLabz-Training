package functional_interfaces;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtils {
    static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}

public class InvoiceDateApp {

    public static void main(String[] args) {

        LocalDate invoiceDate = LocalDate.now();

        String format1 = DateUtils.formatDate(invoiceDate, "dd-MM-yyyy");
        String format2 = DateUtils.formatDate(invoiceDate, "yyyy/MM/dd");
        String format3 = DateUtils.formatDate(invoiceDate, "MMM dd, yyyy");

        System.out.println("Format 1: " + format1);
        System.out.println("Format 2: " + format2);
        System.out.println("Format 3: " + format3);
    }
}
