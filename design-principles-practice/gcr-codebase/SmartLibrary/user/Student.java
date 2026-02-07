package user;

public class Student extends User {

	public Student(String name) {
		super(name);
	}

	@Override
	public void borrow() {
		System.out.println(name + " can borrow for 7 days");
	}

}