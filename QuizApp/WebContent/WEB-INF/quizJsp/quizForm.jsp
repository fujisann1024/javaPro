<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="quizModel.AnswerData,
        quizModel.AnswerLogic,java.util.List"%>
<%
//セッションスコープに保存された回答データリストを取得
List<AnswerData> answerDataList
= (List<AnswerData>) session.getAttribute("answerDataList");

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
	<% %>
	<!--
	解答に答えるためのformタグを作成
 	action="/プロジェクト名/サーブレットファイル"
 	method=post(doPostに送る)またはget(doGetに送る)を指定							          -->
	<form action="/QuizApp/Quiz.java" method="post">
		<input type="number" name="answer"><br> <input
			type="submit" value="答える">
	</form>
	<p>あなたの回答</p>
	<% for(AnswerData answerData : answerDataList){%>
	<p><%= answerData.getAnswer() %></p>
	<%} %>

</body>
</html>