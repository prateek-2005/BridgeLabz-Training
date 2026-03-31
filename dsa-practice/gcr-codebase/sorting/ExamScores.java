import java.util.*;
public class ExamScores {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number Of Students: ");
		int n=sc.nextInt();
		int []marks=new int[n];
		System.out.println("Enter Student Marks: ");
		for(int i=0;i<n;i++) {
			marks[i]=sc.nextInt();
		}
		for(int i=0;i<n-1;i++) {
			int index=i;
			for(int j=i+1;j<n;j++) {
				if(marks[j]<marks[index]) {
					index=j;
				}
			}
			int temp=marks[i];
			marks[i]=marks[index];
			marks[index]=temp;
		}
		System.out.println("Sorted Student Marks: ");
		for(int i=0;i<n;i++) {
			System.out.print(marks[i]+" ");
		}
		sc.close();
	}

}
