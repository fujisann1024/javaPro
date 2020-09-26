//JavaBeansのルール①～⑤
//①クラスはpublicでパッケージに所属している
package quizModel;

import java.io.Serializable;
//②直列化可能である(Serializableを実装している)
public class QuizData implements Serializable {
	//③フィールドはカプセル化する
	//クイズに関するフィールド
	private String[] questions;
	private double[] truth;
	private int numQuestion;

	//④publicで引数のないコンストラクタを持つ
	public QuizData() {
		this.questions = new String[this.numQuestion];
		this.truth = new double[this.numQuestion];
	}

	//⑤命名規則に従って(キャメルケース)書かれた
	//ゲッター、セッターを持つ
	public String[] getQuestions() {
		return questions;
	}

	public void setQuestions(String[] questions) {
		this.questions = questions;
	}

	public double[] getTruth() {
		return truth;
	}

	public void setTruth(double[] truth) {
		this.truth = truth;
	}

	public int getNumQuestion() {
		return numQuestion;
	}

	public void setNumQuestion(int numQuestion) {
		this.numQuestion = numQuestion;
	}
}
