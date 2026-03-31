class Book{
    String title;
    int publicationYear;
    Book(String title,int publicationYear){
        this.title=title;
        this.publicationYear=publicationYear;
    }
    void displayInfo(){
        System.out.println("Title: "+title);
        System.out.println("Publication Year: "+publicationYear);
        System.out.println();
    }
}
class Author extends Book{
    String name;
    String bio;

    Author(String title, int publicationYear,String name,String bio) {
        super(title, publicationYear);
        this.name=name;
        this.bio=bio;
    }
    void displayInfo() {
        System.out.println("Title: "+title);
        System.out.println("Publication Year: "+publicationYear);
        System.out.println("Author Name: "+name);
        System.out.println("Author Bio: "+bio);
        System.out.println();
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        Book book=new Book("2States",2012);
        Author author=new Author("2States",2012,"Chetan Bhagat","Motivational Speaker");
        book.displayInfo();
        author.displayInfo();
    }
}
