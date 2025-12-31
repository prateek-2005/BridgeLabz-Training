class Vehicle{
	String ownerName;
	String vehicleType;
	Vehicle(String ownerName, String vehicleType){
		this.ownerName=ownerName;
		this.vehicleType=vehicleType;
	}
	static int registrationFee=500;
	void displayVehicleDetails() {
		System.out.println("Owner Name: "+ownerName);
		System.out.println("Vehicle Type: "+vehicleType);
		System.out.println("Registation Fee: "+registrationFee);
		System.out.println();
	}
    static void updateRegistrationFee(int fee) {
		registrationFee=fee;
		System.out.println("Registation Fee Updated To: "+registrationFee);
	}
}
public class VehicleRegistration {

	public static void main(String[] args) {
		Vehicle v1=new Vehicle("Prateek","Car");
		Vehicle v2=new Vehicle("Sumit","Bike");
		v1.displayVehicleDetails();
		v2.displayVehicleDetails();
		Vehicle.updateRegistrationFee(1000);
		v1.displayVehicleDetails();
		v2.displayVehicleDetails();
	}

}
