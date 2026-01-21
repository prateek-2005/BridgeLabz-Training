package universitycoursemanagementsystem;
import java.util.List;
public class University {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            c.evaluate();
        }
    }
}

