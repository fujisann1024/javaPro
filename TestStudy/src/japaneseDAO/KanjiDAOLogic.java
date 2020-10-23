package japaneseDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import japaneseModel.KanjiQuiz;

public class KanjiDAOLogic {
	//問題文をランダムにして返す
	public List<KanjiQuiz> getRandomQuizList(){
		KanjiDAO kanjiDAO = new KanjiDAO();
		List<KanjiQuiz> QuizList = new ArrayList();
		QuizList = kanjiDAO.findAll();
		//配列をランダムに並び変える
		Collections.shuffle(QuizList);
		return QuizList;
	}

	public static void main(String[] args) {
		KanjiDAOLogic kanjiDAOLogic = new KanjiDAOLogic();
		List<KanjiQuiz> KanjiQuizList = new ArrayList();
		KanjiQuizList = kanjiDAOLogic.getRandomQuizList();
		for(KanjiQuiz kanji : KanjiQuizList) {
			System.out.println(kanji.getName() + "=>" + kanji.getRuby());
		}

	}
}
