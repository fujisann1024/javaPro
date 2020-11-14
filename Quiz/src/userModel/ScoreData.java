package japaneseModel;

public class Score {
	private int subject;//科目
	private int area; //回答した分野
	private int score; //正解した点数
	private int percentage; //正解率

	public Score () {

	}

	public Score(int subject,int area) {
		this.subject = subject;
		this.area = area;
	}


	public int getSubject() {
		return subject;
	}
	public int getArea() {
		return area;
	}

	public int getScore() {
		return score;
	}

	public int getPercentage() {
		return percentage;
	}




	//セッター
	public void setSubject(int subject) {
		this.subject = subject;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
}
