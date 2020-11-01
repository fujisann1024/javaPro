<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="japaneseModel.KanjiQuiz,
                 userModel.Student,
                 japaneseModel.Score,
                 java.util.List,
                 java.util.ArrayList" %>
<%
//セッションの取得
List<KanjiQuiz> readKanjiList =
(List<KanjiQuiz>)session.getAttribute("readKanjiList");
List<String>  readAnswerList =
(List<String>)session.getAttribute("readAnswerList");
Student student = (Student)session.getAttribute("student");
Score score = (Score)session.getAttribute("score");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	span{
	  display:inline-block;
	}

</style>
<body>
	<div>
		<%= student.getUserName() %>さんの結果は
	</div>
	<div>
		100点満点中<%= score.getScore() %>点<br>
		正解率が約<%= score.getPercentage() %>
	</div>
</body>
</html>