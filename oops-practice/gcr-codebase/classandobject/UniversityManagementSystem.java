class Student {
	public int rollNumber;
	protected String name;
	private double CGPA;
	public Student(int rollNumber, String name, double CGPA) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.CGPA = CGPA;
	}
	public double getCGPA() {
		return CGPA;
	}
	public void setCGPA(double CGPA) {
		if (CGPA >= 0.0 && CGPA <= 10.0) {
			this.CGPA = CGPA;
		} else {
			System.out.println("Invalid CGPA value. Must be between 0.0 and 10.0");
		}
	}
	public void displayDetails() {
        System.out.println("Student Roll Number: " + rollNumber);
        System.out.println("Student Name: " + name);
        System.out.println("Student CGPA: " + CGPA);
        System.out.println();
    }
}
class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }
    public void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("CGPA: " + getCGPA()); 
        System.out.println();
    }
}


public class UniversityManagementSystem {

	public static void main(String[] args) {
		Student student = new Student(101, "Prateek", 8.2);
        student.displayDetails();
        student.setCGPA(9.0);
        System.out.println("Updated CGPA: " + student.getCGPA());
        student.displayDetails();
        PostgraduateStudent pg1 = new PostgraduateStudent(201, "Bob", 9.2);
        pg1.displayPostgraduateDetails();

	}

}
