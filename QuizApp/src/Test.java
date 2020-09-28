import quizModel.QuizData;

public class Test {

	public static void ary1(String[] ary) {
		for (int i = 1; i < ary.length; i++) {
			System.out.println(ary[i] + ",");
		}
	}

	public static void ary2(double[] ary) {
		for (int i = 1; i < ary.length; i++) {
			System.out.println(ary[i] + ",");
		}
	}

	//テスト
	public static void main(String[] args) {
		QuizData quizData = new QuizData();
		String[] a = quizData.getQuestions();
		ary1(a);
		double[] b = quizData.getTruth();
		ary2(b);

	}

}
