class Book {
    String title;
    String author;
    final String isbn;
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    static String libraryName = "GLAU";
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book = new Book("2 States", "Chetan Bhagat", "ISBN123456");
        Book.displayLibraryName();
        if (book instanceof Book) {
            book.display();
        } else {
            System.out.println("Not a Book object");
        }
    }
}