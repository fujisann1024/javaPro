package japaneseServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import japaneseModel.Score;
import userDAO.ScoreDAO;
import userModel.Student;


@WebServlet("/KanjiResult")
public class KanjiResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Student student =
		(Student)session.getAttribute("student");
		System.out.println("result"+student.getUserId());
		Score score =
		(Score)session.getAttribute("score");
		System.out.println("result" + score.getScore() + "result" + score.getPercentage());
		ScoreDAO scoreDAO = new ScoreDAO();
		scoreDAO.insertScore(score,student);

		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("/WEB-INF/japanese/kanjiResult.jsp");
		dispatcher.forward(request, response);
	}

}
