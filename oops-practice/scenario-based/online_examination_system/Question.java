package online_examination_system;

public class Question {
    private String question;
    private String correctAnswer;
    private boolean isObjective;

    public Question(String question, String correctAnswer, boolean isObjective) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.isObjective = isObjective;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isObjective() {
        return isObjective;
    }
}
