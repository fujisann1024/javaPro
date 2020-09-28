package quizModel;

public class QuizPattern {
	public static void ary1(String[] ary) {
		for (int i = 1; i < ary.length; i++) {
			System.out.println(ary[i] + ",");
		}
	}
	public String dispQuestion(QuizData quizdata,int qNum) {
		String[] questions = quizdata.getQuestions();
		return questions[qNum];
	}

	public static void main(String[] args) {
		QuizData quiz = new QuizData();
		String[] questions = quiz.getQuestions();

		ary1(questions);

	}

}
