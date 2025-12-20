import java.util.*;
public class CoffeeCounterChronicles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Coffee Type          Price Chart");
		System.out.println("Expresso              150");
		System.out.println("Cappuccino            160");
		System.out.println("Latte                 170");
		System.out.println();
		
		System.out.println("Which coffee do you like:");
		String coffeeType = sc.next();
		System.out.println("What Quantity do you want");
		int quantity = sc.nextInt();
        int price = 0;
		switch(coffeeType) {
		    case "Expresso":
		    	price = 150;
		    	break;
		    case "Cappuccino":
		    	price = 160;
		    	break;
		    case "Latte":
		    	price = 170; 
		    	break;
		    default:
		    	System.out.println("This coffee is not available");
		}
		int QuantityPrice= price*quantity;
		double gst = QuantityPrice*0.05;
		double total=QuantityPrice+gst;
		System.out.println("Amount to be paid: "+total);
		sc.close();
	}
}
