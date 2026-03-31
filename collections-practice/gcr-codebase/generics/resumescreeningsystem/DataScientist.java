package resumescreeningsystem;
public class DataScientist extends JobRole {
    public DataScientist(String name) {
        super(name);
    }
    @Override
    public void screen() {
        System.out.println(getCandidateName() + " screened for Python, ML, Statistics.");
    }
}
