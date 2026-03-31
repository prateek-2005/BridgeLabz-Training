package smartcheckout;
import java.util.*;
class SmartCheckout {
    private Queue<Customer> queue = new LinkedList<>();
    private HashMap<String, Item> inventory = new HashMap<>();
    public void addItem(String name, double price, int stock) {
        inventory.put(name, new Item(name, price, stock));
    }
    public void addCustomer(Customer customer) {
        queue.offer(customer);
        System.out.println(customer.getName() + " added to checkout queue.");
    }
    public void processNextCustomer() {
        if (queue.isEmpty()) {
            System.out.println("No customers in queue.");
            return;
        }
        Customer customer = queue.poll();
        System.out.println("\nBilling customer: " + customer.getName());
        double total = 0;
        for (Map.Entry<String, Integer> entry : customer.getCart().entrySet()) {
            String itemName = entry.getKey();
            int qty = entry.getValue();
            if (!inventory.containsKey(itemName)) {
                System.out.println(itemName + " not available.");
                continue;
            }
            Item item = inventory.get(itemName);
            if (item.getStock() < qty) {
                System.out.println("Not enough stock for " + itemName);
                continue;
            }
            item.reduceStock(qty);
            double cost = item.getPrice() * qty;
            total += cost;
            System.out.println(itemName + " x" + qty + " = ₹" + cost);
        }
        System.out.println("Total Bill: ₹" + total);
    }
    public void showQueue() {
        System.out.println("\nCustomers in queue:");
        for (Customer c : queue) {
            System.out.println("- " + c.getName());
        }
    }
}
