package app;

import book.Book;
import catalog.LibraryCatalog;
import factory.UserFactory;
import user.User;

public class LibraryApp {

	public static void main(String[] args) {
		LibraryCatalog catalog = LibraryCatalog.getInstance();

		User student = UserFactory.createUser("student", "Prateek");
		User faculty = UserFactory.createUser("faculty", "Dr Rao");

		catalog.addObserver(student);
		catalog.addObserver(faculty);

		Book book1 = new Book.Builder("Data Structures").addAuthor("Cormen").edition("3rd").genre("Computer Science")
				.publisher("MIT Press").build();

		Book book2 = new Book.Builder("Operating Systems").addAuthor("Galvin").genre("Systems").build();

		catalog.addBook(book1);
		catalog.addBook(book2);

		catalog.showBooks();

		student.borrow();
		faculty.borrow();
	}
}