import java.util.*;
public class CalculateBMI {
    public static String[] calculateBMI(double weight, double heightCm) {
        double HeightInMeter = heightCm / 100;
        double bmi = weight / (HeightInMeter * HeightInMeter);
        bmi = Math.round(bmi * 100.0) / 100.0;
        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi>=18.5 && bmi<=24.9) {
            status = "Normal";
        } else if (bmi>=25 && bmi<=39) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{String.valueOf(bmi), status};
    }
    public static String[][] get(double[][] PersonData) {
        String[][] ans= new String[PersonData.length][4];

        for (int i = 0; i < PersonData.length; i++) {
            double weight = PersonData[i][0];
            double height = PersonData[i][1];
            String[] bmiData = calculateBMI(weight, height);
            ans[i][0] = String.valueOf(height); 
            ans[i][1] = String.valueOf(weight); 
            ans[i][2] = bmiData[0];            
            ans[i][3] = bmiData[1];              
        }
        return ans;
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] PersonData= new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter Weight In KG");
            PersonData[i][0] = sc.nextDouble();
            System.out.print("Enter Height In Cms");
            PersonData[i][1] = sc.nextDouble();
        }

        String[][] arr= get(PersonData);
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t\t" +arr[i][1] + "\t\t" +arr[i][2] + "\t" +arr[i][3]);
        }
        sc.close();
    }
}
