//JavaBeansのルール①～⑤
package quizModel;

import java.io.Serializable;
//②直列化可能である(Serializableを実装している)
public class AnswerData implements Serializable {
	//③カプセル化されたフィールドを持つ
	private int score;
	private double answer;
	//④publicで引数のないコンストラクタを持つ
	public AnswerData() {    }
	//⑤命名規則に従って(キャメルケース)書かれた
		//ゲッター、セッターを持つ
	public AnswerData(double answer) {
		this.answer = answer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public double getAnswer() {
		return answer;
	}



}
