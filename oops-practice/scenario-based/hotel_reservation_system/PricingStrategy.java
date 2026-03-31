package hotel_reservation_system;

public interface PricingStrategy {
    double calculatePrice(Room room, int days);
}

