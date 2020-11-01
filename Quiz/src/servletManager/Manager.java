package servletManager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managerModel.Teacher;


@WebServlet("/Manager")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		System.out.println(name);
		System.out.println(pass);

		//セッションの確保
		HttpSession session = request.getSession();

		//エラーメッセージを格納する変数を用意
		String errorMsg1 = null;
		String errorMsg2 = null;

		//フォワード先の用意
		RequestDispatcher dispatcher = null;

		//入力フォームチェック
		if(name.length() != 0 || pass.length() != 0){
			if(name.equals("admin") && pass.equals("1234")) {
				Teacher teacher = new Teacher(name,pass);
				session.setAttribute("teacher", teacher);
				dispatcher =
				request.getRequestDispatcher("/WEB-INF/manager.jsp");

			}else {
				errorMsg2 = "あなたはだれですか?";
				request.setAttribute("errorMsg2",errorMsg2);
				dispatcher = request.getRequestDispatcher("/managerLogin.jsp");

				dispatcher =
				request.getRequestDispatcher("/managerLogin.jsp");
			}


		}else {
			errorMsg1 = "フォーム内容を入力して下さい";
			request.setAttribute("errorMsg1",errorMsg1);
			dispatcher = request.getRequestDispatcher("/managerLogin.jsp");
		}

		dispatcher.forward(request, response);



	}

}
