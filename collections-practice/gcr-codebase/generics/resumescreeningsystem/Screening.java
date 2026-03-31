package resumescreeningsystem;
import java.util.List;
public class Screening {

    public static void runScreening(List<? extends JobRole> candidates) {
        System.out.println("AI Screening Pipeline Started...");

        for (JobRole candidate : candidates) {
            candidate.screen();
        }
    }
}
