import java.util.Scanner;
public class CafeteriaMenuApp {
    static String[] menuItems = { "Idli", "Dosa", "Vada", "Puri", "Upma","Sandwich", "Burger", "Pizza", "Pasta", "Tea"};
    static void displayMenu() {
        System.out.println("Cafeteria Menu:");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(i + " - " + menuItems[i]);
        }
    }
    static String getItemByIndex(int index) {
        if (index >= 0 && index < menuItems.length) {
            return menuItems[index];
        }
        return "Invalid selection";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu();
        System.out.print("\nEnter item index to order: ");
        int choice = sc.nextInt();
        String selectedItem = getItemByIndex(choice);
        System.out.println("You selected: " + selectedItem);
        sc.close();
    }
}
