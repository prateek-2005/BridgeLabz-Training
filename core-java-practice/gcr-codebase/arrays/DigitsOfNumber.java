import java.util.*;
public class DigitsOfNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int max=10;
		int []Digits=new int[max];
		int i=0;
		while(number!=0) {
			Digits[i]=number%10;
			number=number/10;
			i++;
			if(i==max) {
				break;
			}
		}
		int largest=0;
		int secondlargest=-1;
		for(int j=0;j<Digits.length;j++) {
			if (Digits[j] > largest) {
                secondlargest = largest;
                largest = Digits[j];
            } else if (Digits[j] > secondlargest && Digits[j] != largest) {
                secondlargest = Digits[j];
            }
		}
		System.out.println("Largest "+largest);
		System.out.println("Second Largest "+secondlargest);
		sc.close();
	}

}
