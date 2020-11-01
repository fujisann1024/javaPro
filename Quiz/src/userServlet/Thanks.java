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
import userModel.Regist;
import userModel.Student;


@WebServlet("/Thanks")
public class Thanks extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//保存したセッションからゲットする
		Regist regist = (Regist)session.getAttribute("regist");

		//DAOの宣言
		AccountDAO accountDAO = new AccountDAO();

		//データベースに会員情報を登録する
		accountDAO.create(regist);

		//emailとパスワードのデータを変数に格納する
		String email = regist.getEmail();
		String pass = regist.getPass();

		//Loginインスタンスを生成し、メールアドレスとパスワードを格納する
		LoginUser login = new LoginUser(email,pass);

		//会員登録できたデータベースからデータを取り出し
		//studentインスタンスに格納
		Student student = accountDAO.findAcount(login);
		System.out.println(student.getUserId());
		System.out.println(student.getUserName());

		session.setAttribute("student",student);

		RequestDispatcher dispatcher
		= request.getRequestDispatcher("/WEB-INF/thanks.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	}

}
