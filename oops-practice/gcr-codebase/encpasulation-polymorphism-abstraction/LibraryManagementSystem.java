abstract class LibraryItem{
	private String itemId;
	private String title;
	private String author;
	LibraryItem(String itemId,String title,String author){
		setItemId(itemId);
		setTitle(title);
		setAuthor(author);
	}
	public void setItemId(String itemId) {
		this.itemId=itemId;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public void setAuthor(String author) {
		this.author=author;
	}
	public String getItemId() {
		return itemId;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getItemDetails() {
		return "ID: "+itemId+" ,Title: "+title+" ,Author: "+author;
	}
	abstract int getLoanDuration();
}
interface Reservable{
	void reserveItem(String borrowerName);
	boolean checkAvailability();
}
class Book extends LibraryItem implements Reservable{
	private boolean reserved;
    private String borrowerName;
    Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.reserved = false;
    }
    @Override
    int getLoanDuration() {
    	return 21;
    }
    @Override
    public void reserveItem(String borrowerName) {
    	this.reserved=true;
    	this.borrowerName=borrowerName;
    }
    @Override
    public boolean checkAvailability() {
    	return !reserved;
    }
    public String getBorrowerName() {
        if (borrowerName != null) {
            return borrowerName; 
        }
        return "None";
    }
}
class Magazine extends LibraryItem implements Reservable {
    private boolean reserved;
    private String borrowerName;

    Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
        this.reserved = false;
    }

    @Override
    int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem(String borrowerName) {
        this.reserved = true;
        this.borrowerName = borrowerName;
    }

    @Override
    public boolean checkAvailability() {
        return !reserved;
    }
    public String getBorrowerName() {
        if (borrowerName != null) {
            return borrowerName.charAt(0) + "****";
        }
        return "None";
    }
}
class DVD extends LibraryItem implements Reservable {
    private boolean reserved;
    private String borrowerName;
    DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.reserved = false;
    }

    @Override
    int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem(String borrowerName) {
        this.reserved = true;
        this.borrowerName = borrowerName;
    }
    @Override
    public boolean checkAvailability() {
        return !reserved;
    }

    public String getBorrowerName() {
        if (borrowerName != null) {
            return borrowerName;
        }
        return "None";
    }
}
class Display {
    static void display(LibraryItem item) {
        System.out.println(item.getItemDetails());
        System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

        if (item instanceof Reservable) {
            Reservable res = (Reservable) item;
            System.out.println("Available: " + (res.checkAvailability() ? "YES" : "NO"));
        }

        System.out.println("End Of Record\n");
    }
}
public class LibraryManagementSystem {
	public static void main(String[] args) {
		LibraryItem book= new Book("B101", "Java Programming", "Oracle");
        LibraryItem magazine= new Magazine("M202", "MoodOfNation", "Times Of India");
        LibraryItem dvd= new DVD("D303", "Music", "RadioMirchi");
        ((Reservable)book).reserveItem("Prateek");
        ((Reservable)dvd).reserveItem("Shyam");
        Display.display(book);
        Display.display(magazine);
        Display.display(dvd);
	}
}
