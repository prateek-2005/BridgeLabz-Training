package hotel_reservation_system;

public class HotelReservationSystem {
	public static void main(String[] args) {
        HotelService hotel = new HotelService();
        hotel.addRoom(new StandardRoom(101));
        hotel.addRoom(new DeluxeRoom(102));
        Guest g1 = new Guest(1, "Rahul");
        try {
            hotel.bookRoom(g1, 101, 2);
            hotel.bookRoom(g1, 101, 1);
        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        hotel.checkOut(101);
    }
}
