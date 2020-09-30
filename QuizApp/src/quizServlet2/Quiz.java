package quizServlet2;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quizModel.AnswerData;
import quizModel.AnswerLogic;
import quizModel.QuizData;

@WebServlet("/Quiz")
public class Quiz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープ(一時的な保管場所,特定のデータのみ)の取得
		//=>リクエストスコープだとレスポンス時にデータが消えてしまう
		HttpSession session = request.getSession();
		//アプリケーションスコープ(一時的な保管場所:アプリケーション全範囲)の取得
		ServletContext application = this.getServletContext();

		//セッションスコープに保存された回答データを呼び出し(最初はnull)
		//answerDataリストに格納
		List<AnswerData> answerDataList
		//object型で返されるのでList<AnswerData>型でキャスト
		//引数の"answerDataList"は任意でつけれるが格納先の変数名と同じにしておく
				= (List<AnswerData>) session.getAttribute("answerDataList");
		//問題と答えを格納するためのquizDataListとtruthDataListを用意
		//アプリケーションスコープに格納されているかの確認
//		List<String> quizDataList = (List<String>) application.getAttribute("quizDataList");
//		List<Double> truthDataList = (List<Double>) application.getAttribute("truthDataList");

		//テスト
		System.out.println(answerDataList);//null
//		System.out.println(quizDataList);//
//		System.out.println(truthDataList);//

		if(answerDataList == null) {
			//answerDataListが初期化されてないときArrayListインスタンスを作成
			answerDataList = new ArrayList<>();
			//セッションスコープにanswerDataListを格納
			session.setAttribute("answerDataList", answerDataList);
		}
		List<String> quizDataList = new ArrayList<>();
		List<Double> truthDataList = new ArrayList<>();
		QuizData quizData = new QuizData();
		//メソッドを使うためのAnswerLogicインスタンスを作成
		AnswerLogic ansLog = new AnswerLogic();
		ansLog.setListQandT(quizData, quizDataList, truthDataList);
		//アプリケーションスコープにquizDataListとtruthDataListを格納
		application.setAttribute("quizDataList", quizDataList);
		application.setAttribute("truthDataList", truthDataList);
		//テスト
		System.out.println(answerDataList);//[]
		System.out.println(quizDataList);
		System.out.println(truthDataList);

		//テスト(キック)
		//フォワード先を変数forwardPathに代入する

		//フォワード先がjspファイルなので/WebContentからの相対パス

      //フォワード
		String forwardPath = null;

	     forwardPath = "/WEB-INF/quizJsp/quizForm.jsp";

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
		HttpSession session = request.getSession();
		//アプリケーションスコープを用意
		ServletContext application = this.getServletContext();

			//セッションスコープに保存された回答データを呼び出し(最初は空)
			//answerDataリストに格納
			List<AnswerData> answerDataList
			= (List<AnswerData>) session.getAttribute("answerDataList");
			System.out.println(answerDataList);//[]

			List<Double> truthDataList
			= (List<Double>) application.getAttribute("truthDataList");
			System.out.println(truthDataList);



			//インスタンスにansDataにフォームから受け取ったデータを格納
			AnswerData ansData = new AnswerData(answer);
			//アプリケーションスコープに保存された
			//点数を格納するインスタンスをを呼び出す
			ansData = (AnswerData) application.getAttribute("ansData");
			//System.out.println(ansData.getScore());
			//AnswerLogメソッドを使うためにAnswerLogインスタンスを生成
			AnswerLogic ansLog = new AnswerLogic();

			//インスタンスでAnswerLogメソッドにアクセスし、
			//回答データを回答データリストに格納
			ansLog.answerLog(ansData, answerDataList);
			//回答と正解を比較し点数を加点していく
			ansLog.setScore(ansData, truthDataList, answerDataList);
			//セッションスコープに回答データリストを保存
			session.setAttribute("answerDataList", answerDataList);
			//アプリケーションスコープにansDataインスタンスを保存
			application.setAttribute("ansData", ansData);
			//テスト
            System.out.println(answerDataList.size());//
            int next = answerDataList.size();

            String forwardPath = null;
            //全問答えたら結果を表示するサイトに移動する
            //
            if(next < 5) {
            	forwardPath = "/WEB-INF/quizJsp/quizForm.jsp";
                RequestDispatcher dispatcher =
                	request.getRequestDispatcher(forwardPath);

                	dispatcher.forward(request, response);
            }else {
            	forwardPath = "/WEB-INF/quizJsp/quizResult.jsp";
                RequestDispatcher dispatcher =
                	request.getRequestDispatcher(forwardPath);

                	dispatcher.forward(request, response);
            }




	}

}
