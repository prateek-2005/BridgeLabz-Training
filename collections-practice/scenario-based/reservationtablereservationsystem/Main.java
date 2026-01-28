package reservationtablereservationsystem;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        RestaurantService service = new RestaurantService();
        Scanner sc = new Scanner(System.in);
        service.addTable(1, 4);
        service.addTable(2, 2);
        service.addTable(3, 6);
        while (true) {
            System.out.println("\n===== Restaurant Reservation System =====");
            System.out.println("1. Reserve Table");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Show Available Tables");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter customer name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter table number: ");
                        int tableNo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter time slot (e.g. 7PM-8PM): ");
                        String time = sc.nextLine();
                        service.reserveTable(name, tableNo, time);
                    } catch (TableAlreadyReservedException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter customer name to cancel: ");
                    String name = sc.nextLine();
                    service.cancelReservation(name);
                    break;
                case 3:
                    System.out.print("Enter time slot: ");
                    String time = sc.nextLine();
                    service.showAvailableTables(time);
                    break;
                case 4:
                    System.out.println("Thank you! Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
