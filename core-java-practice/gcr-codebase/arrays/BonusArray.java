import java.util.*;
public class BonusArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double [][] OldSalary=new double[10][2];
		for(int i=0;i<10;i++) {
			for(int j=0;j<2;j++) {
				if(OldSalary[i][1]<0 || OldSalary[i][1]<0) {
					System.out.println("Invalid Input");
					break;
				}
				OldSalary[i][j]=sc.nextInt();//OldSalary[i][0]->Salary OldSalary[i][1]->YearsOfService
			}
		}
		double [][]NewSalary=new double[10][3];
		for(int i=0;i<10;i++) {
			NewSalary[i][0]=OldSalary[i][0];//NewSalary[i][0]->OldSalary;
			if(OldSalary[i][1]<5) {
				NewSalary[i][1]=0.02*OldSalary[i][0];
			}
			else {
				NewSalary[i][1]=0.05*OldSalary[i][0];
			}
			NewSalary[i][2]=NewSalary[i][0]+NewSalary[i][1];
		}
		System.out.println("Old Salary         Bonus             New Salary");
		for(int i=0;i<10;i++) {
			System.out.println(NewSalary[i][0]+"            "+NewSalary[i][1]+"           "+NewSalary[i][2]);
		}
		sc.close();
	}

}
