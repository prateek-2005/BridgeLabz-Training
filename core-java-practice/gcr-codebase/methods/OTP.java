import java.util.*;
public class OTP {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int []otp=new int[size];
		for(int i=0;i<size;i++) {
			otp[i]=generate();
		}
		System.out.println("Generated OTP :");
		for(int i=0;i<size;i++) {
			System.out.print(otp[i]+" ");
		}
		System.out.println();
		if(isUnique(otp)) {
			System.out.println("ALL OTP'S ARE UNIQUE");
		}
		else {
			System.out.println("ALL OTP'S ARE NOT UNIQUE");
		}
		sc.close();
	}
	public static int generate() {
		return (int)(Math.random()*900000)+100000;
	}
	public static boolean isUnique(int []otp) {
		for (int i = 0; i < otp.length; i++) {
            for (int j = i + 1; j < otp.length; j++) {
                if (otp[i] == otp[j]) {
                    return false; 
                }
            }
        }
        return true;
	}
}
