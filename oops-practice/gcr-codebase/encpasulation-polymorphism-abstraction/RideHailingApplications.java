abstract class Vehicle {
	private String vehicleId;
	private String driverName;
	private double ratePerKm;

	Vehicle(String vehicleId, String driverName, double ratePerKm) {
		setVehicleId(vehicleId);
		setDriverName(driverName);
		setRatePerKm(ratePerKm);
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId=vehicleId;
	}
	
	public void setDriverName(String driverName) {
		this.driverName=driverName;
	}
	
	public void setRatePerKm(double ratePerKm) {
		this.ratePerKm=ratePerKm;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public String getDriverName() {
		return driverName;
	}

	public double getRatePerKm() {
		return ratePerKm;
	}

	public String getVehicleDetails() {
		return "Vehicle ID: " + vehicleId + ", Driver: " + getDriverName() + ", Rate/Km: " + ratePerKm;
	}

	abstract double calculateFare(double distance);
}

interface GPS {
	String getCurrentLocation();
	void updateLocation(String location);
}

class Car extends Vehicle implements GPS {
	private String currentLocation;
	Car(String vehicleId, String driverName, double ratePerKm) {
		super(vehicleId, driverName, ratePerKm);
	}

	@Override
	double calculateFare(double distance) {
		return distance * getRatePerKm();
	}

	@Override
	public String getCurrentLocation() {
		return currentLocation != null ? currentLocation : "Unknown";
	}

	@Override
	public void updateLocation(String location) {
		this.currentLocation = location;
	}
}

class Bike extends Vehicle implements GPS {
	private String currentLocation;

	Bike(String vehicleId, String driverName, double ratePerKm) {
		super(vehicleId, driverName, ratePerKm);
	}

	@Override
	double calculateFare(double distance) {
		return distance * getRatePerKm() * 0.8;
	}

	@Override
	public String getCurrentLocation() {
		return currentLocation != null ? currentLocation : "Unknown";
	}

	@Override
	public void updateLocation(String location) {
		this.currentLocation = location;
	}
}

class Auto extends Vehicle implements GPS {
	private String currentLocation;

	Auto(String vehicleId, String driverName, double ratePerKm) {
		super(vehicleId, driverName, ratePerKm);
	}

	@Override
	double calculateFare(double distance) {
		return distance * getRatePerKm() * 1.2;
	}

	@Override
	public String getCurrentLocation() {
		return currentLocation != null ? currentLocation : "Unknown";
	}

	@Override
	public void updateLocation(String location) {
		this.currentLocation = location;
	}
}

class Display {
	static void display(Vehicle v, double distance) {
		System.out.println(v.getVehicleDetails());
		System.out.println("Fare for " + distance + " km: " + v.calculateFare(distance));
		if (v instanceof GPS) {
			GPS gps = (GPS) v;
			System.out.println("Current Location: " + gps.getCurrentLocation());
		}
		System.out.println("End Of Ride\n");
	}
}

public class RideHailingApplications {
	public static void main(String[] args) {
		Vehicle v1 = new Car("C101", "Alice", 15);
		Vehicle v2 = new Bike("B202", "Bob", 10);
		Vehicle v3 = new Auto("A303", "Charlie", 12);
		((GPS) v1).updateLocation("Downtown");
		((GPS) v2).updateLocation("City Mall");
		((GPS) v3).updateLocation("Railway Station");
		Display.display(v1, 10);
		Display.display(v2, 8);
		Display.display(v3, 12);
	}
}