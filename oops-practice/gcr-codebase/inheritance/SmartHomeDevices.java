class Device{
    String deviceId;
    String status;
    Device(String deviceId,String status){
        this.deviceId=deviceId;
        this.status=status;
    }
    void displayStatus(){
        System.out.println("Device Id: "+deviceId);
        System.out.println("Device Status: "+status);
        System.out.println();
    }
}
class ThermoStat extends Device{
    String temperatureSetting;
    ThermoStat(String deviceId, String status,String temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting=temperatureSetting;
    }
    void displayStatus() {
        System.out.println("Device Id: "+deviceId);
        System.out.println("Device Status: "+status);
        System.out.println("Temperature Settings: "+temperatureSetting);
        System.out.println();
    }
}
public class SmartHomeDevices {
    public static void main(String[] args) {
        Device device=new Device("D1234","Working");
        ThermoStat thermo=new ThermoStat("D12343","Working","HOT");
        device.displayStatus();
        thermo.displayStatus();
    }
}
