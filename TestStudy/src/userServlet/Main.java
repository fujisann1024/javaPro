package userServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userModel.Student;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		//セッションの確保
		HttpSession session = request.getSession();
		//セッションの有効時間を設定(デフォルトでは1800秒(30分))
		session.setMaxInactiveInterval(3600 * 24);//一日は有効

		//ログイン時,新規会員登録時に保存したセッションを取り出す
		Student student =
		(Student)session.getAttribute("student");
		RequestDispatcher dispatcher = null;
		if(student != null) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/main.jsp");
			dispatcher.forward(request, response);
		}else {
			//もしセッションが空(ログインできていなければ)トップ画面へ戻す
			dispatcher = request.getRequestDispatcher("welcome.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {

	}

}
