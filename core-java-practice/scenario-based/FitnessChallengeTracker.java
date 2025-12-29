import java.util.*;
public class FitnessChallengeTracker {
	Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int []PushUps=new int[7];
		System.out.println("Enter Push Ups Per Day For Week: ");
		for(int i=0;i<7;i++) {
			PushUps[i]=sc.nextInt();
		}
		int []Ans=Calculate(PushUps);//Function Called For Finding Total And Average PushUps
		System.out.println("Total PushUps In This Week:  "+Ans[0]);//Print Total PushUps In This Week
		System.out.println("Average PushUps In This Week:  "+Ans[1]);//Print Total PushUps In This Week
		sc.close();
	}
	public static int[] Calculate(int []PushUps) {
		int Total=0;
		int Active=0;
		for(int i=0;i<PushUps.length;i++) {
			//Skip Rest Days
			//Add PushUps To the Total PushUps
			//Increment Active Days
			if(PushUps[i]!=0) {
				Active++;
				Total+=PushUps[i];
			}
		}
		int Average=(int)(Total/Active);
		return new int[] {Total,Average};
	}

}
