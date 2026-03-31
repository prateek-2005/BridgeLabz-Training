package eduresults;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Student>> districts = new ArrayList<>();
        System.out.print("Enter number of districts: ");
        int d = sc.nextInt();
        for (int i = 0; i < d; i++) {
            System.out.print("Enter number of students in district " + (i + 1) + ": ");
            int n = sc.nextInt();
            List<Student> district = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                System.out.print("Enter id: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter marks: ");
                int marks = sc.nextInt();
                district.add(new Student(id, name, marks));
            }
            districts.add(district);
        }
        List<Student> finalList = RankMerger.mergeAllLists(districts);
        System.out.println("\nFinal Rank List:");
        int rank = 1;
        for (Student s : finalList) {
            System.out.println(rank++ + ". " + s);
        }
        sc.close();
    }
}
