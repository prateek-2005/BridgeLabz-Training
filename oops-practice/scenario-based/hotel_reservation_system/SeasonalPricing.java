package hotel_reservation_system;

public class SeasonalPricing implements PricingStrategy {

    private boolean isPeakSeason;

    public SeasonalPricing(boolean isPeakSeason) {
        this.isPeakSeason = isPeakSeason;
    }

    @Override
    public double calculatePrice(Room room, int days) {
        double base = room.getBasePrice() * days;

        if (isPeakSeason) {
            return base * 1.2; 
        }
        return base;
    }
}

