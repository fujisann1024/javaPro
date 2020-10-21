package userModel;

import java.io.Serializable;

public class Student implements Serializable{
	private int userId; //ユーザーID
	private String userName; //ユーザー名
	private int area; //回答した分野
	private int score; //正解した点数
	private int percentage; //正解率

	public Student () {

	}
	//ログイン成功時にSQLに格納される
	public Student(int userId,String userName) {
		this.userId = userId;
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
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
