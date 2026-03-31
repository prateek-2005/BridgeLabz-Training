package smartwarehousemanagementsystem;

class Electronics extends WarehouseItem {
    public Electronics(String name, double price) {
        super(name, price);
    }

    @Override
    public void displayInfo() {
        System.out.println("Electronics: " + getName() + " | Price: " + getPrice());
    }
}

