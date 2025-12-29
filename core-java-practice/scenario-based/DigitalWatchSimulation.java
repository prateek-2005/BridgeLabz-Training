public class DigitalWatchSimulation {
    public static void main(String[] args) {
        for (int hour = 0; hour < 24; hour++) {
            if (hour == 13) {
            	System.out.println("It's Power Cut Time");
                break;
            }
            for (int minute = 0; minute < 60; minute++) {
                System.out.printf("%02d:%02d%n", hour, minute);
            }
        }
    }
}