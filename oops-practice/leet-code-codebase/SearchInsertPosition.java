import java.util.*;
public class SearchInsertPosition {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Size: ");
		int n=sc.nextInt();
		int []nums=new int[n];
		System.out.println("Enter Array Elements: ");
		for(int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
		}
		System.out.println("Enter Target Element: ");
		int target=sc.nextInt();
		int searchIndex=searchInsert(nums,target);
		System.out.println("Index Position: "+searchIndex);
		sc.close();
	}
	public static int searchInsert(int[] nums, int target){ 
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start;
    }
}
