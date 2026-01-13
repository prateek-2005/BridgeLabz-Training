package hotel_reservation_system;

public abstract class Room {
    private int roomNumber;
    private boolean available = true;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void checkIn() {
        available = false;
    }

    public void checkOut() {
        available = true;
    }

    public abstract double getBasePrice();
}

