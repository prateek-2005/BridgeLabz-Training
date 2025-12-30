import java.util.*;
class MobilePhone{
	String brand;
	String model;
	double price;
	MobilePhone(String brand,String model,double price){
		this.brand=brand;
		this.model=model;
		this.price=price;
	}
	void Display() {
		System.out.println("Brand Of Mobile: "+brand);
		System.out.println("Model Of Mobile: "+model);
		System.out.println("Price Of Mobile: "+price);
	}
}
public class MobilePhoneDetails {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Brand: ");
		String brand=sc.nextLine();
		System.out.println("Enter Model:  ");
		String model=sc.nextLine();
		System.out.println("Enter Price: ");
		double price=sc.nextDouble();
		MobilePhone phone=new MobilePhone(brand,model,price);
		phone.Display();
		sc.close();
	}

}
