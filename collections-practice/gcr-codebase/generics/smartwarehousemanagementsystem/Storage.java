package smartwarehousemanagementsystem;
import java.util.*;
class Storage<T extends WarehouseItem> {

    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayInfo();
        }
    }
}

