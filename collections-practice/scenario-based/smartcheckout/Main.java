package smartcheckout;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        SmartCheckout checkout = new SmartCheckout();
        Scanner sc = new Scanner(System.in);
        checkout.addItem("Milk", 50, 10);
        checkout.addItem("Bread", 30, 20);
        checkout.addItem("Rice", 60, 15);
        while (true) {
            System.out.println("\n===== SmartCheckout System =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Process Next Customer");
            System.out.println("3. Show Queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    Customer customer = new Customer(name);
                    while (true) {
                        System.out.print("Enter item name (or 'done'): ");
                        String item = sc.nextLine();
                        if (item.equalsIgnoreCase("done")) break;
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        sc.nextLine();
                        customer.addItem(item, qty);
                    }
                    checkout.addCustomer(customer);
                    break;
                case 2:
                    checkout.processNextCustomer();
                    break;
                case 3:
                    checkout.showQueue();
                    break;
                case 4:
                    System.out.println("Thank you! System closed.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
