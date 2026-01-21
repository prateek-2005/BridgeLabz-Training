package universitycoursemanagementsystem;
public class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }
    @Override
    public void evaluate() {
        System.out.println(getCourseName() + " evaluated by assignments.");
    }
}

