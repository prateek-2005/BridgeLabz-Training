package lambda_expression;
import java.util.*;
class Invoice {
    String transactionId;

    Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice generated for Transaction ID: " + transactionId;
    }
}

public class InvoiceCreation {

    public static void main(String[] args) {

        List<String> transactionIds =List.of("TXN101", "TXN102", "TXN103");

        List<Invoice> invoices =transactionIds.stream().map(Invoice::new) .toList();

        invoices.forEach(System.out::println);
    }
}
