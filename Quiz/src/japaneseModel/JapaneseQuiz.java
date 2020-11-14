package japaneseModel;

import java.io.Serializable;

public class KanjiQuiz implements Serializable{
	private int id;
	private int area;

	private String kind;
	private String question;
	private String name;
	private String ruby;


	public KanjiQuiz () {

	}
	//問題内容を格納するコンストラクタ
	public KanjiQuiz(String name,String ruby) {
		this.name = name;
		this.ruby = ruby;
	}

	//group byで引っ張ってきたデータを格納するコンストラクタ
	public KanjiQuiz(int area,String kind) {
		this.area = area;
		this.kind = kind;

	}

	public int getId() {
		return id;
	}

	public int getArea() {
		return area;
	}

	public String getName() {
		return name;
	}

	public String getRuby() {
		return ruby;
	}

}
