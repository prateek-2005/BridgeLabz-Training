package aerovigil;
import java.util.Scanner;
public class UserInterface {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FlightUtil util = new FlightUtil();

		try {
			System.out.println("Enter flight details");
			String input = sc.nextLine();

			String[] details = input.split(":");

			String flightNumber = details[0];
			String flightName = details[1];
			int passengerCount = Integer.parseInt(details[2]);
			double currentFuelLevel = Double.parseDouble(details[3]);

			util.validateFlightNumber(flightNumber);
			util.validateFlightName(flightName);
			util.validatePassengerCount(passengerCount, flightName);

			double fuelRequired = util.calculateFuelToFillTank(flightName, currentFuelLevel);

			System.out.println("Fuel required to fill the tank: " + fuelRequired + " liters");

		} catch (InvalidFlightException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
