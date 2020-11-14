package japaneseServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import japaneseDAO.KanjiDAO;
import japaneseModel.KanjiQuiz;
import japaneseModel.Score;
import japaneseModel.ScoringLogic;


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
		List<String> readAnswerList = null;


		//Kanjiテーブルに関する処理を行うためのインスタンスを生成
		KanjiDAO kanjiDAO = new KanjiDAO();

		//Selectサーブレットで
		int subject =
		(Integer)session.getAttribute("subject");
		System.out.println( "subject" + subject);

		//フォームから受け取った値を変数に格納
		int area = Integer.parseInt(request.getParameter("area"));
		System.out.println(area);

		Score score = new Score(subject,area);
		session.setAttribute("score", score);

		//それぞれがnullならArrayListを格納
		if(readKanjiList == null && readAnswerList == null) {
			//ArrayListを格納
			readKanjiList = new ArrayList<>();
			readAnswerList = new ArrayList<>();

			//漢字リストをフォームから受け取った分野でList配列で受け取り
			//Collections.shuffleでランダムに並び替える
			readKanjiList = kanjiDAO.findAll(score);
			Collections.shuffle(readKanjiList);

//			//選択した科目,分野をstudentインスタンスに保存
//			score.setArea(10);
//			score.setSubject(1);
			//セッションスコープに漢字リストと回答リストの初期値を保存
			session.setAttribute("readKanjiList",readKanjiList);
			session.setAttribute("readAnswerList",readAnswerList );

		}


		//テスト
		List<KanjiQuiz> testKanjiList =
	   (List<KanjiQuiz>)session.getAttribute("readKanjiList");
		List<String> testAnsList =
		(List<String>)session.getAttribute("readAnswerList");


		System.out.println("doGet()=>readKanjiListの中身" +testKanjiList);
		System.out.println("doGet()=>answerListの中身" +testAnsList);


		//kanjiFormにフォワード
		RequestDispatcher dispatcher =
		request.getRequestDispatcher("/WEB-INF/japanese/kanjiForm.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//フォームから値を受け取る
		String answer = request.getParameter("answer");

		//もしanswerがnullなら空文字を入れる
		if(answer == null) {
			answer = "　";
		}

		//doGetで設定した配列を取り出す
		HttpSession session = request.getSession();

		List<KanjiQuiz> readKanjiList =
	   (List<KanjiQuiz>)session.getAttribute("readKanjiList");
		List<String> readAnswerList =
		(List<String>)session.getAttribute("readAnswerList");
		Score score = (Score)session.getAttribute("score");

		//採点の処理に関するインスタンスを生成
		ScoringLogic scoringLogic = new ScoringLogic();

		//フォームから送られてきた回答内容をreadAnswerListに保存
		scoringLogic.setDataList(answer, readAnswerList);

		//問題の正解と回答を比較し、採点結果を
		scoringLogic.getReadScoreData(score,
		readAnswerList, readKanjiList);


		session.setAttribute("readAnswerList",readAnswerList );
		session.setAttribute("score",score);

		//テスト
		System.out.println("----test------");
		int i = 1;
		for(KanjiQuiz kanji : readKanjiList) {
			System.out.print(i+"問目の答え:" + kanji.getRuby());
			i++;
		}
		System.out.println();

		for(String ans : readAnswerList) {
			System.out.print(i+"問目の回答内容:" + ans);
			i++;
		}
		System.out.println();

		System.out.println("doPost()=>点数" + score.getScore());
		System.out.println("doPost()=>正解率" + score.getPercentage());
		System.out.println("doPost()=>選択した分野" + score.getArea());


		System.out.println("----end------");




		//回答がすべて出来れば(=readAnswerListの
		//要素数が出題数と同じになれば)結果画面にフォワード

		RequestDispatcher dispacher = null;//dispacherの用意
		if(readAnswerList.size() < 10) {
			dispacher =
			request.getRequestDispatcher("/WEB-INF/japanese/kanjiForm.jsp");
			dispacher.forward(request, response);
		}else {
			dispacher =
			request.getRequestDispatcher("/KanjiResult");
			dispacher.forward(request, response);
		}

	}


}
