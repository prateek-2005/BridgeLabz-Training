import java.util.*;
public class StudentMarks {

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
			boolean swap=true;
			for(int j=0;j<n-i-1;j++) {
				if(marks[j]>marks[j+1]) {
					int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swap = true;
				}
			}
			if(!swap) {
				break;
			}
		}
		System.out.println("Sorted Student Marks: ");
		for(int i=0;i<n;i++) {
			System.out.print(marks[i]+" ");
		}
		sc.close();
	}

}
