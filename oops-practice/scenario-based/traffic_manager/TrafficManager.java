package traffic_manager;

public class TrafficManager {
    public static void main(String[] args) {

        Roundabout roundabout = new Roundabout();
        WaitingQueue queue = new WaitingQueue(3);
        queue.enqueue("Car-1");
        queue.enqueue("Car-2");
        queue.enqueue("Car-3");
        queue.enqueue("Car-4");  
        String car = queue.dequeue();
        if (car != null) roundabout.addVehicle(car);

        car = queue.dequeue();
        if (car != null) {
        	roundabout.addVehicle(car);
        }

        roundabout.display();
        roundabout.removeVehicle();
        roundabout.display();
    }
}
