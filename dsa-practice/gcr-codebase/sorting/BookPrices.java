import java.util.*;
public class BookPrices {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number Of Books: ");
		int n=sc.nextInt();
		int []prices=new int[n];
		System.out.println("Enter Price Of Book: ");
		for(int i=0;i<n;i++) {
			prices[i]=sc.nextInt();
		}
		mergeSort(prices,0,n-1);
		System.out.println("Sorted Book Prices: ");
		for(int i=0;i<n;i++) {
			System.out.print(prices[i]+" ");
		}
		sc.close();
	}
	public static void mergeSort(int []prices,int left,int right) {
		if(left<right) {
			int mid=left+(right-left)/2;
			mergeSort(prices,left,mid);
			mergeSort(prices,mid+1,right);
			merge(prices,left,mid,right);
		}
	}
	public static void merge(int []prices,int left,int mid,int right) {
		int n1=mid-left+1;
		int n2=right-mid;
		int []leftArr=new int[n1];
		int []rightArr=new int[n2];
		System.arraycopy(prices, left, leftArr, 0, n1);
        System.arraycopy(prices, mid + 1, rightArr, 0, n2);
        int i=0,j=0,k=left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                prices[k++] = leftArr[i++];
            } else {
                prices[k++] = rightArr[j++];
            }
        }
        while (i < n1) {
        	prices[k++] = leftArr[i++];
        }
        while (j < n2) {
        	prices[k++] = rightArr[j++];
        }

	}
}
