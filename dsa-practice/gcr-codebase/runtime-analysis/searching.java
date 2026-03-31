import java.util.*;
public class searching {

	public static void main(String[] args) {
		int []data=new int[100000];
		for(int i=0;i<data.length;i++) {
			data[i]=i+1;
		}
		int target=99999;
		long startLinear=System.nanoTime();
		linearSearch(data,target);
		long endLinear=System.nanoTime();
		long linearDuration=endLinear-startLinear;
		System.out.println("Linear Search Time: "+linearDuration+" ns");
		Arrays.sort(data);
		long startBinary=System.nanoTime();
		binarySearch(data,target);
		long endBinary=System.nanoTime();
		long binaryDuration=endBinary-startBinary;
		System.out.println("Binary Search Time: "+binaryDuration+" ns");
	}
	public static int linearSearch(int[] data, int target) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == target)
				return i;
		}
		return -1;
	}
	public static int binarySearch(int[] data, int target) {
		int low = 0, high = data.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (data[mid] == target) {
				return mid;
			}	
			else if (data[mid] < target) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}	
		}
		return -1;
	}
}
