import java.util.*;
class Item{
	String itemCode;
	String itemName;
	double price;
	Item(String itemCode,String itemName,double price){
		this.itemCode=itemCode;
		this.itemName=itemName;
		this.price=price;
	}
	void Display() {
		System.out.println("ItemCode: "+itemCode);
		System.out.println("ItemName: "+itemName);
		System.out.println("Price: "+price);
	}
	void CalculatePrice(int n) {
		double totalPrice=n*price;
		System.out.println("Total Price: "+totalPrice);
	}
}
public class TrackInventory {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Item Code: ");
		String itemCode=sc.nextLine();
		System.out.println("Enter Item Name: ");
		String itemName=sc.nextLine();
		System.out.println("Enter Price: ");
		double price=sc.nextDouble();
		System.out.println();
		Item item=new Item(itemCode,itemName,price);
		item.Display();
		System.out.println("Enter Number Of Quantity: ");
		int quantity=sc.nextInt();
		item.CalculatePrice(quantity);
		sc.close();
	}

}
