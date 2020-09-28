<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="quizModel.AnswerData,
        	quizModel.AnswerLogic,
        	quizModel.QuizData,
        	quizModel.QuizPattern,
        	java.util.List"%>
<%
//セッションスコープに保存された回答データリストを取得
	List<AnswerData> answerDataList
	= (List<AnswerData>) session.getAttribute("answerDataList");
	//QuizDataインスタンスの作成
	QuizData quizD = new QuizData();
	//QuizPatternインスタンスの作成
	QuizPattern quizP = new QuizPattern();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Hello World</p>
	<h1>次の問題に答えてください</h1>
	<!-- 問題文が表示される -->
	<h2><%= quizP.dispQuestion(quizD, answerDataList.size()) %></h2>
	<!--
	解答に答えるためのformタグを作成
 	action="/プロジェクト名/サーブレットファイル"
 	method=post(doPostに送る)またはget(doGetに送る)を指定							          -->
	<form action="/QuizApp/Quiz" method="post">
		<input type="number" name="answer"><br>
		<input type="submit" value="答える">
	</form>
	<a href="/QuizApp/Quiz?next=<%= answerDataList.size() %>">次の問題</a>
<p>あなたの回答</p>
	<% for(AnswerData answerData : answerDataList){%>
	<p><%= answerData.getAnswer() %></p>
	<%} %>
</body>
</html>