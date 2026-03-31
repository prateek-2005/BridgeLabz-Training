import java.util.*;
class Student{
	String studentName;
	String rollNumber;
	int marks1;
	int marks2;
	int marks3;
	Student(String studentName,String rollNumber,int marks1,int marks2,int marks3){
		this.studentName=studentName;
		this.rollNumber=rollNumber;
		this.marks1=marks1;
		this.marks2=marks2;
		this.marks3=marks3;
	}
	void display() {
		System.out.println("Student Name: "+studentName);
		System.out.println("Student Roll Number: "+rollNumber);
		System.out.println("Student Marks: ");
		System.out.println("Marks 1: "+marks1);
		System.out.println("Marks 2: "+marks2);
		System.out.println("Marks 3: "+marks3);
	}
	void calculateGrade() {
		int totalMarks=marks1+marks2+marks3;
		int average=(int)totalMarks/3;
		String Grade;
		if(average>=80) {
			Grade="A";
		}
		else if(average>=65 && average<80) {
			Grade="B";
		}
		else if(average>=45 && average<65) {
			Grade="C";
		}
		else {
			Grade="F";
		}
		System.out.println("Grade "+Grade);
	}
}
public class StudentReport {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student Name: ");
		String studentName=sc.nextLine();
		System.out.println("Enter Roll Number: ");
		String rollNumber=sc.nextLine();
		System.out.println("Enter Marks 1: ");
		int marks1=sc.nextInt();
		System.out.println("Enter Marks 2: ");
		int marks2=sc.nextInt();
		System.out.println("Enter Marks 3: ");
		int marks3=sc.nextInt();
		System.out.println();
		Student student=new Student(studentName,rollNumber,marks1,marks2,marks3);
		student.display();
		student.calculateGrade();
		sc.close();
	}

}
