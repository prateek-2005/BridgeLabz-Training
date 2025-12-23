import java.util.*;
public class CheckVoterAge {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []ages=generate(n);
		String [][]ans=check(ages);
		System.out.println("Age\tCan Vote");
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + "\t" + ans[i][1]);
        }
        sc.close();
	}
	public static int[] generate(int n) {
        int[] ages = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            ages[i] = r.nextInt(90);
        }
        return ages;
    }
	public static String[][] check(int []ages){
		String [][]arr=new String[ages.length][2];
		for (int i = 0; i < ages.length; i++) {
            arr[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                arr[i][1] = "false";
            } else if (ages[i] >= 18) {
                arr[i][1] = "true";
            } else {
                arr[i][1] = "false";
            }
        }
        return arr;
		
	}
}
