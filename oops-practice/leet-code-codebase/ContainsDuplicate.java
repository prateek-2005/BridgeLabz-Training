import java.util.*;
public class ContainsDuplicate {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Size: ");
		int n=sc.nextInt();
		int []nums=new int[n];
		System.out.println("Enter Array Elements: ");
		for(int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
		}
		if(containsDuplicate(nums)) {
			System.out.println("Array contains duplicate elements");
		}
		else {
			System.out.println("Array does not contain duplicate elements");
		}
		sc.close();
	}
	public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
