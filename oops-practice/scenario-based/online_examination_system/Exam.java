package online_examination_system;

public class Exam {

    private Question[] questions = new Question[5];
    private String[] answers = new String[5];
    private int count = 0;

    private long startTime;
    private static final long timeLimit= 5000; 

    public void addQuestion(Question question) {
        questions[count++] = question;
    }

    public void startExam() {
        startTime = System.currentTimeMillis();
        System.out.println("Exam started...");
    }

    public void submitAnswer(int index, String answer) throws ExamTimeExpiredException {
        if (System.currentTimeMillis() - startTime > timeLimit) {
            throw new ExamTimeExpiredException("Time is over!");
        }
        answers[index] = answer;
    }

    public void generateResult() {
        int totalMarks = 0;

        for (int i = 0; i < count; i++) {
            EvaluationStrategy strategy;

            if (questions[i].isObjective())
                strategy = new ObjectiveEvaluation();
            else
                strategy = new DescriptiveEvaluation();

            totalMarks += strategy.evaluate(questions[i], answers[i]);
        }

        System.out.println("Total Marks: " + totalMarks);
    }
}
