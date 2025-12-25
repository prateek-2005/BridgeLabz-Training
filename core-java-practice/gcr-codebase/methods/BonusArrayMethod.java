import java.util.*;

public class BonusArrayMethod {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double [][] OldSalary = new double[10][2];
        for(int i = 0; i < 10; i++) {
            OldSalary[i][0] = (int)(Math.random() * 90000) + 10000; 
            OldSalary[i][1] = (int)(Math.random() * 10) + 1;    
        }
        find(OldSalary);
        sc.close();
    }
    public static void find(double [][] OldSalary) {
        double [][] NewSalary = new double[10][3];
        double totalOld = 0, totalBonus = 0, totalNew = 0;
        for(int i = 0; i < 10; i++) {
            NewSalary[i][0] = OldSalary[i][0];
            if(OldSalary[i][1] > 5) {
                NewSalary[i][1] = 0.05 * OldSalary[i][0]; 
            } else {
                NewSalary[i][1] = 0.02 * OldSalary[i][0];
            }
            NewSalary[i][2] = NewSalary[i][0] + NewSalary[i][1];
            totalOld += NewSalary[i][0];
            totalBonus += NewSalary[i][1];
            totalNew += NewSalary[i][2];
        }
        System.out.println("EmpID   Old Salary   Years   Bonus   New Salary");
        for(int i = 0; i < 10; i++) {
            System.out.printf("%-6d %-11.2f %-6.0f %-8.2f %-11.2f\n",
                    (i+1), OldSalary[i][0], OldSalary[i][1], NewSalary[i][1], NewSalary[i][2]);
        }
        System.out.printf("TOTALS  %-11.2f %-6s %-8.2f %-11.2f\n",
                totalOld, "", totalBonus, totalNew);
    }
}