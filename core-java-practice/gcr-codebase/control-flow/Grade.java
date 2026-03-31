import java.util.*;
public class Grade {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int PhysicsMarks=sc.nextInt();
		int ChemistryMarks=sc.nextInt();
		int MathsMarks=sc.nextInt();
		int total=PhysicsMarks+ChemistryMarks+MathsMarks;
		double percentage=(double)(total/3);
		if(percentage>=80) {
			System.out.println("Average Marks "+ percentage+" and Grade: A");
		}
		else if(percentage>=70 && percentage<=79) {
			System.out.println("Average Marks "+ percentage+" and Grade: B");
		}
		else if(percentage>=60 && percentage<=69) {
			System.out.println("Average Marks "+ percentage+" and Grade: C");
		}
		else if(percentage>=50 && percentage<=59) {
			System.out.println("Average Marks "+ percentage+" and Grade: D");
		}
		else if(percentage>=40 && percentage<=49) {
			System.out.println("Average Marks "+ percentage+" and Grade: B");
		}
		else {
			System.out.println("Average Marks "+ percentage+" and Grade: R");
		}
		sc.close();
	}

}
