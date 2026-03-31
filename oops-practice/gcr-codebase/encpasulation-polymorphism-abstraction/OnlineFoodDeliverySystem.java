abstract class FoodItem{
	private String itemName;
	private double price;
	private int quantity;
	FoodItem(String itemName,double price,int quantity){
		setItemName(itemName);
		setPrice(price);
		setQuantity(quantity);
	}
	public void setItemName(String itemName) {
		this.itemName=itemName;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	public String getItemName() {
		return itemName;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getItemDetails() {
		return "Item: "+itemName+" ,Price: "+price+", Quantity: "+quantity;
	}
	abstract double calculateTotalPrice();
}
interface Discountable{
	double applyDiscount(double discount);
	String getDiscountDetails();
}
class VegItem extends FoodItem implements Discountable {
    VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    @Override
    double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
    @Override
    public double applyDiscount(double discountPercent) {
        return calculateTotalPrice() - (calculateTotalPrice() * discountPercent / 100);
    }
    @Override
    public String getDiscountDetails() {
        return "Veg Discount Code" ;
    }
}
class NonVegItem extends FoodItem implements Discountable {
    NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    @Override
    double calculateTotalPrice() {
        return (getPrice() * getQuantity()) * 1.10;
    }
    @Override
    public double applyDiscount(double discountPercent) {
        return calculateTotalPrice() - (calculateTotalPrice() * discountPercent / 100);
    }
    @Override
    public String getDiscountDetails() {
        return "Non-Veg Discount";
    }
}
class Display {
    static void display(FoodItem item, double discountPercent) {
        System.out.println(item.getItemDetails());
        System.out.println("Total Price: " + item.calculateTotalPrice());
        if (item instanceof Discountable) {
            Discountable d = (Discountable) item;
            System.out.println("Price After Discount: " + d.applyDiscount(discountPercent));
            System.out.println("Discount Details: " + d.getDiscountDetails());
        }
        System.out.println("End Of Order\n");
    }
}
 class OnlineFoodDeliverySystem{
	public static void main(String[] args) {
		FoodItem food1 = new VegItem("Butter Panner", 350, 2);
        FoodItem food2 = new NonVegItem("Handi Chicken",500, 3);
        Display.display(food1, 10);
        Display.display(food2, 15); 
	}
}
