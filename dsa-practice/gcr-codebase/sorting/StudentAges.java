import java.util.*;
public class StudentAges {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number Of Students: ");
		int n=sc.nextInt();
		int []ages=new int[n];
		System.out.println("Enter Student Ages: ");
		for(int i=0;i<n;i++) {
			ages[i]=sc.nextInt();
		}
		int []ans=countingSort(ages);
		for(int i=0;i<n;i++) {
			System.out.print(ans[i]+" ");
		}
		sc.close();
	}
	public static int[] countingSort(int []ages) {
		int n=ages.length;
		if(n==0) {
			return new int[0];
		}
		int maxAge=0;
		for (int i = 1; i < n; i++) {
            if (ages[i] > maxAge) {
                maxAge = ages[i];
            }
        }
		int []count=new int[maxAge+1];
		for(int i=0;i<=maxAge;i++) {
			count[i]=0;
		}
		for(int i=0;i<n;i++) {
			count[ages[i]]++;
		}
		for (int i = 1; i <= maxAge; i++) {
            count[i] += count[i - 1];
        }
		int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int v = ages[i];
            ans[count[v] - 1] = v;
            count[v]--;
        }

        return ans;
	}
}
