package inventory_management_system;
public class Product {
	private int productId;
	private String name;
	private int quantity;
	Product(int productId,String name,int quantity){
		this.productId=productId;
		this.name=name;
		this.quantity=quantity;
	}
	public int getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
}
