package japaneseServlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import japaneseDAO.KanjiDAO;


@WebServlet("/SelectKanji")
public class SelectKanji extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//DAOの宣言
		KanjiDAO kanjiDAO = new KanjiDAO();

		Map<Integer,String> areaKind = kanjiDAO.selectQuiz();

		//セッションに保存
		session.setAttribute("areaKind", areaKind);


		//フォワード
		RequestDispatcher dispatcher =
		request.getRequestDispatcher("/WEB-INF/japanese/selectKanji.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

	}

}
