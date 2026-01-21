package resumescreeningsystem;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SoftwareEngineer se = new SoftwareEngineer("Rahul");
        DataScientist ds = new DataScientist("Priya");
        ProductManager pm = new ProductManager("Amit");
        Resume<SoftwareEngineer> r1 = new Resume<>(se);
        r1.processResume();
        ResumeProcessor.analyzeResume(ds);
        ResumeProcessor.analyzeResume(pm);
        List<JobRole> candidates = new ArrayList<>();
        candidates.add(se);
        candidates.add(ds);
        candidates.add(pm);

        Screening.runScreening(candidates);
    }
}

