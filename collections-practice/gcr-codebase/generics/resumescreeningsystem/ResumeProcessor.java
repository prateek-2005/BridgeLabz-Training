package resumescreeningsystem;
public class ResumeProcessor {
    public static <T extends JobRole> void analyzeResume(T candidate) {
        System.out.println("AI analyzing resume of: " + candidate.getCandidateName());
        candidate.screen();
    }
}

