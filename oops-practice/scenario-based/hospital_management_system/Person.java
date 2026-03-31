package hospital_management_system;

public class Person {
	private int id;
	private String name;
	Person(int id,String name){
		this.id=id;
		this.name=name;
	}
	int getId() {
		return id;
	}
	String getName() {
		return name;
	}
}
