import java.util.*;

class Question{
	final int id;
	final String text;
	final String correctAnswer;
	
	Question(int id,String text,String correctAnswer){
		this.id=id;
		this.text=text;
		this.correctAnswer=correctAnswer;
	}
}

class NavigationManager{
	private final Stack<Integer> history=new Stack<>();
	
	public void visit(int qid) {
		history.push(qid);
	}
	
	public Integer back() {
		if(history.size()<=1) {
			return null;
		}
		history.pop();
		return history.peek();
	}
}

class AnswerStore{
	private final Map<Integer,String> answers=new HashMap<>();
	
	public void save(int qid,String ans) {
		answers.put(qid, ans);
	}
	
	public Map<Integer,String> getAll(){
		return answers;
	}
}

class Evaluator{
	public int evaluate(Map<Integer,Question> bank,Map<Integer,String> answers) {
		int score = 0;
        for (int qid : bank.keySet()) {
            if (answers.containsKey(qid) && answers.get(qid).equalsIgnoreCase(bank.get(qid).correctAnswer)) {
                score++;
            }
        }
        return score;
	}
}

class ExamEngine {
    private final Map<Integer, Question> questionBank = new HashMap<>();
    private final NavigationManager nav = new NavigationManager();
    private final AnswerStore store = new AnswerStore();
    private final Evaluator evaluator = new Evaluator();

    private int currentQ = 1;

    public ExamEngine() {
        load();
        nav.visit(1);
    }

    private void load() {
        questionBank.put(1, new Question(1, "OOP pillar?", "ENCAPSULATION"));
        questionBank.put(2, new Question(2, "Stack order?", "LIFO"));
        questionBank.put(3, new Question(3, "HashMap complexity?", "O1"));
        questionBank.put(4, new Question(4, "JVM is?", "VIRTUAL"));
    }

    public void showQuestion() {
        Question q = questionBank.get(currentQ);
        System.out.println("\nQ" + q.id + ": " + q.text);
    }

    public void answer(String ans) {
        store.save(currentQ, ans);
        System.out.println("Answer recorded.");
    }

    public void next() {
        if (currentQ < questionBank.size()) {
            currentQ++;
            nav.visit(currentQ);
        }
        showQuestion();
    }

    public void back() {
        Integer prev = nav.back();
        if (prev != null) currentQ = prev;
        showQuestion();
    }

    public void submit() {
        int score = evaluator.evaluate(questionBank, store.getAll());
        System.out.println("\nFinal Score: " + score + "/" + questionBank.size());
    }
}
public class ExamProctor {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExamEngine exam = new ExamEngine();

        while (true) {
            exam.showQuestion();
            System.out.println("1. Answer  2. Next  3. Back  4. Submit");
            int ch = sc.nextInt(); sc.nextLine();

            if (ch == 1) {
                System.out.print("Ans: ");
                exam.answer(sc.nextLine());
            } else if (ch == 2) exam.next();
            else if (ch == 3) exam.back();
            else if (ch == 4) {
                exam.submit();
                break;
            }
        }
        sc.close();
    }
}
