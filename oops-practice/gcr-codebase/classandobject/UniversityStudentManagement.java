class Student {
    String name;
    final int rollNumber;   
    char grade;
    static String universityName = "Global University";
    static int totalStudents;
    Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }
    void upgradeGrade(char newGrade) {
            grade = newGrade;
    }
    void display() {
        if (this instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
            System.out.println();
        }
    }
    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
}

public class UniversityStudentManagement {
    public static void main(String[] args) {
        Student s1 = new Student("Hemashree", 101, 'A');
        Student s2 = new Student("Sharmila", 102, 'B');
        Student.displayTotalStudents();
        s1.display();
        s2.display();
        s2.upgradeGrade('A');
        System.out.println("Grade updated to: A");
        s2.display();
    }
}