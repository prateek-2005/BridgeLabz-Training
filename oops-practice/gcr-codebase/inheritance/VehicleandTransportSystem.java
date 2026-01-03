class Vehicle{
    double maxSpeed;
    String fuelType;
    Vehicle(double maxSpeed,String fuelType){
        this.fuelType=fuelType;
        this.maxSpeed=maxSpeed;
    }
    void displayInfo(){
        System.out.println("Vehicle");
        System.out.println("Max Speed: "+maxSpeed);
        System.out.println("Fuel Type: "+fuelType);
    }
}
class Car extends Vehicle {
    int seatCapacity;
    Car(double maxSpeed, String fuelType,int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity=seatCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("Car");
        System.out.println("Max Speed: "+maxSpeed);
        System.out.println("Fuel Type: "+fuelType);
        System.out.print("Seat Capacity: "+seatCapacity);
        System.out.println();
    }
}
class Truck extends Vehicle {
    int numberOfTyres;
    Truck(double maxSpeed, String fuelType,int numberOfTyres) {
        super(maxSpeed, fuelType);
        this.numberOfTyres=numberOfTyres;
    }
    void displayInfo() {
        System.out.println("Truck");
        System.out.println("Max Speed: "+maxSpeed);
        System.out.println("Fuel Type: "+fuelType);
        System.out.println("Number Of Tyres: "+numberOfTyres);
        System.out.println();
    }
}
class MotorCycle extends Vehicle {
    int bikePower;
    MotorCycle(double maxSpeed, String fuelType,int bikePower) {
        super(maxSpeed, fuelType);
        this.bikePower=bikePower;
    }
    void displayInfo() {
        System.out.println("MotorCycle");
        System.out.println("Max Speed: "+maxSpeed);
        System.out.println("Fuel Type: "+fuelType);
        System.out.println("Bike Power in cc"+bikePower);
        System.out.println();
    }
}

public class VehicleandTransportSystem {
    public static void main(String[] args) {
        Vehicle []ans=new Vehicle[3];
        Car car=new Car(160,"Diesel",6);
        Truck truck=new Truck(140,"Diesel",16);
        MotorCycle bike=new MotorCycle(200,"Petrol",180);
        ans[0]=car;
        ans[1]=truck;
        ans[2]=bike;
        for(int i=0;i<3;i++){
            ans[i].displayInfo();
        }
    }
}
