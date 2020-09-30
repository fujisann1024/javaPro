<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="quizModel.AnswerData,
        	quizModel.AnswerLogic,
        	quizModel.QuizData,
        	java.util.List"%>
<%
//セッションスコープに保存された回答データリストを取得
	List<AnswerData> answerDataList
	= (List<AnswerData>) session.getAttribute("answerDataList");
//アプリケーションスコープに保存された問題リストを取得
	List<String> quizDataList
	= (List<String>) application.getAttribute("quizDataList");
//テスト
	System.out.println(quizDataList);
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
	<p><%= quizDataList.get(answerDataList.size()) %></p>
	<!--
	解答に答えるためのformタグを作成
 	action="/プロジェクト名/サーブレットファイル"
 	method=post(doPostに送る)またはget(doGetに送る)を指定							          -->
	<form action="/QuizApp/Quiz" method="post">
		<input type="number" name="answer"><br>
		<input type="submit" value="答える">
	</form>
	<a href="/QuizApp/Quiz?next=<%= answerDataList.size() %>">つぎの問題</a>
<p>あなたの回答</p>
	<% for(AnswerData answerData : answerDataList){%>
	<p><%= answerData.getAnswer() %></p>
	<%} %>
</body>
</html>