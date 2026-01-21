package resumescreeningsystem;
public class Resume<T extends JobRole> {
    private T role;
    public Resume(T role) {
        this.role = role;
    }
    public void processResume() {
        System.out.println("Processing resume for: " + role.getCandidateName());
        role.screen();
    }
}
