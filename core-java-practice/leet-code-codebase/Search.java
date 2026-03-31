import java.util.*;
 public class Search{
    public static void main(String[] args){
           Scanner sc=new Scanner(System.in);
           //Taking n as input
           int n=sc.nextInt();
           //Intialize array size
           int [] arr=new int[n];
           for(int i=0;i<n;i++){
              arr[i]=sc.nextInt();
           }
           //Taking target as input
           int target=sc.nextInt();
           //output
           System.out.println(search(arr,target));
     }
     public static int search(int[] arr, int target) {
        //Iterate through array
       for(int i=0;i<arr.length;i++){
        if(arr[i]==target){
            return i;//return index when array element meets target
        }
       }
       return -1; //if not found return -1
    }
}