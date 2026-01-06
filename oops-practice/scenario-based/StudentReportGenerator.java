import java.util.*;
class InvalidMarkException extends Exception{
	InvalidMarkException(String msg){
		super(msg);
	}
}
class Student{
	String name;
	String []subjects;
	int []marks;
	Student(String name,String []subjects,int []marks){
		this.name=name;
		this.subjects=subjects;
		this.marks=marks;
	}
	float calculateAverage() {
		int sum=0;
		for(int i=0;i<marks.length;i++) {
			sum+=marks[i];
		}
		return (float)sum/marks.length;
	}
	char assignGrade(float avg) {
		if(avg>=90) {
			return 'A';
		}
		else if(avg>=75) {
			return 'B';
		}
		else if(avg>=60) {
			return 'C';
		}
		else {
			return 'D';
		}
	}
	void displayReport() {
		System.out.println("\n-------Report Card ------");
		System.out.println("Student name: "+name);
		for(int i=0;i<subjects.length;i++) {
			System.out.println(subjects[i]+" : "+marks[i]);
		}
		float avg=calculateAverage();
		System.out.println("Average Marks: "+avg);
		System.out.println("Grade: "+assignGrade(avg));
	}
}
public class StudentReportGenerator {
	private static Student addStudent(Scanner sc) throws InvalidMarkException{
		System.out.print("Enter Student name: ");
		String name=sc.nextLine();
		System.out.print("Enter number of subjects: ");
		int n=sc.nextInt();
		sc.nextLine();
		String []subjects=new String[n];
		int []marks=new int[n];
		for(int i=0;i<n;i++) {
			System.out.print("Enter subject: "+(i+1)+": ");
			subjects[i]=sc.nextLine();
			System.out.print("Enter marks: ");
			marks[i]=sc.nextInt();
			sc.nextLine();
			if(marks[i]<0 || marks[i]>100) {
				throw new InvalidMarkException("Invalid marks");
			}
		}
		return new Student(name,subjects,marks);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<Student> students=new ArrayList<Student>();
		System.out.println("Enter number of students: ");
		int count=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<count;i++) {
			try {
				System.out.println("Enter details for student: "+(i+1));
				Student s=addStudent(sc);
				students.add(s);
			}
			catch(InvalidMarkException e) {
				System.out.println(e.getMessage());
				i--;
			}
		}
		for(int i=0;i<students.size();i++) {
			students.get(i).displayReport();
		}
		
	}

}
