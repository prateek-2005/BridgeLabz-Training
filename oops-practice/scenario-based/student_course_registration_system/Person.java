package student_course_registration_system;

class Person {
	private String name;
	private String id;
	Person(String name,String id){
		this.id=id;
		this.name=name;
	}
	String getName() {
		return name;
	}
	String getId() {
		return id;
	}
}
