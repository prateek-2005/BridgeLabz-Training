package dynamiconlinemarketplace;

public class MarketPlace{
    public static void main(String[] args) {

        Product<BookCategory> book =new Product<>("Java Mastery", 500, new BookCategory());
        Product<ClothingCategory> shirt =new Product<>("T-Shirt", 800, new ClothingCategory());
        Product<GadgetCategory> phone =new Product<>("Smartphone", 20000, new GadgetCategory());
        Catalog catalog = new Catalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);
        System.out.println("Before Discount:");
        catalog.showCatalog();
        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(phone, 20);
        System.out.println("\nAfter Discount:");
        catalog.showCatalog();
    }
}

