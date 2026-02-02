package reflection;
class Student {
    String name;

    Student() {
        name = "Rahul";
    }
}
public class DynamicallyCreate {
    public static void main(String[] args) throws Exception {
        Class<Student> cls = Student.class;
        Object obj = cls.getDeclaredConstructor().newInstance();
        Student s = (Student) obj;
        System.out.println(s.name);
    }
}
