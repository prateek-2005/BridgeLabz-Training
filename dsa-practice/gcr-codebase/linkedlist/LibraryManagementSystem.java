class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean available;
    BookNode next;
    BookNode prev;

    BookNode(String title, String author, String genre, int bookId, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;
    }
}

public class LibraryManagementSystem {
    BookNode head = null;
    BookNode tail = null;
    int size = 0;
    public void addAtBeginning(BookNode node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }
    public void addAtEnd(BookNode node) {
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
    public void addAtSpecificPosition(BookNode node, int position) {
        if (position <= 1) {
            addAtBeginning(node);
            return;
        }

        BookNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(node);
        } else {
            node.next = temp.next;
            node.prev = temp;
            temp.next.prev = node;
            temp.next = node;
            size++;
        }
    }
    public void deleteByBookId(int bookId) {
        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                size--;
                System.out.println("Book deleted successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }
    public void searchByTitle(String title) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Book not found");
        }
    }
    public void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No books found by this author");
        }
    }
    public void updateAvailability(int bookId, boolean status) {
        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.available = status;
                System.out.println("Availability updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }
    public void displayForward() {
        if (head == null) {
            System.out.println("No books to display");
            return;
        }

        BookNode temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books to display");
            return;
        }

        BookNode temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }
    public void countBooks() {
        System.out.println("Total number of books: " + size);
    }
    private void displayBook(BookNode b) {
        System.out.println(
            "ID: " + b.bookId +
            ", Title: " + b.title +
            ", Author: " + b.author +
            ", Genre: " + b.genre +
            ", Available: " + (b.available ? "Yes" : "No")
        );
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addAtBeginning(new BookNode("Java Basics", "James", "Programming", 101, true));
        library.addAtEnd(new BookNode("DSA", "Mark", "Computer Science", 102, true));
        library.addAtSpecificPosition(new BookNode("Algorithms", "CLRS", "CS", 103, false), 2);
        library.addAtBeginning(new BookNode("Python", "Guido", "Programming", 104, true));

        library.displayForward();

        System.out.println("\nSearch by Author:");
        library.searchByAuthor("James");

        System.out.println("\nUpdate Availability:");
        library.updateAvailability(103, true);

        System.out.println("\nDisplay Reverse:");
        library.displayReverse();

        System.out.println();
        library.countBooks();

        library.deleteByBookId(102);
        library.displayForward();
    }
}
