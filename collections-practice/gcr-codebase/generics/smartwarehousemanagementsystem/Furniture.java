package smartwarehousemanagementsystem;
class Furniture extends WarehouseItem {
    public Furniture(String name, double price) {
        super(name, price);
    }

    @Override
    public void displayInfo() {
        System.out.println("Furniture: " + getName() + " | Price: " + getPrice());
    }
}

