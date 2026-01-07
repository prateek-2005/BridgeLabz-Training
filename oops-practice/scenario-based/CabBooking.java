import java.util.*;
class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String msg) {
        super(msg);
    }
}
class User {
    private int userId;
    private String userName;

    User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getName() {
        return userName;
    }
}
class Driver {
    private int driverId;
    private String driverName;
    private boolean available = true;

    public Driver(int driverId, String driverName) {
        this.driverId = driverId;
        this.driverName = driverName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return driverName;
    }
    public int getId(){
        return driverId;
    }
}
class Ride {
    private User user;
    private Driver driver;
    private double distance;
    private double fare;

    Ride(User user, Driver driver, double distance, double fare) {
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = fare;
    }

    public double getFare() {
        return fare;
    }

    public Driver getDriver() { 
        return driver;
    }
}

interface FareCalculator {
    double calculateFare(double distance);
}
class NormalFareCalculator implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 12.5;
    }
}
class PeakFareCalculator implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 20;
    }
}
class BookRide {
    private List<Driver> drivers = new ArrayList<>();
    private List<Ride> rides = new ArrayList<>();
    public void addDriver(Driver d) {
        drivers.add(d);
    }
    public int getTotalDrivers() {
        return drivers.size();
    }
    public int getAvailableDriversCount() {
        int count = 0;
        for (Driver d : drivers) {
            if (d.isAvailable()) {
                count++;
            }
        }
        return count;
    }
    public int getBusyDriversCount() {
        return getTotalDrivers() - getAvailableDriversCount();
    }
    public int getCurrentUsersCount() {
        return rides.size();
    }

    public Ride bookRide(User user, double distance, FareCalculator fareCalculator)
            throws NoDriverAvailableException {

        Driver assignedDriver = null;

        for (Driver d : drivers) {
            if (d.isAvailable()) {
                assignedDriver = d;
                break;
            }
        }

        if (assignedDriver == null) {
            throw new NoDriverAvailableException("No Driver available for taking ride");
        }

        assignedDriver.setAvailable(false);
        double fare = fareCalculator.calculateFare(distance);

        Ride r = new Ride(user, assignedDriver, distance, fare);
        rides.add(r);
        return r;
    }

    public List<Ride> getHistory() {
        return rides;
    }
}

public class CabBooking {
    public static void main(String[] args) {
        BookRide booked = new BookRide();
        booked.addDriver(new Driver(1, "Dipanshu"));
        booked.addDriver(new Driver(2, "Ayush"));
        
        System.out.println("Before Booking:");
        System.out.println("Available Drivers: " + booked.getAvailableDriversCount());
        System.out.println("Current Users: " + booked.getCurrentUsersCount());

        User user = new User(202, "Prateek");
        FareCalculator fare = new PeakFareCalculator();
        try {
            Ride ride = booked.bookRide(user, 10, fare);

            System.out.println("\nRide booked for: " + user.getName());
            System.out.println("Driver Assigned: " + ride.getDriver().getName());
            System.out.println("Driver ID: " + ride.getDriver().getId());
            System.out.println("Fare: ₹" + ride.getFare());

            System.out.println("\nAfter Booking:");
            System.out.println("Available Drivers: " + booked.getAvailableDriversCount());
            System.out.println("Busy Drivers: " + booked.getBusyDriversCount());
            System.out.println("Current Users: " + booked.getCurrentUsersCount());
        }
        catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
