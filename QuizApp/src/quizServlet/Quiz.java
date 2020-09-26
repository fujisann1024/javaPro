package quizServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quizModel.AnswerData;
import quizModel.AnswerLogic;


@WebServlet("/Quiz")
public class Quiz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {

		//フォワード先を変数forwardPathに代入する
		//フォワード先がjspファイルなので/WebContentからの相対パス
		String forwardPath = "/WEB-INF/quizJsp/quizForm.jsp";
		RequestDispatcher dispatcher =
		request.getRequestDispatcher(forwardPath);

		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
		//受け取ったリクエストパラメータをもとに戻すため
		//URLエンコードで使用した文字コードを指定
		request.setCharacterEncoding("UTF-8");
		//フォームから受け取ったname=answerのデータを変数に
		//格納する
		String answer = request.getParameter("answer");
		//セッションスコープ(一時的な保管場所)の取得
		//=>リクエストスコープだとレスポンス時にデータが消えてしまう
		HttpSession session = request.getSession();

		//セッションスコープに保存された回答データを呼び出し(最初は空)
		//answerDataリストに格納
		List<AnswerData> answerDataList
		//object型で返されるのでList<AnswerData>型でキャスト
		//引数の"answerDataList"は任意でつけれるが格納先の変数名と同じにしておく
		= (List<AnswerData>) session.getAttribute("answerDataList");

		//インスタンスにansDataにフォームから受け取ったデータを格納
		AnswerData ansData = new AnswerData(answer);

		//AnswerLogメソッドを使うためにAnswerLogインスタンスを生成
		AnswerLogic ansLog = new AnswerLogic();

		//インスタンスでAnswerLogメソッドにアクセスし、
		//回答データを回答データリストに格納
		ansLog.answerLog(ansData, answerDataList);

		//セッションスコープに回答データリストを保存
		session.setAttribute("answerDataList",answerDataList);

		//フォワード
		String forwardPath = "/WEB-INF/quizJsp/quizForm.jsp";
		RequestDispatcher dispatcher =
		request.getRequestDispatcher(forwardPath);

		dispatcher.forward(request, response);
	}

}
