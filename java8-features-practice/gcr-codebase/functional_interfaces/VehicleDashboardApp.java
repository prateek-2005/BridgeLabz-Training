package functional_interfaces;
interface VehicleDashboard {

    void displaySpeed(int speed);

    default void displayBatteryPercentage() {
        System.out.println("Battery information not available for this vehicle");
    }
}

class Car1 implements VehicleDashboard {
    public void displaySpeed(int speed) {
        System.out.println("Car speed: " + speed + " km/h");
    }
}

class Bike1 implements VehicleDashboard {
    public void displaySpeed(int speed) {
        System.out.println("Bike speed: " + speed + " km/h");
    }
}

class ElectricCar implements VehicleDashboard {
    public void displaySpeed(int speed) {
        System.out.println("Electric Car speed: " + speed + " km/h");
    }

    public void displayBatteryPercentage() {
        System.out.println("Battery level: 85%");
    }
}

public class VehicleDashboardApp {

    public static void main(String[] args) {

        VehicleDashboard v1 = new Car1();
        VehicleDashboard v2 = new Bike1();
        VehicleDashboard v3 = new ElectricCar();

        v1.displaySpeed(80);
        v1.displayBatteryPercentage();

        System.out.println();

        v2.displaySpeed(60);
        v2.displayBatteryPercentage();

        System.out.println();

        v3.displaySpeed(100);
        v3.displayBatteryPercentage();
    }
}

