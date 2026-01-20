import java.util.*;
class Book {
	private int id;
	private String title;
	private String author;
	Book(int id,String title,String author) {
		this.id=id;
		this.title=title;
		this.author=author;
	}
	public int getId() {
		return id;
	}
	public String toString() {
		return id+" - "+title+" by "+author;
	}
	@Override
	public boolean equals(Object o) {
		if(this==o) {
			return true;
		}
		if(!(o instanceof Book)) {
			return false;
		}
		Book book=(Book) o;
		return id==book.id;
	}
	public int hashcode() {
		return Objects.hash(id);
	}
}

class Library{
	private HashMap<String,LinkedList<Book>> catalog=new HashMap<>();
	private HashSet<Book> uniqueBooks=new HashSet<>();
	
	
	public void addBook(String genre,Book book) {
		if(uniqueBooks.contains(book)) {
			System.out.println("Duplicate book not allowed: "+book);
			return;
		}
		catalog.putIfAbsent(genre, new LinkedList<>());
		catalog.get(genre).add(book);
		uniqueBooks.add(book);
		
		System.out.println("Book added: "+book);
	}
	public void removeBook(String genre, int bookId) {
	    if (!catalog.containsKey(genre)) {
	        System.out.println("Genre not found");
	        return;
	    }
	    LinkedList<Book> books = catalog.get(genre);
	    Iterator<Book> it = books.iterator();
	    while (it.hasNext()) {
	        Book b = it.next();  
	        if (b.getId() == bookId) {
	            it.remove();      
	            uniqueBooks.remove(b);
	            System.out.println("Book removed: " + b);
	            return;
	        }
	    }

	    System.out.println("Book not found");
	}
	public void displayLibrary() {
		System.out.println("\nLibrary Catalog: ");
		for(String genre:catalog.keySet()) {
			System.out.println("Genre: "+genre);
			for(Book b:catalog.get(genre)) {
				System.out.println("  "+b);
			}
		}
	}
}
public class BookShelf {
	public static void main(String[] args) {
        Library library = new Library();

        library.addBook("Fiction", new Book(1, "Harry Potter", "J.K Rowling"));
        library.addBook("Fiction", new Book(2, "The Hobbit", "Tolkien"));
        library.addBook("Science", new Book(3, "Brief History of Time", "Stephen Hawking"));

        library.addBook("Fiction", new Book(1, "Harry Potter", "J.K Rowling"));

        library.displayLibrary();

        library.removeBook("Fiction", 2);

        library.displayLibrary();
    }
}
