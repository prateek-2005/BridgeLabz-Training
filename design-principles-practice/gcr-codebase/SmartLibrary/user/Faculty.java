package user;

public class Faculty extends User {

	public Faculty(String name) {
		super(name);
	}

	@Override
	public void borrow() {
		System.out.println(name + " can borrow for 30 days");

	}

}