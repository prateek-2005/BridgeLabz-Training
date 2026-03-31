package user;

import observer.Observer;

public abstract class User implements Observer {

	protected String name;

	public User(String name) {
		this.name = name;
	}

	public abstract void borrow();

	@Override
	public void update(String message) {
		System.out.println(name + " received notification -> " + message);

	}

}