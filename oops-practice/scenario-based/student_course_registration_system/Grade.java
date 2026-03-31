package student_course_registration_system;

class Grade {
	private String course;
	private String grade;
	public Grade(String course, String grade) {
		this.course = course;
		this.grade = grade;
	}
	public String getCourse() {
		return course;
	}

	public String getGrade() {
		return grade;
	}
}
