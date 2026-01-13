package student_course_registration_system;

public abstract class RegistrationService {
    public abstract void register(Student student, String course);
    public abstract void drop(Student student, String course);
}
