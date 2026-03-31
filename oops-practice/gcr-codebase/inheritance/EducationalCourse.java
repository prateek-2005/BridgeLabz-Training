class Course{
    String courseName;
    int duration;
    Course(String courseName,int duration){
        this.courseName=courseName;
        this.duration=duration;
    }
    void displayCourse(){
        System.out.println("Course Name: "+courseName);
        System.out.println("Duration: "+duration);
        System.out.println();
    }
}
class OnlineCourse extends Course{
    String platform;
    String isRecorded;
    OnlineCourse(String courseName, int duration,String platform,String isRecorded) {
        super(courseName, duration);
        this.platform=platform;
        this.isRecorded=isRecorded;
    }
    void displayCourse(){
        System.out.println("Course Name: "+courseName);
        System.out.println("Duration: "+duration);
        System.out.println("Platform: "+platform);
        System.out.println("Recorded: "+isRecorded);
        System.out.println();
    }
}
class PaidOnlineCourse extends OnlineCourse{
    int fee;
    int discount;
    PaidOnlineCourse(String courseName, int duration, String platform, String isRecorded,int fee,int discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee=fee;
        this.discount=discount;
    }
    void displayCourse(){
        System.out.println("Course Name: "+courseName);
        System.out.println("Duration: "+duration);
        System.out.println("Platform: "+platform);
        System.out.println("Recorded: "+isRecorded);
        System.out.println("Fee: "+fee);
        System.out.println("Discount: "+discount+"%");
        System.out.println();
    }
}
public class EducationalCourse {
    public static void main(String[] args) {
        Course course=new Course("Java Full Stack",3);
        OnlineCourse onlineCourse=new OnlineCourse(course.courseName, course.duration,"Udemy","Yes");
        PaidOnlineCourse paidOnlineCourse=new PaidOnlineCourse(course.courseName, course.duration, onlineCourse.platform, onlineCourse.isRecorded, 2000,10);
        course.displayCourse();
        onlineCourse.displayCourse();
        paidOnlineCourse.displayCourse();

    }
}
