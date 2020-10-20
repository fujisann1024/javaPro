package japaneseServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import japaneseDAO.KanjiDAO;
import japaneseModel.KanjiQuiz;


@WebServlet("/Kanji")
public class Kanji extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		//セッションの確保
		HttpSession session = request.getSession();

		//クイズ配列を用意
		List<KanjiQuiz> readKanjiList =
		(List<KanjiQuiz>)session.getAttribute("readKanjiList");

		System.out.println("初回の状態"+readKanjiList);//null

		if(readKanjiList == null) {
			//ArrayListを格納
			readKanjiList = new ArrayList<>();

			//findAllメソッドの戻り値を受け取る
			KanjiDAO kanjiDAO = new KanjiDAO();
			readKanjiList = kanjiDAO.findAll();

			//セッションスコープに保存
			session.setAttribute("readKanjiList",readKanjiList);
		}

		//テスト
		List<KanjiQuiz> testList =
				(List<KanjiQuiz>)session.getAttribute("readKanjiList");

		System.out.println("セッションセット後の漢字データ"+testList);

//		//kanjiFormにフォワード
//		RequestDispatcher dispatcher =
//		request.getRequestDispatcher("/WEB-INF/kanjiForm.jsp");
//		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {

	}

}
