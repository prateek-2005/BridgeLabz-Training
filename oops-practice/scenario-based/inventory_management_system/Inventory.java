package inventory_management_system;

public class Inventory {
	private Product[] products=new Product[10];
	private int count=0;
	private AlertService alertService=new LowStockAlertService();
	private static final int stockLimit=3;
	public void addProduct(Product product) {
		if(count<products.length) {
			products[count]=product;
			count++;
			System.out.println("Product added: "+product.getName());
		}
		else {
			System.out.println("Inventory full.");
		}
	}
	public void updateStock(int productId,int newQuantity) {
		for(int i=0;i<count;i++) {
			if(products[i].getProductId()==productId) {
				products[i].setQuantity(newQuantity);
				System.out.println("Stock Updated for "+products[i].getName());
				if(newQuantity<=stockLimit) {
					alertService.sendAlert(products[i]);
				}
				return;
			}
		}
		System.out.println("Product not found");
	}
	public void checkStock(int productId) throws OutOfStockException{
		for(int i=0;i<count;i++) {
			if(products[i].getProductId()==productId) {
				if(products[i].getQuantity()==0) {
					throw new OutOfStockException(products[i].getName()+" is out of stock");
				}
				System.out.println(products[i].getName() + " stock: " + products[i].getQuantity());
                return;
			}
		}
		System.out.println("Product not found");
	}
}
