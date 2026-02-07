package oceanfleet;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VesselUtil util = new VesselUtil();

        System.out.println("Enter the number of vessels to be added");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter vessel details");
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] arr = input.split(":");

            Vessel vessel = new Vessel(
                    arr[0],
                    arr[1],
                    Double.parseDouble(arr[2]),
                    arr[3]
            );

            util.addVesselPerformance(vessel);
        }

        System.out.println("Enter the Vessel Id to check speed");
        String searchId = sc.nextLine();

        Vessel found = util.getVesselById(searchId);
        if (found != null) {
            System.out.println(found.getVesselId() + " | " +
                    found.getVesselName() + " | " +
                    found.getVesselType() + " | " +
                    found.getAverageSpeed() + " knots");
        } else {
            System.out.println("Vessel Id " + searchId + " not found.");
        }

        System.out.println("High performance vessels are");
        List<Vessel> highPerf = util.getHighPerformanceVessels();
        for (Vessel v : highPerf) {
            System.out.println(v.getVesselId() + " | " +
                    v.getVesselName() + " | " +
                    v.getVesselType() + " | " +
                    v.getAverageSpeed() + " knots");
        }
        sc.close();
    }
}
