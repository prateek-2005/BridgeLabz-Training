import java.util.*;;
public class LineComparisonComputation {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Use-Case 1
		System.out.println("Coordiantes for the first line");
		System.out.println("Enter 1st Point Coordinates:");
		double x1=sc.nextDouble();
		double y1=sc.nextDouble();
		System.out.println("Enter 2nd Point Coordinates:");
		double x2=sc.nextDouble();
		double y2=sc.nextDouble();
		double LengthOfLine1=Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
		System.out.println("Length Of The Line: "+LengthOfLine1);
		System.out.println("Coordiantes for the Second line");
		System.out.println("Enter 1st Point Coordinates:");
		double x3=sc.nextDouble();
		double y3=sc.nextDouble();
		System.out.println("Enter 2nd Point Coordinates:");
		double x4=sc.nextDouble();
		double y4=sc.nextDouble();
		double LengthOfLine2=Math.sqrt(Math.pow(x4-x3,2)+Math.pow(y4-y3,2));
		System.out.println("Length Of The Line: "+LengthOfLine2);
		//Use-Case 2
		boolean check=IsEqual(LengthOfLine1,LengthOfLine2);
		if(check) {
			System.out.println("Using Equals,Both Lines Are Eqaul.");
		}
		else {
			System.out.println("Using Equals,Both Lines Are Not Equal");
		}
		//Use-Case 3
		int Ans=compare(LengthOfLine1,LengthOfLine2);
		if(Ans>0) {
			System.out.println("Line 1 is greater than Line 2");
		}
		else if(Ans<0) {
			System.out.println("Line 2 is greater than Line 1");
		}
		else {
			System.out.println("Both Lines Are Equal");
		}
		sc.close();
	}
	public static boolean IsEqual(Double LengthOfLine1,Double LengthOfLine2) {
		return LengthOfLine1.equals(LengthOfLine2);
	}
	public static int compare(Double LengthOfLine1,Double LengthOfLine2) {
		return LengthOfLine1.compareTo(LengthOfLine2);
	}
}