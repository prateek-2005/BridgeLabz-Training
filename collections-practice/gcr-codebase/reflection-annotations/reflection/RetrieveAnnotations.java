package reflection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Author Name")
class Book {
}

public class RetrieveAnnotations {
    public static void main(String[] args) {
        Class<Book> cls = Book.class;

        if (cls.isAnnotationPresent(Author.class)) {
            Author a = cls.getAnnotation(Author.class);
            System.out.println(a.name());
        }
    }
}
