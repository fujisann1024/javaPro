package Test;

import java.util.List;

import japaneseModel.KanjiQuiz;
import userModel.Student;

public class TestLogic {
	//テスト関数
	public static void dispKanjiList(List<KanjiQuiz> readKanjiList) {
		for(KanjiQuiz kanji : readKanjiList) {
			System.out.println(kanji.getName() + "=>" + kanji.getRuby());
		}
	}

    public static void dispAnswerList(List<Student> answerList) {
    	for(Student student : answerList) {
			System.out.println(student.getAnswer());
		}
	}
}
