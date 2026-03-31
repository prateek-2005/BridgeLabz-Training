import java.util.*;
public class HeightConvesion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int heightincm=sc.nextInt();
        double heightinInches=heightincm/2.54;
        double feet=heightinInches/12;
        double inches=heightinInches%12;
        System.out.println("Your Height in cm is "+heightincm+" while in feet is "+feet+" and inches is "+inches);
    }
}
