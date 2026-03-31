import java.util.*;
public class MarksArray {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		int []physics=new int[n];
		int []chemistry=new int[n];
		int []maths=new int[n];

		System.out.println("Enter Physics Marks:");
		for(int i=0;i<n;i++) {
			physics[i]=sc.nextInt();
		}

		System.out.println("Enter Chemistry Marks:");
		for(int i=0;i<n;i++) {
			chemistry[i]=sc.nextInt();
		}

		System.out.println("Enter Maths Marks:");
		for(int i=0;i<n;i++) {
			maths[i]=sc.nextInt();
		}

		int []TotalMarks=new int[n];
		for(int i=0;i<n;i++) {
			TotalMarks[i]=physics[i]+chemistry[i]+maths[i];
		}

		double []Percentage=new double[n];
		for(int i=0;i<n;i++) {
			Percentage[i]=TotalMarks[i]/3.0;
		}

		char []Grade=new char[n];
		for(int i=0;i<n;i++) {
			if (Percentage[i] >= 80) {
		        Grade[i] = 'A';
		    }
		    else if (Percentage[i] >= 70 && Percentage[i] <= 79) {
		        Grade[i] = 'B';
		    }
		    else if (Percentage[i] >= 60 && Percentage[i] <= 69) {
		        Grade[i] = 'C';
		    }
		    else if (Percentage[i] >= 50 && Percentage[i] <= 59) {
		        Grade[i] = 'D';
		    }
		    else if (Percentage[i] >= 40 && Percentage[i] <= 49) {
		        Grade[i] = 'E';   
		    }
		    else {
		        Grade[i] = 'R';   
		    }
		}

		System.out.println("Total Marks    Percentage     Grades");
		for(int i=0;i<n;i++) {
			System.out.println(TotalMarks[i]+"    "+Percentage[i]+"     "+Grade[i]);
		}

		sc.close();
	}
}
