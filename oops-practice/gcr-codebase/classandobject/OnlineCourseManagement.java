class Course{
	String courseName;
	int duration;
	double fee;
	Course(String courseName,int duration,double fee){
		this.courseName=courseName;
		this.duration=duration;
		this.fee=fee;
	}
	static String instituteName="institute";
	void displayCourseDetails() {
		System.out.println("Course Name: "+courseName);
		System.out.println("Course Duration: "+duration);
		System.out.println("Course Fee: "+fee);
		System.out.println("Institute Name: "+instituteName);
		System.out.println();
	}
	static void updateInstituteName(String Name) {
		instituteName = Name;
        System.out.println("Institute name updated to: " + instituteName);
	}
}
public class OnlineCourseManagement {

	public static void main(String[] args) {
		Course c1=new Course("Java",4,5000);
		Course c2=new Course("DotNet",4,4000);
		c1.displayCourseDetails();
		c2.displayCourseDetails();
		Course.updateInstituteName("BridgeLabz");
		c1.displayCourseDetails();
		c2.displayCourseDetails();
	}

}
