package Set2;
import java.util.*;

class Student {

    String name;
    String department;
    int q1, q2, q3;

    public Student(String name, String department, int q1, int q2, int q3) {
        this.name = name;
        this.department = department;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    public int getTotal() {
        return q1 + q2 + q3;
    }
}

class QuizSystem {

    private List<Student> students = new ArrayList<>();

    public void record(String name, String dept, int q1, int q2, int q3) {
        students.add(new Student(name, dept, q1, q2, q3));
        System.out.println("Record Added: " + name);
    }

    public void topDepartment(String dept) {

        if (students.isEmpty()) {
            System.out.println("No Records Available");
            return;
        }

        int max = -1;
        boolean found = false;

        for (Student s : students) {
            if (s.department.equals(dept)) {
                found = true;
                max = Math.max(max, s.getTotal());
            }
        }

        if (!found) {
            System.out.println("Department Not Found");
            return;
        }

        for (Student s : students) {
            if (s.department.equals(dept) && s.getTotal() == max) {
                System.out.println(s.name + " " + max);
            }
        }
    }

    public void topQuiz(String quiz) {

        if (students.isEmpty()) {
            System.out.println("No Records Available");
            return;
        }

        int max = -1;

        for (Student s : students) {

            int score = 0;

            if (quiz.equals("Q1"))
                score = s.q1;
            else if (quiz.equals("Q2"))
                score = s.q2;
            else if (quiz.equals("Q3"))
                score = s.q3;

            max = Math.max(max, score);
        }

        for (Student s : students) {

            int score = 0;

            if (quiz.equals("Q1"))
                score = s.q1;
            else if (quiz.equals("Q2"))
                score = s.q2;
            else if (quiz.equals("Q3"))
                score = s.q3;

            if (score == max) {
                System.out.println(s.name + " " + score);
            }
        }
    }
}

public class QuizPerformanceRankingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        QuizSystem system = new QuizSystem();

        for (int i = 0; i < n; i++) {

            String input = sc.nextLine();
            String[] parts = input.split(" ");

            if (parts[0].equals("Record")) {

                system.record(
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]),
                        Integer.parseInt(parts[5])
                );

            } else if (parts[0].equals("Top")) {

                if (parts[1].equals("Engineering") || parts[1].equals("Electronics")) {
                    system.topDepartment(parts[1]);
                } else {
                    system.topQuiz(parts[1]);
                }
            }
        }
        sc.close();
    }
}