package hotel_reservation_system;

public class HotelService {

    private Room[] rooms = new Room[5];
    private Reservation[] reservations = new Reservation[5];
    private int roomCount = 0;
    private int reservationCount = 0;

    private PricingStrategy pricing = new SeasonalPricing(true); 
    public void addRoom(Room room) {
        rooms[roomCount++] = room;
        System.out.println("Room added: " + room.getRoomNumber());
    }
    public void bookRoom(Guest guest, int roomNumber, int days)
            throws RoomNotAvailableException {

        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].getRoomNumber() == roomNumber) {

                if (!rooms[i].isAvailable()) {
                    throw new RoomNotAvailableException("Room already booked!");
                }

                rooms[i].checkIn();
                reservations[reservationCount++] =
                        new Reservation(guest, rooms[i], days);

                System.out.println("Room booked for " + guest.getName());
                return;
            }
        }
        System.out.println("Room not found");
    }
    public void checkOut(int roomNumber) {
        for (int i = 0; i < reservationCount; i++) {
            if (reservations[i].getRoom().getRoomNumber() == roomNumber) {

                Reservation r = reservations[i];
                double bill = pricing.calculatePrice(r.getRoom(), r.getDays());

                r.getRoom().checkOut();

                System.out.println("Checkout successful");
                System.out.println("Guest: " + r.getGuest().getName());
                System.out.println("Total Bill: ₹" + bill);
                return;
            }
        }
        System.out.println("Reservation not found");
    }
}
