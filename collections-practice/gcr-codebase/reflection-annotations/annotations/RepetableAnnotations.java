package annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

class Software {
    @BugReport(description = "NullPointerException occurs")
    @BugReport(description = "ArrayIndexOutOfBoundsException possible")
    public void process() {
        System.out.println("Processing...");
    }
}

public class RepetableAnnotations {
    public static void main(String[] args) throws Exception {
        Method m = Software.class.getMethod("process");

        BugReport[] reports = m.getAnnotationsByType(BugReport.class);
        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }

        Software s = new Software();
        s.process();
    }
}
