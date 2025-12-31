class CarRental{
	String customerName;
	String carModel;
	int rentalDays;
	CarRental(String customerName,String carModel,int rentalDays){
		this.customerName=customerName;
		this.carModel=carModel;
		this.rentalDays=rentalDays;
	}
	int calculateCost() {
		return 500*rentalDays;
	}
	void Display() {
		System.out.println("Customer Name: "+customerName);
		System.out.println("Car Model: "+carModel);
		System.out.println("Number of Days Rented: "+rentalDays);
		System.out.println("Total Cost of Car Rental: "+calculateCost());
	}
}
public class CarRentalSystem {

	public static void main(String[] args) {
		CarRental car=new CarRental("Prateek","SUV",5);
		car.Display();
		CarRental car1=new CarRental("AMit","Sedan",3);
		car1.Display();
	}

}
