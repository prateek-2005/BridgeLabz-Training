import java.util.*;
public class MaxSubarraySum {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //Taking n as input
        int []arr=new int[n]; //Intialize array as size n
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt(); // Taking array elements as input
        }
        System.out.println(sum(arr,n)); // Prints maximum sum
    }
    public static int sum(int []arr,int n){
        int curr=0;//Intialize current sum
        int maxi=arr[0];//Intialize maximum sum
        for(int i=1;i<n;i++){
            curr=Math.max(arr[i],curr+arr[i]);//Update current sum
            maxi=Math.max(maxi,curr);//Update maximum sum
        }
        return maxi; //Return maximum sum
    }
}
