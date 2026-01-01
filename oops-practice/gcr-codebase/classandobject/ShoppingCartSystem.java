class Product {
    final String productID;  
    String productName;
    double price;             
    int quantity;
    static double discount = 10.0; 
    Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    double getPriceAfterDiscount() {
        double off = (discount / 100) * price;
        return price - off;
    }
    void display() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Price after Discount: $" + getPriceAfterDiscount());
            System.out.println();
        }
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product p1 = new Product("P001", "Laptop", 1200.0, 5);
        Product p2 = new Product("P002", "Smartphone", 800.0, 10);
        p1.display();
        p2.display();
        Product.updateDiscount(20.0);
        System.out.println("After updating discount:\n");
        p1.display();
        p2.display();
    }
}