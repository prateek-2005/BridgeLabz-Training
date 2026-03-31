package reservationtablereservationsystem;
import java.util.*;
class RestaurantService {
    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();
    public void addTable(int tableNumber, int capacity) {
        tables.put(tableNumber, new Table(tableNumber, capacity));
    }
    public void reserveTable(String customerName, int tableNumber, String timeSlot)throws TableAlreadyReservedException {
        for (Reservation r : reservations) {
            if (r.getTableNumber() == tableNumber &&
                r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                throw new TableAlreadyReservedException(
                    "Table " + tableNumber + " already reserved for " + timeSlot
                );
            }
        }
        reservations.add(new Reservation(customerName, tableNumber, timeSlot));
        System.out.println("Reservation successful for " + customerName);
    }
    public void cancelReservation(String customerName) {
        reservations.removeIf(r -> r.getCustomerName().equalsIgnoreCase(customerName));
        System.out.println("Reservation cancelled for " + customerName);
    }
    public void showAvailableTables(String timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");
        for (int tableNo : tables.keySet()) {
            boolean booked = false;
            for (Reservation r : reservations) {
                if (r.getTableNumber() == tableNo &&
                    r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                    booked = true;
                    break;
                }
            }
            if (!booked) {
                System.out.println("Table " + tableNo);
            }
        }
    }
}
