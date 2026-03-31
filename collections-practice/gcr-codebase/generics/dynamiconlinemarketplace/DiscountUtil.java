package dynamiconlinemarketplace;

class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(newPrice);
    }
}

