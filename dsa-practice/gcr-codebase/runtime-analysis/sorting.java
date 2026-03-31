import java.util.*;
public class sorting {
    public static void main(String[] args) {
        int n = 10000; 
        int[] data1 = new int[n];
        int[] data2 = new int[n];
        int[] data3 = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int val = r.nextInt(100000);
            data1[i] = val;
            data2[i] = val;
            data3[i] = val;
        }
        long startBubble = System.nanoTime();
        bubbleSort(data1);
        long endBubble = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endBubble - startBubble) + " ns");

        
        long startMerge = System.nanoTime();
        mergeSort(data2, 0, data2.length - 1);
        long endMerge = System.nanoTime();
        System.out.println("Merge Sort Time: " + (endMerge - startMerge) + " ns");

        
        long startQuick = System.nanoTime();
        quickSort(data3, 0, data3.length - 1);
        long endQuick = System.nanoTime();
        System.out.println("Quick Sort Time: " + (endQuick - startQuick) + " ns");
    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
        	L[i] = arr[l + i];
        }    
        for (int j = 0; j < n2; j++) {
        	R[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
            	arr[k++] = L[i++];
            }  
            else {
            	arr[k++] = R[j++];
            }  
        }
        while (i < n1) {
        	arr[k++] = L[i++];
        }
        while (j < n2) {
        	arr[k++] = R[j++];
        }  
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

