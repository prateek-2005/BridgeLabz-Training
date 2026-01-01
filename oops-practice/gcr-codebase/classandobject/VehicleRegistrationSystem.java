class Vehicle {
    String ownerName;
    String vehicleType;
    final String registrationNumber;   
    static double registrationFee = 150.0;
    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    void display() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
            System.out.println();
        }
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Honest raj", "Sedan", "ABC123");
        Vehicle v2 = new Vehicle("Price danish", "SUV", "XYZ789");
        v1.display();
        v2.display();
        Vehicle.updateRegistrationFee(200);
        System.out.println("Updated Registration Fee: 200");
        v1.display();
        v2.display();
    }
}