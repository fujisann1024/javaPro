package japaneseServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import japaneseDAO.KanjiDAOLogic;
import japaneseModel.KanjiQuiz;
import userModel.Student;


@WebServlet("/Kanji")
public class Kanji extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//初期設定する場所
	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		//セッションの確保
		HttpSession session = request.getSession();

		//クイズ配列を初期化
		List<KanjiQuiz> readKanjiList = null;

		//答えを格納する配列を初期化
		List<Student> answerList = null;

		//Kanjiテーブルに関する処理を行うためのインスタンスを生成
		KanjiDAOLogic kanjiDAOLogic = new KanjiDAOLogic();

		//それぞれがnullならArrayListを格納
		if(readKanjiList == null && answerList == null) {
			//ArrayListを格納
			readKanjiList = new ArrayList<>();
			answerList = new ArrayList<>();

			//ランダム化された漢字リストをreadKanjiListに代入
			readKanjiList = kanjiDAOLogic.getRandomQuizList();

			//セッションスコープに漢字リストと回答リストの初期値を保存
			session.setAttribute("readKanjiList",readKanjiList);
			session.setAttribute("readAnswerList",answerList );
		}


		//テスト
		List<KanjiQuiz> testKanjiList =
	   (List<KanjiQuiz>)session.getAttribute("readKanjiList");
		List<Student> testAnsList =
		(List<Student>)session.getAttribute("readAnswerList");

		System.out.println("readKanjiListの中身" +testKanjiList);
		System.out.println("answerListの中身" +testAnsList);

		//kanjiFormにフォワード
		RequestDispatcher dispatcher =
		request.getRequestDispatcher("/WEB-INF/japanese/kanjiForm.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {

	}


}
