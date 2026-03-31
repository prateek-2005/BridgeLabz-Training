package Set3;
import java.util.*;

abstract class Festival {

    String name;
    String location;
    String date;

    Festival(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    abstract void displayDetails();
}

class MusicFestival extends Festival {

    String headliner;
    String genre;
    int ticketPrice;

    MusicFestival(String name, String location, String date,
                  String headliner, String genre, int ticketPrice) {

        super(name, location, date);
        this.headliner = headliner;
        this.genre = genre;
        this.ticketPrice = ticketPrice;
    }

    void displayDetails() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Headliner: " + headliner);
        System.out.println("Music Genre: " + genre);
        System.out.println("Ticket Price: " + ticketPrice);
    }
}

class FoodFestival extends Festival {

    String cuisine;
    int numStalls;
    int entryFee;

    FoodFestival(String name, String location, String date,
                 String cuisine, int numStalls, int entryFee) {

        super(name, location, date);
        this.cuisine = cuisine;
        this.numStalls = numStalls;
        this.entryFee = entryFee;
    }

    void displayDetails() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Number of Stalls: " + numStalls);
        System.out.println("Entry Fee: " + entryFee);
    }
}

class ArtFestival extends Festival {

    String artType;
    int numArtists;
    int exhibitionFee;

    ArtFestival(String name, String location, String date,
                String artType, int numArtists, int exhibitionFee) {

        super(name, location, date);
        this.artType = artType;
        this.numArtists = numArtists;
        this.exhibitionFee = exhibitionFee;
    }

    void displayDetails() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Art Type: " + artType);
        System.out.println("Number of Artists: " + numArtists);
        System.out.println("Exhibition Fee: " + exhibitionFee);
    }
}

class FestivalManager {

    private Map<String, Festival> festivals = new HashMap<>();

    public void addFestival(String type, String[] data) {

        if (type.equals("MUSIC")) {

            festivals.put(data[0], new MusicFestival(
                    data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5])
            ));

        } else if (type.equals("FOOD")) {

            festivals.put(data[0], new FoodFestival(
                    data[0], data[1], data[2], data[3],
                    Integer.parseInt(data[4]), Integer.parseInt(data[5])
            ));

        } else if (type.equals("ART")) {

            festivals.put(data[0], new ArtFestival(
                    data[0], data[1], data[2], data[3],
                    Integer.parseInt(data[4]), Integer.parseInt(data[5])
            ));
        }
    }

    public void displayDetails(String name) {

        if (festivals.containsKey(name)) {
            festivals.get(name).displayDetails();
        }
    }
}

public class EventPlannerFestivalManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FestivalManager manager = new FestivalManager();

        while (true) {

            String input = sc.nextLine();

            if (input.equals("EXIT"))
                break;

            String[] parts = input.split(" ");

            if (parts[0].equals("ADD_FESTIVAL")) {

                String type = parts[1];

                String[] data = Arrays.copyOfRange(parts, 2, parts.length);

                manager.addFestival(type, data);

            } else if (parts[0].equals("DISPLAY_DETAILS")) {

                manager.displayDetails(parts[1]);
            }
        }
        sc.close();
    }
}