import java.util.*;
class InvalidQuizSubmissionException extends Exception{
	InvalidQuizSubmissionException(String msg){
		super(msg);
	}
}
public class OnlineQuizPlatform {
	public static int calculateScore(String []correct,String []user) throws InvalidQuizSubmissionException{
		if(correct.length!=user.length) {
			throw new InvalidQuizSubmissionException("Answer length mismatch");
		}
		int score=0;
		for(int i=0;i<correct.length;i++) {
			if(user[i].equalsIgnoreCase(correct[i])) {
				score++;
			}
		}
		return score;
	}
	public static String calculateGrade(int score,int total) {
		double percentage=(score*100.0)/total;
		if(percentage>=80) {
			return "A";
		}
		else if(percentage>=60) {
			return "B";
		}
		else if (percentage>=40) {
			return "C";
		}
		else {
			return "Fail";
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String []correctAnswers= {"A","B","C","D","A"};
		ArrayList<Integer> scoreList=new ArrayList<>();
		System.out.println("Enter number of users: ");
		int users=sc.nextInt();
		for(int u=0;u<users;u++) {
			System.out.println("USer: "+(u+1));
			String []userAnswers=new String[5];
			for(int i=0;i<userAnswers.length;i++) {
				System.out.println("Enter answer for questio: "+(i+1)+": ");
				userAnswers[i]=sc.next();
			}
			try {
				int score=calculateScore(correctAnswers,userAnswers);
				scoreList.add(score);
				String grade=calculateGrade(score,correctAnswers.length);
				System.out.println("Score: "+score);
				System.out.println("Grade: "+grade);
			}
			catch (InvalidQuizSubmissionException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("All Scores: ");
		for(int i=0;i<scoreList.size();i++) {
			System.out.println("User "+(i+1)+" Score: "+scoreList.get(i));
		}
		sc.close();
	}

}
