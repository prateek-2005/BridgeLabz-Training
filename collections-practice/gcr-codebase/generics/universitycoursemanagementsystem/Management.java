package universitycoursemanagementsystem;
import java.util.*;
public class Management {
    public static void main(String[] args) {
        Course<ExamCourse> c1 = new Course<>(new ExamCourse("Maths"));
        Course<AssignmentCourse> c2 = new Course<>(new AssignmentCourse("English"));
        Course<ResearchCourse> c3 = new Course<>(new ResearchCourse("AI Research"));
        c1.showEvaluation();
        c2.showEvaluation();
        c3.showEvaluation();
        List<ExamCourse> examList = new ArrayList<>();
        examList.add(new ExamCourse("Physics"));

        List<AssignmentCourse> assignmentList = new ArrayList<>();
        assignmentList.add(new AssignmentCourse("History"));

        University.displayAllCourses(examList);
        University.displayAllCourses(assignmentList);
    }
}

