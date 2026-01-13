package student_course_registration_system;

import java.util.*;

class Student extends Person {
	private ArrayList<String> courses;
	private ArrayList<Grade> grades;
	private static final int maxCourses = 3;

	Student(String name, String id) {
		super(name, id);
		courses = new ArrayList<>();
		grades = new ArrayList<>();
	}

	public void enrollCourse(String course) throws CourseLimitExceededException {
		if (courses.size() >= maxCourses) {
			throw new CourseLimitExceededException("Maximum Courses Enrolled by Student");
		}
		courses.add(course);
		System.out.println("Enrolled in: " + course);
	}

	public void dropCourse(String course) {
		courses.remove(course);
		System.out.println("Dropped Course: " + course);
	}
	public void addGrade(String course, String grade) {
        grades.add(new Grade(course, grade));
    }
	public void viewGrades() {
        System.out.println("Grades Obtained By Student:");
        for (Grade g : grades) {
            System.out.println(g.getCourse() + " : " + g.getGrade());
        }
    }
}
