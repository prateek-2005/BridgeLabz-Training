class Book{
	String title;
	String author;
	double price;
	boolean availability;
	Book(String title,String author,double price){
		this.title=title;
		this.author=author;
		this.price=price;
		this.availability=true;
	}
     void borrow() {
    	 if(availability) {
    		 availability=false;
    		 System.out.println("Book is borrowed Successfully");
    	 }
    	 else {
    		 System.out.println("Book is not available");
    	 }
     }
     void returned() {
    	 availability=true;
    	 System.out.println("Booked is returned Successfully");
     }
     public void display() {
         System.out.println("Title: " + title + 
                            ", Author: " + author + 
                            ", Price: " + price + 
                            ", Available: " + (availability ? "Yes" : "No"));
     }

}
public class LibraryBookSystem {

	public static void main(String[] args) {
		Book book=new Book("2States","ChetanBhagat",500);
		book.display();
		book.borrow();
		book.display();
		book.borrow();
		book.returned();
		book.display();
	}

}
