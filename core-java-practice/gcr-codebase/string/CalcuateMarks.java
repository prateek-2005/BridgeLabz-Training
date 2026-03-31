import java.util.*;
public class CalcuateMarks {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [][]marks=generate(n);
        double[][] result =calculate(marks);
        String[] grade =Grade(result);
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i][0] + "\t" +marks[i][1] + "\t" +marks[i][2] + "\t" +result[i][0] + "\t" +
                result[i][1] + "\t" +result[i][2] + "\t" +grade[i]);
        }
        sc.close();
	}
	public static int [][]generate(int n){
		int [][]marks=new int[n][3];
		for (int i = 0; i < n; i++) {
            marks[i][0] =(int)(Math.random() * 50) + 50; 
            marks[i][1] =(int)(Math.random() * 50) + 50; 
            marks[i][2] =(int)(Math.random() * 50) + 50; 
        }
        return marks;
	}
	public static double[][] calculate(int [][]marks){
		    double[][] ans= new double[marks.length][3];
	        for (int i = 0; i < marks.length; i++) {
	            int total = marks[i][0]+marks[i][1]+marks[i][2];
	            double average = total / 3.0;
	            double percentage = (total / 300.0) * 100;
	            ans[i][0] = Math.round(total * 100.0) / 100.0;
	            ans[i][1] = Math.round(average * 100.0) / 100.0;
	            ans[i][2] = Math.round(percentage * 100.0) / 100.0;
	        }
	        return ans;
	}
	public static String[] Grade(double [][]ans) {
		String []Grade=new String[ans.length];
		for(int i=0;i<ans.length;i++) {
			double Percentage=ans[i][2];
			if (Percentage>= 80) {
		        Grade[i] = "A";
		    }
		    else if (Percentage>= 70 && Percentage<= 79) {
		        Grade[i] = "B";
		    }
		    else if (Percentage>= 60 && Percentage<= 69) {
		        Grade[i] ="C";
		    }
		    else if (Percentage>= 50 && Percentage<= 59) {
		        Grade[i] = "D";
		    }
		    else if (Percentage>= 40 && Percentage<= 49) {
		        Grade[i] ="E";   
		    }
		    else {
		        Grade[i] = "R";   
		    }
		}
		return Grade;
	}
}
