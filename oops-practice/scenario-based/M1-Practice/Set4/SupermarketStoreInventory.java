package Set4;
import java.util.*;

abstract class Product {

    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    abstract void display();

    public double totalValue() {
        return price * quantity;
    }
}

class Electronics extends Product {

    int warranty;

    Electronics(String name, double price, int quantity, int warranty) {
        super(name, price, quantity);
        this.warranty = warranty;
    }

    void display() {
        System.out.println(name + " - Price: " + price +
                ", Quantity: " + quantity +
                ", Warranty: " + warranty + " months");
    }
}

class Clothing extends Product {

    String size;

    Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    void display() {
        System.out.println(name + " - Price: " + price +
                ", Quantity: " + quantity +
                ", Size: " + size);
    }
}

class Inventory {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Product added to inventory: " + p.name);
    }

    public void displayInventory() {

        System.out.println("Inventory:");

        for (Product p : products) {
            p.display();
        }
    }

    public void calculateTotalValue() {

        double total = 0;

        for (Product p : products) {
            total += p.totalValue();
        }

        System.out.printf("Total value of the inventory: %.2f\n", total);
    }
}

public class SupermarketStoreInventory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Inventory inventory = new Inventory();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            if (line.trim().isEmpty()) {
                i--;
                continue;
            }

            String[] parts = line.split(",\\s*");

            String type = parts[0];

            if (type.equals("Electronics")) {

                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                int warranty = Integer.parseInt(parts[4]);

                inventory.addProduct(
                        new Electronics(name, price, quantity, warranty)
                );

            } else if (type.equals("Clothing")) {

                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                String size = parts[4];

                inventory.addProduct(
                        new Clothing(name, price, quantity, size)
                );
            }
        }

        inventory.displayInventory();
        inventory.calculateTotalValue();
        sc.close();
    }
}