package student_course_registration_system;

public class StudentCourseRegistrationSystem {

	public static void main(String[] args) {
		Student s=new Student("Prateek","S512");
		Registration reg=new Registration();
		reg.register(s,"Java");
		reg.register(s, "CSharp");
		reg.register(s, "Pyhton");
		reg.register(s, "c++");
		reg.drop(s, "Pyhton");
		s.addGrade("Java","A+");
		s.addGrade("CSharp","A+");
		s.viewGrades();
	}

}
