package factory;

import user.Faculty;
import user.Librarian;
import user.Student;
import user.User;

public class UserFactory {
	public static User createUser(String role, String name) {
		switch (role.toLowerCase()) {
		case "student":
			return new Student(name);

		case "faculty":
			return new Faculty(name);

		case "librarian":
			return new Librarian(name);

		default:
			throw new IllegalArgumentException("Invalid role: " + role);
		}
	}
}