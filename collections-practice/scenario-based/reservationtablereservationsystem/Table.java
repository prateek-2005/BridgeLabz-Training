package reservationtablereservationsystem;
class Table {
    private int tableNumber;
    private int capacity;
    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }
    public int getTableNumber() {
        return tableNumber;
    }
    public int getCapacity() {
        return capacity;
    }
}
