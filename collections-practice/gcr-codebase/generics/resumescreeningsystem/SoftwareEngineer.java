package resumescreeningsystem;
public class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name) {
        super(name);
    }
    @Override
    public void screen() {
        System.out.println(getCandidateName() + " screened for DSA, Java, System Design.");
    }
}

