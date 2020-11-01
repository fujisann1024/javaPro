package managerServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SelectAdmin")
public class SelectAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		//セッションの確保
				HttpSession session = request.getSession();

				int subject = Integer.parseInt(request.getParameter("subject"));
				System.out.println("科目"+subject);

				//フォワードの準備
				RequestDispatcher dispatcher = null;
				//フォワード先の準備
				String forwordPath = null;

				switch(subject) {
					case 1:
						forwordPath = "/AdminJapanese";
						dispatcher = request.getRequestDispatcher(forwordPath);
					break;
					case 2:
						forwordPath = "/AdminMath";
						dispatcher = request.getRequestDispatcher(forwordPath);
					break;
					case 3:
						forwordPath = "/AdminScience";
						dispatcher = request.getRequestDispatcher(forwordPath);
					break;
					case 4:
						forwordPath = "/AdminSociety";
						dispatcher = request.getRequestDispatcher(forwordPath);
					break;
				}
				
				dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, 
	HttpServletResponse response) throws ServletException, IOException {

	}

}
