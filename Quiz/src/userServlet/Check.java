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
import userModel.Regist;

/**
 * Servlet implementation class Check
 */
@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//フォームから受け取った値を変数に格納
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String morf = request.getParameter("morf");

		//セッションの確保
		HttpSession session = request.getSession();

		//DAOの宣言とLogin,Studentインスタンスの生成
		AccountDAO accountDAO = new AccountDAO();
		String checkPass = accountDAO.passCheck(pass);
		System.out.println(checkPass);


		//エラーメッセージを格納する変数
		String userNameError = null;
		String emailError = null;
		String passError = null;
		String morfError = null;

		//フォワードの準備
		RequestDispatcher dispatcher = null;
		//フォワード先のパス
		String forwardPath = null;

		if(userName == null || userName.length() == 0) {
			userNameError = "ユーザー名を入力して下さい";
			request.setAttribute("userNameError",userNameError);
		}

		if(email == null || email.length() == 0) {
			emailError = "メールアドレスを入力して下さい";
			request.setAttribute("emailError",emailError);
		}

		if(pass == null || pass.length() == 0) {
			passError = "パスワードを入力して下さい";
			request.setAttribute("passError",passError);
		}else if(pass.length() < 4) {
			passError = "パスワードは4文字以上で入力して下さい";
			request.setAttribute("passError",passError);
		}else if(pass.equals(checkPass)) {
			passError="このパスワードはすでに使われております";
			request.setAttribute("passError",passError);
		}


		if(morf == null || morf.length() == 0) {
			morfError = "性別を選択して下さい";
			request.setAttribute("morfError",morfError);
		}

		if(userNameError == null && emailError == null&& passError == null && morfError == null) {
			//Registインスタンスの生成
			Regist regist = new Regist(userName,email,pass,morf);
			session.setAttribute("regist", regist);
			forwardPath = "/WEB-INF/check.jsp";
			dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}else {
			forwardPath = "regist.jsp";
			dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}

	}

}
