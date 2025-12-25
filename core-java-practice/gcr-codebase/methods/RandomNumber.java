import java.util.*;
public class RandomNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		System.out.println("Five Random Number:");
		int []arr=generate4DigitRandomArray(size);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		double []ans=findAverageMinMax(arr);
		System.out.println("Average:"+ans[0]);
		System.out.println("Minimum:"+ans[1]);
		System.out.println("Maximum:"+ans[2]);
		sc.close();
	}
	public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] =(int)(Math.random()*9000)+1000;
        }
        return arr;
    }
	public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;
        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        double average = (double) sum / numbers.length;
        return new double[]{average, min, max};
    }


}
