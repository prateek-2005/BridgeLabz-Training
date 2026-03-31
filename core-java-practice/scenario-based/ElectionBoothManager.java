import java.util.Scanner;
public class ElectionBoothManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome To pooling booth");
		boolean flag = true;
		int firstCandidateVotes = 0;
		int secondCandidateVotes = 0;
		int thirdCandidateVotes = 0;
		while(flag) {
			System.out.println("Enter your age ");
			int age = sc.nextInt();
			if(age<0) {
				System.out.println("Invalid Age");
				break;
			}
			else if(age<18) {
				System.out.println("you cannot vote as your age is less than minimum voting age");
			}
			else {
				System.out.println("Select 1 for Candidate 1, Select 2 for Candidate 2, and Select 3 for Candidate 3");
				int usersChoice = sc.nextInt();
				if(usersChoice == 1) {
					firstCandidateVotes++;
				}
				else if(usersChoice == 2) {
					secondCandidateVotes++;
				}
				else if(usersChoice == 3) {
					thirdCandidateVotes++;
				}
				else {
				    System.out.println("Invalid choice, vote not counted");
				}
			}
		}
		
		System.out.println("Total numbers of vote  candidate 1 have: " + firstCandidateVotes);
		System.out.println("Total numbers of vote  candidate 2 have: " + secondCandidateVotes);
		System.out.println("Total numbers of vete  candidate 3 have: " + thirdCandidateVotes);

		if (firstCandidateVotes>secondCandidateVotes && firstCandidateVotes>thirdCandidateVotes) {
		    System.out.println("candidate 1 won this election ");
		}
		else if (secondCandidateVotes>firstCandidateVotes && secondCandidateVotes>thirdCandidateVotes) {
		    System.out.println("candidate 2 won this election ");
		}
		else if (thirdCandidateVotes>firstCandidateVotes && thirdCandidateVotes>secondCandidateVotes) {
		    System.out.println("candidate 3 won this election ");
		}
		else {
		    System.out.println("Election result is tie.Another RePoll Will Take Place");
		}
		sc.close();

	}
}
