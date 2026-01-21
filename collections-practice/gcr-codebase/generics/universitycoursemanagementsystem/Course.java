package universitycoursemanagementsystem;
public class Course<T extends CourseType> {
    private T course;
    public Course(T course) {
        this.course = course;
    }
    public void showEvaluation() {
        course.evaluate();
    }
}

