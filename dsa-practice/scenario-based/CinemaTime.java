import java.util.*;

class InvalidTimeFormatException extends Exception {
	public InvalidTimeFormatException(String message) {
		super(message);
	}
}

class Cinema {
	private final List<String> titles = new ArrayList<>();
	private final List<String> showtimes = new ArrayList<>();

	public void addMovie(String title, String time) throws InvalidTimeFormatException {
		if (!isValidTime(time)) {
			throw new InvalidTimeFormatException("Invalid time format: " + time);
		}

		titles.add(title);
		showtimes.add(time);
		System.out.println("Movie added successfully.");
	}

	public void searchMovie(String keyword) {
		try {
			boolean found = false;

			for (int i = 0; i < titles.size(); i++) {
				if (titles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
					System.out.println(String.format("Found: %s at %s", titles.get(i), showtimes.get(i)));
					found = true;
				}
			}

			if (!found) {
				System.out.println("No movie found with keyword: " + keyword);
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println(" Error while searching movie data.");
		}
	}

	public void displayAllMovies() {
		try {
			if (titles.isEmpty()) {
				System.out.println("No movies available.");
				return;
			}

			System.out.println("\n Movie Schedule:");
			for (int i = 0; i < titles.size(); i++) {
				System.out.println(String.format("%d. %s - %s", i + 1, titles.get(i), showtimes.get(i)));
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println(" Error displaying movies.");
		}
	}

	public void printReport() {
		String[] movieArray = titles.toArray(new String[0]);

		System.out.println("\n Printable Report (Titles Only):");
		for (String movie : movieArray) {
			System.out.println(movie);
		}
	}

	private boolean isValidTime(String time) {
		if (!time.matches("\\d{2}:\\d{2}"))
			return false;

		String[] parts = time.split(":");
		int hour = Integer.parseInt(parts[0]);
		int minute = Integer.parseInt(parts[1]);

		return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
	}
}

public class CinemaTime {
	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		try {
			cinema.addMovie("Avengers", "18:30");
			cinema.addMovie("Inception", "21:00");
			cinema.addMovie("Interstellar", "25:99");
		} catch (InvalidTimeFormatException e) {
			System.out.println(e.getMessage());
		}
		cinema.displayAllMovies();
		System.out.println("\nSearch result:");
		cinema.searchMovie("Incep");
		cinema.printReport();
	}
}
