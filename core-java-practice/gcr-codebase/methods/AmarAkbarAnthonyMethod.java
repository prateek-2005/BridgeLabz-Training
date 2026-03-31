import java.util.*;
public class AmarAkbarAnthonyMethod {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Age Of Three:");
		int []Age=new int[3];
		for(int i=0;i<3;i++) {
			Age[i]=sc.nextInt();
		}
		System.out.println("Enter Height Of Three:");
		int []Height=new int[3];
		for(int i=0;i<3;i++) {
			Height[i]=sc.nextInt();
		}
		System.out.println("Youngest Age Is: "+Youngest(Age));
		System.out.println("Tallest Height Is: "+Tallest(Height));
		sc.close();
	}
	public static int Youngest(int []Age) {
		int youngest=0;
		if(Age[0]<=Age[1] && Age[0]<=Age[2]) {
			youngest=Age[0];
		}
		else if(Age[1]<=Age[0] && Age[1]<=Age[2]) {
			youngest=Age[1];
		}
		else {
			youngest=Age[2];
		}
		return youngest;
	}
	public static int Tallest(int []Height) {
		int tallest=0;
		if(Height[0]>=Height[1] && Height[0]>=Height[2]) {
			tallest=Height[0];
		}
		else if(Height[1]>=Height[0] && Height[1]>=Height[2]) {
			tallest=Height[1];
		}
		else {
			tallest=Height[2];
		}
		return tallest;
	}
}
