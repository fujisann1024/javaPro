package userServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userDAO.AccountDAO;
import userModel.LoginUser;
import userModel.Student;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//フォームから値を受け取り変数に格納する
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		//セッションの確保
		HttpSession session = request.getSession();
		//セッションタイムアウトの設定
		session.setMaxInactiveInterval(3600 * 24);

		//DAOの宣言
		AccountDAO accountDAO = new AccountDAO();

		//エラーメッセージを格納する変数
		String emailError = null;
		String passError = null;
		String accountError = null;
		//アカウントを格納するStudent変数
		Student student = null;

		//フォワードの準備
		RequestDispatcher dispatcher = null;
		//フォワード先のパス
		String forwardPath = null;

		//入力フォームのチェック
		if(email == null || email.length() == 0) {
			emailError = "名前を入力して下さい";
			request.setAttribute("emailError", emailError);
		}
		if(pass == null || pass.length() == 0) {
			passError = "パスワードを入力して下さい";
			request.setAttribute("passError", passError);
		}
		//入力されていなかった場合
		if(emailError != null && passError != null) {
			forwardPath = "login.jsp";
			dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}

		if(emailError == null || passError == null) {
			LoginUser loginUser = new LoginUser(email, pass);
		    student = accountDAO.findAcount(loginUser);
		}

		//もしアカウントが見つからなかったらエラー
		//見つかったらmain画面にフォワード
		if(student == null) {
			accountError = "メールアドレスかパスワードが間違っています";
			request.setAttribute("accountError", accountError);
			forwardPath = "login.jsp";
			dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}else {
			session.setAttribute("student", student);
			forwardPath = "WEB-INF/loginResult.jsp";
			dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}
	}

}
