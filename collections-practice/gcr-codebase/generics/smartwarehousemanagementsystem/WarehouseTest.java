package smartwarehousemanagementsystem;
public class WarehouseTest {
    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 60000));
        electronicsStorage.addItem(new Electronics("Mobile", 25000));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice", 50));
        groceryStorage.addItem(new Groceries("Milk", 30));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 1200));
        furnitureStorage.addItem(new Furniture("Table", 5000));

        System.out.println("---- Electronics ----");
        Storage.displayAllItems(electronicsStorage.getItems());

        System.out.println("\n---- Groceries ----");
        Storage.displayAllItems(groceryStorage.getItems());

        System.out.println("\n---- Furniture ----");
        Storage.displayAllItems(furnitureStorage.getItems());
    }
}

