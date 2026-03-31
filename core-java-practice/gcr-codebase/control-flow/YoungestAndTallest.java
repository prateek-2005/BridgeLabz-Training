import java.util.*;
public class YoungestAndTallest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int AmarAge=sc.nextInt();
		int AkbarAge=sc.nextInt();
		int AnthonyAge=sc.nextInt();
		int AmarHeight=sc.nextInt();
		int AkbarHeight=sc.nextInt();
		int AnthonyHeight=sc.nextInt();
		if(AmarAge <= AkbarAge && AmarAge <= AnthonyAge) {
			System.out.println("Youngest Friend is Amar");
		}
		else if(AkbarAge<=AmarAge && AkbarAge<=AnthonyAge) {
			System.out.println("Youngest Friend is Akbar");
		}
		else {
			System.out.println("Youngest Friend is Anthony");
		}
		if(AmarHeight >= AkbarHeight && AmarHeight >= AnthonyHeight) {
			System.out.println("Tallest Friend is Amar");
		}
		else if(AkbarHeight>=AmarHeight && AkbarHeight>=AnthonyHeight) {
			System.out.println("Tallest Friend is Akbar");
		}
		else {
			System.out.println("Tallest Friend is Anthony");
		}
		sc.close();
	}

}
