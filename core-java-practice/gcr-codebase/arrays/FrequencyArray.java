import java.util.*;
public class FrequencyArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int count=0;
		int N=number;
		while(N!=0) {
			count++;
			N=N/10;
		}
		int []Digits = new int[count];
        N= number;
        for (int i = 0; i < count; i++) {
            Digits[i]=N%10;
            N=N/10;
        }
        int []cnt=new int[10];
        for(int i=0;i<count;i++) {
        	cnt[Digits[i]]++;
        }
        for(int i=0;i<10;i++) {
        	if(cnt[i]>0) {
        		System.out.println(cnt[i]+" ");
        	}
        }
        sc.close();
	}

}
