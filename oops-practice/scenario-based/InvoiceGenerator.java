class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}
public class InvoiceGenerator {
    static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {
        if (!input.contains("-")) {
            throw new InvalidInvoiceFormatException("Invalid format: Missing '-'");
        }
        return input.split(",");
    }
    static int getTotalAmount(String[] tasks) throws InvalidInvoiceFormatException {
        int total = 0;

        for (String task : tasks) {
            try {
                String[] parts = task.split("-");
                String amountPart = parts[1].trim().split(" ")[0];
                total += Integer.parseInt(amountPart);
            } catch (Exception e) {
                throw new InvalidInvoiceFormatException("Invalid format in task: " + task);
            }
        }
        return total;
    }
    public static void main(String[] args) {
        String input = "Logo Design - 3000 INR, Web Page - 4500 INR";
        try {
            String[] tasks = parseInvoice(input);
            int totalAmount = getTotalAmount(tasks);
            System.out.println("Total Invoice Amount: " + totalAmount + " INR");
        } catch (InvalidInvoiceFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
