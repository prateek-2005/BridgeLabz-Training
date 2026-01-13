package online_examination_system;

public class OnlineExaminationSystem {
	 public static void main(String[] args) {

	        Student s1 = new Student(1, "Rahul");

	        Exam exam = new Exam();
	        exam.addQuestion(new Question("Java is OOP language? (yes/no)", "yes", true));
	        exam.addQuestion(new Question("Explain OOP concepts", "OOP", false));

	        exam.startExam();

	        try {
	            exam.submitAnswer(0, "yes");
	            exam.submitAnswer(1, "OOP allows abstraction, encapsulation etc");
	        } catch (ExamTimeExpiredException e) {
	            System.out.println(e.getMessage());
	        }
	        exam.generateResult();
	    }
}
