package address_book;
import java.util.*;
public class AddressBookSystem {
    HashMap<String,AddressBook> books=new HashMap<>();
    Scanner sc=new Scanner(System.in);
    public void createBook(){
        System.out.println("Enter Book Name:");
        String name=sc.nextLine();
        books.put(name,new AddressBook());
        System.out.println("Created");
    }
    public AddressBook getBook(){
        System.out.println("Enter Book Name:");
        String name=sc.nextLine();
        return books.get(name);
    }
}
