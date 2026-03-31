import java.util.*;
public class MarksArray2D {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [][]marks=new int[n][3];
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
				marks[i][j]=sc.nextInt();
			}
		}
		int []TotalMarks=new int[n];
		for(int i=0;i<n;i++) {
			TotalMarks[i]=marks[i][0]+marks[i][1]+marks[i][2];
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
