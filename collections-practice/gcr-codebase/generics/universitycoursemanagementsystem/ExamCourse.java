package universitycoursemanagementsystem;
public class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }
    @Override
    public void evaluate() {
        System.out.println(getCourseName() + " evaluated by exam.");
    }
}

