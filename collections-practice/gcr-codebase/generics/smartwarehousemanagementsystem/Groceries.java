package smartwarehousemanagementsystem;

class Groceries extends WarehouseItem {
    public Groceries(String name, double price) {
        super(name, price);
    }

    @Override
    public void displayInfo() {
        System.out.println("Groceries: " + getName() + " | Price: " + getPrice());
    }
}

