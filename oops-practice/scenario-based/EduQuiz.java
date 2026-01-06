public class EduQuiz {
    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;

        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(student[i])) {
                score++;
            }
        }
        return score;
    }
    public static void main(String[] args) {
        String[] correctAnswers = {
            "A", "B", "C", "D", "A",
            "C", "B", "D", "A", "C"
        };
        String[] studentAnswers = {
            "A", "b", "C", "A", "A",
            "c", "B", "D", "B", "C"
        };
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(studentAnswers[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }
        int score = calculateScore(correctAnswers, studentAnswers);
        double percentage = (score / 10.0) * 100;
        System.out.println("\nTotal Score: " + score + "/10");
        System.out.println("Percentage: " + percentage + "%");
        if (percentage >= 50) {
            System.out.println("Result:pass");
        } else {
            System.out.println("Result: fail");
        }
    }
}
