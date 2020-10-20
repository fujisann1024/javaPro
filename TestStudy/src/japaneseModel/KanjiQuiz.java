package japaneseModel;

import java.io.Serializable;

public class KanjiQuiz implements Serializable{
	private int id;
	private String area;
	private String name;
	private String ruby;
	

	public KanjiQuiz () {

	}

	public KanjiQuiz(String name,String ruby) {
		this.name = name;
		this.ruby = ruby;
	}


	public int getId() {
		return id;
	}

	public String getArea() {
		return area;
	}

	public String getName() {
		return name;
	}

	public String getRuby() {
		return ruby;
	}

}
