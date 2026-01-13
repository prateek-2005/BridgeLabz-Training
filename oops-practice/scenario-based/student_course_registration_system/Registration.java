package student_course_registration_system;

public class Registration extends RegistrationService {

    @Override
    public void register(Student student, String course) {
        try {
            student.enrollCourse(course);
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void drop(Student student, String course) {
        student.dropCourse(course);
    }
}
