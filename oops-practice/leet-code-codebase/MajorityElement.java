import java.util.*;
public class MajorityElement {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Size: ");
		int n=sc.nextInt();
		int []nums=new int[n];
		System.out.println("Enter Array Elements: ");
		for(int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
		}
		int element=majorityElement(nums);
		System.out.println("Majority Element in the array: "+element);
		sc.close();
	}
	public static int majorityElement(int[] nums) {
        int point=0;
        int target=-1;
        for(int i=0;i<nums.length;i++){
            if(point==0){
                point=1;
                target=nums[i];
            }
            else if(target!=nums[i]){
                point=point-1;
            }
            else if(target==nums[i]){
                    point=point+1;
            }
        }
        return target;
    }
}
