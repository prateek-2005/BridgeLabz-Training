package universitycoursemanagementsystem;
public class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }
    @Override
    public void evaluate() {
        System.out.println(getCourseName() + " evaluated by research work.");
    }
}
