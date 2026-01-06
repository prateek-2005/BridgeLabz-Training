abstract class Product {
    private String productId;
    private String name;
    private double price;
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    Product(String productId, String name, double price) {
        setProductId(productId);
        setName(name);
        setPrice(price);
    }
    abstract double calculateDiscount();
    void displayProducts() {
        System.out.println("Product Id: " + productId);
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
    }
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}
class Electronics extends Product implements Taxable {
    Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 15% GST";
    }
}
class Clothing extends Product implements Taxable {
    Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 5% GST";
    }
}
class Groceries extends Product implements Taxable {
    Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.02;
    }

    @Override
    public String getTaxDetails() {
        return "Groceries Tax: 2% GST";
    }
}
class Calculator {
    static void Calculate(Product product) {
        double discount = product.calculateDiscount();
        double tax = 0;

        if (product instanceof Taxable) {
            tax = ((Taxable) product).calculateTax();
            System.out.println(((Taxable) product).getTaxDetails());
        }
        double finalPrice = product.getPrice() + tax - discount;
        System.out.println("Product: " + product.getName());
        System.out.println("Base Price: " + product.getPrice());
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Final Price: " + finalPrice);
        System.out.println("End Of Invoice");
        System.out.println();
    }
}
public class ECommercePlatform {
    public static void main(String[] args) {
        Product p1 = new Electronics("ED345", "Laptop", 50000);
        Product p2 = new Clothing("CA786", "Jeans", 800);
        Product p3 = new Groceries("765", "Wheat", 1000);
        Calculator.Calculate(p1);
        Calculator.Calculate(p2);
        Calculator.Calculate(p3);
    }
}