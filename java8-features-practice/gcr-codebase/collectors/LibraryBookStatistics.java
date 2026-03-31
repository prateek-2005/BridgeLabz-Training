package collectors;
import java.util.*;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;

class Book {
    private String title;
    private String genre;
    private int pages;

    Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }
}

public class LibraryBookStatistics {
    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
            new Book("Java Basics", "Technology", 350),
            new Book("Spring Boot", "Technology", 500),
            new Book("Harry Potter", "Fantasy", 450),
            new Book("Lord of the Rings", "Fantasy", 700),
            new Book("Atomic Habits", "Self-Help", 320)
        );

        Map<String, IntSummaryStatistics> statsByGenre =
            books.stream()
                 .collect(Collectors.groupingBy(
                     Book::getGenre,
                     Collectors.summarizingInt(Book::getPages)
                 ));
        statsByGenre.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("Total Pages: " + stats.getSum());
            System.out.println("Average Pages: " + stats.getAverage());
            System.out.println("Max Pages: " + stats.getMax());
            System.out.println("---------------------");
        });
    }
}
