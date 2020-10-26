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
import japaneseModel.ScoringLogic;
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
		List<String> readAnswerList = null;

		//生徒の情報を格納するインスタンスを生成
		Student studentData = new Student();

		//Kanjiテーブルに関する処理を行うためのインスタンスを生成
		KanjiDAO kanjiDAO = new KanjiDAO();

		//それぞれがnullならArrayListを格納
		if(readKanjiList == null && readAnswerList == null) {
			//ArrayListを格納
			readKanjiList = new ArrayList<>();
			readAnswerList = new ArrayList<>();

			//ランダム化された漢字リストをreadKanjiListに代入
			readKanjiList = kanjiDAO.findAll();
			Collections.shuffle(readKanjiList);

			//セッションスコープに漢字リストと回答リストの初期値を保存
			session.setAttribute("readKanjiList",readKanjiList);
			session.setAttribute("readAnswerList",readAnswerList );
			session.setAttribute("studentData", studentData);
		}


		//テスト
		List<KanjiQuiz> testKanjiList =
	   (List<KanjiQuiz>)session.getAttribute("readKanjiList");
		List<Student> testAnsList =
		(List<Student>)session.getAttribute("readAnswerList");
		Student testStudent = (Student)session.getAttribute("studentData");

		System.out.println("doGet()=>readKanjiListの中身" +testKanjiList);
		System.out.println("doGet()=>answerListの中身" +testAnsList);
		System.out.println("doGet()=>doGet()=>studentDataの中身" +testStudent);

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
			answer = "";
		}

		//doGetで設定した配列を取り出す
		HttpSession session = request.getSession();

		List<KanjiQuiz> readKanjiList =
	   (List<KanjiQuiz>)session.getAttribute("readKanjiList");
		List<String> readAnswerList =
		(List<String>)session.getAttribute("readAnswerList");
		Student studentData =
		(Student)session.getAttribute("studentData");

		//採点の処理に関するインスタンスを生成
		ScoringLogic scoringLogic = new ScoringLogic();

		scoringLogic.setDataList(answer, readAnswerList);


		System.out.println("doPost()=>送信後の回答リスト"+readAnswerList);

		scoringLogic.getReadScoreData(studentData, readAnswerList, readKanjiList);
		System.out.println("doPost()=>点数" + studentData.getScore());
		System.out.println("doPost()=>正解率" + studentData.getPercentage());

		session.setAttribute("readAnswerList",readAnswerList );
		session.setAttribute("studentData", studentData);


		for(String ans : readAnswerList) {
			System.out.println(ans);
		}

		System.out.println(readKanjiList);


		//回答がすべて出来れば(=readAnswerListの
		//要素数が出題数と同じになれば)結果画面にフォワード

		RequestDispatcher dispacher = null;//dispacherの用意
		if(readAnswerList.size() >= 10) {
			dispacher =
			request.getRequestDispatcher("/Test/Study");
			dispacher.forward(request, response);
		}else {
			dispacher =
			request.getRequestDispatcher("/WEB-INF/japanese/kanjiForm.jsp");
			dispacher.forward(request, response);
		}

	}


}
