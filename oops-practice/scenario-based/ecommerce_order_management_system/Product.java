package ecommerce_order_management_system;

class Product {
	private String productId;
	private String productName;
	private int quantity;
	double price;
	Product(String productId,String productName,int quantity,double price){
		this.productId=productId;
		this.productName=productName;
		this.quantity=quantity;
		this.price=price;
	}
	String getName() {
		return productName;
	}
	double getPrice() {
		return price;
	}
	int getQuantity() {
		return quantity;
	}
	void displayProduct() {
		System.out.println("Product Id: "+productId+",Product Name: "+productName+", Price: "+price);
	} 
}
