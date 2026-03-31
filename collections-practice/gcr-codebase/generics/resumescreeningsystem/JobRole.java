package resumescreeningsystem;
public abstract class JobRole {
    private String candidateName;
    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }
    public String getCandidateName() {
        return candidateName;
    }
    public abstract void screen();
}
