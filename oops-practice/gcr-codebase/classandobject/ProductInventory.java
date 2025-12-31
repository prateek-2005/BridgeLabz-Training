class Product{
	String productName;
	double price;
	static int totalProducts=0;
	Product(String productName,double price){
		this.productName=productName;
		this.price=price;
		totalProducts++;
	}
	void displayProductDetails() {
		System.out.println("Product Name: "+productName);
		System.out.println("Product Price: "+price);
		System.out.println();
	}
	public static void displayTotalProducts() {
		System.out.println("Total Number Of Products Created: "+totalProducts);
	}
}
public class ProductInventory {

	public static void main(String[] args) {
		Product product=new Product("TV",20000);
		Product product1=new Product("AC",35000);
		Product product2=new Product("Bike",40000);
		product.displayProductDetails();
		product1.displayProductDetails();
		product2.displayProductDetails();
		Product.displayTotalProducts();
	}

}
