class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagementSystem{
    ItemNode head = null;
    ItemNode tail = null;
    int size = 0;

    public void addAtBeginning(ItemNode node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addAtEnd(ItemNode node) {
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addAtSpecific(ItemNode node, int index) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds");
            return;
        }

        if (index == 0) {
            addAtBeginning(node);
            return;
        }

        if (index == size) {
            addAtEnd(node);
            return;
        }

        ItemNode temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public void deleteByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }

        if (head.itemId == itemId) {
            head = head.next;
            size--;
            if (head == null) tail = null;
            return;
        }

        ItemNode current = head;
        while (current.next != null) {
            if (current.next.itemId == itemId) {
                if (current.next == tail) {
                    tail = current;
                }
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }

        System.out.println("Item not found");
    }

    public void updateQuantity(int itemId, int newQuantity) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    public void searchByItemId(int itemId) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println(
                    temp.itemId + "\t" +
                    temp.itemName + "\t" +
                    temp.quantity + "\t" +
                    temp.price
                );
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    public void searchByItemName(String name) {
        ItemNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                System.out.println(
                    temp.itemId + "\t" +
                    temp.itemName + "\t" +
                    temp.quantity + "\t" +
                    temp.price
                );
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Item not found");
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("No items in inventory");
            return;
        }

        ItemNode temp = head;
        while (temp != null) {
            System.out.println(
                temp.itemId + "\t" +
                temp.itemName + "\t" +
                temp.quantity + "\t" +
                temp.price
            );
            temp = temp.next;
        }
    }

    public void totalInventoryValue() {
        double total = 0;
        ItemNode temp = head;

        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: " + total);
    }

    public void sortByName(boolean ascending) {
        for (ItemNode i = head; i != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                if ((ascending && i.itemName.compareToIgnoreCase(j.itemName) > 0) ||
                    (!ascending && i.itemName.compareToIgnoreCase(j.itemName) < 0)) {
                    swapData(i, j);
                }
            }
        }
    }

    public void sortByPrice(boolean ascending) {
        for (ItemNode i = head; i != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                if ((ascending && i.price > j.price) ||
                    (!ascending && i.price < j.price)) {
                    swapData(i, j);
                }
            }
        }
    }

    private void swapData(ItemNode a, ItemNode b) {
        int id = a.itemId;
        String name = a.itemName;
        int qty = a.quantity;
        double price = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = id;
        b.itemName = name;
        b.quantity = qty;
        b.price = price;
    }

    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        inventory.addAtBeginning(new ItemNode(1, "Laptop", 5, 50000));
        inventory.addAtEnd(new ItemNode(2, "Mouse", 20, 500));
        inventory.addAtSpecific(new ItemNode(3, "Keyboard", 10, 1500), 1);

        inventory.display();

        inventory.updateQuantity(2, 30);
        inventory.searchByItemName("Laptop");

        inventory.totalInventoryValue();

        System.out.println("\nSorted by Name (Ascending):");
        inventory.sortByName(true);
        inventory.display();
    }
}

