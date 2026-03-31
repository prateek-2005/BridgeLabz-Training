import java.util.*;

public class CheckCollinear {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Co-ordinates of the points");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        if (checkUsingSlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear using slope formula");
        } else {
            System.out.println("Points are not collinear using slope formula");
        }

        if (checkUsingArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear using Triangle Area formula");
        } else {
            System.out.println("Points are not collinear using Triangle Area formula");
        }

        sc.close();
    }
    public static boolean checkUsingSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
    	if ((x1 == x2 && y1 == y2) || (x2 == x3 && y2 == y3) || (x1 == x3 && y1 == y3)) {
            return true;
        }
        if (x2 - x1 == 0 || x3 - x2 == 0) {
            return (x1 == x2 && x2 == x3); 
        }
        double slopeAB = (double)(y2 - y1) / (x2 - x1);
        double slopeBC = (double)(y3 - y2) / (x3 - x2);
        return slopeAB == slopeBC;

    }
    public static boolean checkUsingArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }
}