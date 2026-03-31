package user;

public class Librarian extends User {

	public Librarian(String name) {
		super(name);
	}

	@Override
	public void borrow() {
		System.out.println(name + " manages inventory only");

	}

}