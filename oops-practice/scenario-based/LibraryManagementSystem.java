import java.util.*;
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}
public class LibraryManagementSystem {
    static class Book {
        String title;
        String author;
        boolean available;
        Book(String title, String author, boolean available) {
            this.title = title;
            this.author = author;
            this.available = available;
        }
    }
    static List<Book> books = new ArrayList<>();
    static void addBooks(Book[] bookArray) {
        for (Book b : bookArray) {
            books.add(b);
        }
    }
    static void displayBooks() {
        for (Book b : books) {
            System.out.println(
                b.title + " | " + b.author + " | " +
                (b.available ? "Available" : "Checked Out")
            );
        }
    }
    static void searchBook(String keyword) {
        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b.title + " | " + b.author);
            }
        }
    }
    static void checkoutBook(String title) throws BookNotAvailableException {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (!b.available) {
                    throw new BookNotAvailableException("Book is not available!");
                }
                b.available = false;
                System.out.println("Book checked out successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
    public static void main(String[] args) {
        Book[] bookArray = {
            new Book("Java Programming", "James Gosling", true),
            new Book("Clean Code", "Robert Martin", true),
            new Book("Data Structures", "Mark Allen", false)
        };
        addBooks(bookArray);
        System.out.println("All Books:");
        displayBooks();
        System.out.println("\nSearch Result:");
        searchBook("java");
        try {
            checkoutBook("Data Structures");
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkoutBook("Clean Code");
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nUpdated Books:");
        displayBooks();
    }
}
