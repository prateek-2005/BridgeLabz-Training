abstract class Vehicle {
	private String vehicleNumber;
	private String type;
	private double rentalRate;
	Vehicle(String vehicleNumber, String type, double rentalRate) {
		setVehicleNumber(vehicleNumber);
		setType(type);
		setRentalRate(rentalRate);
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber=vehicleNumber;
	}
	public void setType(String type) {
		this.type=type;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate=rentalRate;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public String getType() {
		return type;
	}
	public double getRentalRate() {
		return rentalRate;
	}

	abstract double calculateRentalCost(int days);
}
interface Insurable {
	double calculateInsurance();
	String getInsuranceDetails();
}
class Car extends Vehicle implements Insurable {
	private String policyNumber;
	Car(String vehicleNumber, String type, double rentalRate, String policyNumber) {
		super(vehicleNumber, type, rentalRate);
		this.policyNumber = policyNumber;
	}
	@Override
	public double calculateRentalCost(int days) {
		return days * getRentalRate();
	}
	@Override
	public double calculateInsurance() {
		return getRentalRate() * 0.18;
	}
	@Override
	public String getInsuranceDetails() {
		return "Car Insurance (Policy: " + policyNumber + ") - 18% of Rental Rate";
	}
}
class Bike extends Vehicle implements Insurable {
	private String policyNumber;
	Bike(String vehicleNumber, String type, double rentalRate, String policyNumber) {
		super(vehicleNumber, type, rentalRate);
		this.policyNumber = policyNumber;
	}
	@Override
	public double calculateRentalCost(int days) {
		return days * getRentalRate();
	}
	@Override
	public double calculateInsurance() {
		return getRentalRate() * 0.15;
	}
	@Override
	public String getInsuranceDetails() {
		return "Bike Insurance (Policy: " + policyNumber + ") - 15% of Rental Rate";
	}
}
class Truck extends Vehicle implements Insurable {
	private String policyNumber;
	Truck(String vehicleNumber, String type, double rentalRate, String policyNumber) {
		super(vehicleNumber, type, rentalRate);
		this.policyNumber = policyNumber;
	}
	@Override
	public double calculateRentalCost(int days) {
		return days * getRentalRate();
	}
	@Override
	public double calculateInsurance() {
		return getRentalRate() * 0.30;
	}
	@Override
	public String getInsuranceDetails() {
		return "Truck Insurance (Policy: " + policyNumber + ") - 30% of Rental Rate";
	}
}
class Display {
	static void display(Vehicle v, int days) {
		System.out.println("Vehicle Type: " + v.getType());
		System.out.println("Vehicle Number: " + v.getVehicleNumber());
		System.out.println("Rental Cost: " + v.calculateRentalCost(days));
		if (v instanceof Insurable) {
			Insurable ins = (Insurable) v;
			System.out.println("Insurance Cost: " + ins.calculateInsurance());
			System.out.println("Insurance Details: " + ins.getInsuranceDetails());
		}
		System.out.println("End Of Invoice");
		System.out.println();
	}
}

public class VehicleRentalSystem {
	public static void main(String[] args) {
		Vehicle v1 = new Car("C874", "Car", 1000, "CAR9852");
		Vehicle v2 = new Bike("B124", "Bike", 750, "BIK9135");
		Vehicle v3 = new Truck("T6633", "Truck", 1500, "TRK1383");
		Display.display(v1, 5);
		Display.display(v2, 5);
		Display.display(v3, 5);
	}
}