package smartcheckout;
class Item {
    private String name;
    private double price;
    private int stock;
    public Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }
    public void reduceStock(int qty) {
        this.stock -= qty;
    }
    public String getName() {
        return name;
    }
}
