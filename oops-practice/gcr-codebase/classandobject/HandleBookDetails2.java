import java.util.*;
class Book{
	String title;
    String author;
    double price;
    Book(){
    	this.title="Biopic";
    	this.author="self";
    	this.price=100;
    }
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    void display() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }
}
public class HandleBookDetails2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter author name: ");
        String author = sc.nextLine();
        System.out.print("Enter book price: ");
        double price = sc.nextDouble();
        System.out.println();
        Book book1=new Book();
        book1.display();
        System.out.println();
        Book book = new Book(title, author, price);
        book.display();
        sc.close();
	}

}
