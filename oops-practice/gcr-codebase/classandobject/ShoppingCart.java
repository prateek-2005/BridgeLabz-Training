import java.util.*;
class ClassItem{
	String itemName;
	double price;
	int quantity;
	ClassItem(String itemName,double price,int quantity){
		this.itemName=itemName;
		this.price=price;
		this.quantity=quantity;
	}
	void addItem(int quantity) {
        this.quantity += quantity;
        System.out.println("Added " + quantity + " of " + itemName + " to the cart.");
    }
    void removeItem(int quantity) {
        if (quantity <= this.quantity) {
            this.quantity -= quantity;
            System.out.println("Removed " + quantity + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove more items");
        }
    }
    void displayTotalCost() {
        double totalCost = this.price * this.quantity;
        System.out.println("Total cost: $" + totalCost);
    }
    void displayItem() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }
}
public class ShoppingCart {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Item Name: ");
		String itemName=sc.nextLine();
		System.out.println("Enter Price ");
		double price=sc.nextDouble();
		System.out.println("Enter Quantity: ");
		int quantity=sc.nextInt();
		ClassItem item=new ClassItem(itemName,price,quantity);
		item.displayItem();
		System.out.println("Quantity To Be Added: ");
		int add=sc.nextInt();
		item.addItem(add);
		System.out.println("Quantity To Be Removed: ");
		int remove=sc.nextInt();
		item.removeItem(remove);
		item.displayTotalCost();
		sc.close();
	}

}
