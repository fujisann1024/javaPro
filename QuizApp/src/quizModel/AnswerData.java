package quizModel;

import java.io.Serializable;

public class AnswerData implements Serializable {

	private int score;
	private String answer;

	public AnswerData() {    }

	public AnswerData(String answer) {
		this.answer = answer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getAnswer() {
		return answer;
	}



}
