package inventory_management_system;

public class InventoryManagementSystem {

	public static void main(String[] args) {
		Inventory inventory=new Inventory();
		Product p1=new Product(101,"Mobile",20);
		Product p2=new Product(102,"Watch",3);
		inventory.addProduct(p1);
		inventory.addProduct(p2);
		try {
            inventory.checkStock(101);
            inventory.checkStock(102);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
		inventory.updateStock(102, 2);
		try {
            inventory.checkStock(102);   
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
	}

}
