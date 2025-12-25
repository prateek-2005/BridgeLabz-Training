import java.util.*;
public class StudentVoteChecker {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int []age=new int[10];
		for(int i=0;i<10;i++) {
			age[i]=sc.nextInt();
		}
		for(int i=0;i<10;i++) {
			if(canStudentVote(age[i])) {
				System.out.println("Student with age "+age[i]+" can vote");
			}
			else {
				System.out.println("Student with age "+age[i]+" cannot vote");
			}
		}
		sc.close();
	}
	public static boolean canStudentVote(int age) {
		if(age<0) {
			return false;
		}
		if(age>=18) {
			return true;
		}
		return false;
	}
}
