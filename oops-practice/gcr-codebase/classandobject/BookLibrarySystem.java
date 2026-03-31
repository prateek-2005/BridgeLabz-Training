class Book{
	public String ISBN;
	protected String title;
	private String author;
	Book(String ISBN,String title,String author){
		this.ISBN=ISBN;
		this.title=title;
		this.author=author;
	}
	public String getAuthorName() {
		return author;
	}
	public void setAuthorName(String name) {
		this.author=name;
	}
	public void displayDetails() {
        System.out.println("Book ISBN: " + ISBN);
        System.out.println("Book Name: " + title);
        System.out.println("Author Name: " + getAuthorName());
        System.out.println();
    }
}
class EBook extends Book{
	public EBook(String ISBN,String title,String author) {
		super(ISBN,title,author);
	}
	public void displayDetails() {
        System.out.println("Book ISBN: " + ISBN);
        System.out.println("Book Name: " + title);
        System.out.println("Author Name: " + getAuthorName());
        System.out.println();
    }
}
public class BookLibrarySystem {
	public static void main(String[] args) {
		Book book1=new Book("ISBN1234567","2States","ChetanBhagat");
		book1.displayDetails();
		book1.setAuthorName("Prateek");
		System.out.println("Author Name Updated");
		book1.displayDetails();
		EBook ebook=new EBook("ISBN2382","India","MahtamGandhi");
		ebook.displayDetails();
	}

}
