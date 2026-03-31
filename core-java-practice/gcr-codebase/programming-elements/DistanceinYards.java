import java.util.*;
public class DistanceinYards {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double distanceinfeet= sc.nextDouble();
        double distanceinyards = distanceinfeet / 3;
        double distanceinmiles = distanceinyards / 1760;
        System.out.println("The distance in Feets is "+distanceinfeet+" Yards is "+distanceinyards+" and Miles is "+distanceinmiles);
    }
}
