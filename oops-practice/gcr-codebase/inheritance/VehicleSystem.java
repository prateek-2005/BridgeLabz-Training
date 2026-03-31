class Vehicle {
    int maxSpeed;
    String model;
    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println();
    }
}
interface Refuelable {
    void refuel();
}
class ElectricVehicle extends Vehicle {
    int batteryCapacity;
    ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }
    void charge() {
        System.out.println("Electric Vehicle");
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println();
    }
}
class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelCapacity;
    PetrolVehicle(int maxSpeed, String model, int fuelCapacity) {
        super(maxSpeed, model);
        this.fuelCapacity = fuelCapacity;
    }
    @Override
    public void refuel() {
        System.out.println("Petrol Vehicle");
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
        System.out.println();
    }
}
public class VehicleSystem {
    public static void main(String[] args) {
        Vehicle v = new Vehicle(180, "Generic Vehicle");
        ElectricVehicle ev = new ElectricVehicle(150, "Tesla Model 3", 75);
        PetrolVehicle pv = new PetrolVehicle(200, "Honda Civic", 50);
        v.displayInfo();
        ev.charge();
        pv.refuel();
    }
}