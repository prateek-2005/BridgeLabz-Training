package online_examination_system;

public class DescriptiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(Question question, String answer) {
        if (answer.length() >= 20) {
            return 5;
        }
        else if(answer.length()>=10 &&answer.length()<20) {
        	return 3;
        }
        else if(answer.length()>0) {
        	return 2;
        }
        return 0;
    }
}

