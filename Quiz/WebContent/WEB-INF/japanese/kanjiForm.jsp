<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="japaneseModel.KanjiQuiz,
                 userModel.Student,
                 java.util.List,
                 java.util.ArrayList" %>
<% List<KanjiQuiz> readKanjiList =
(List<KanjiQuiz>)session.getAttribute("readKanjiList");
List<String> readAnswerList =
(List<String>)session.getAttribute("readAnswerList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css">
</head>
<header>
	<span class="Project-name">Study Plus<span>
</header>
<style>
.face{
	color:blue;
	font-size:20px;
}
</style>
<body>
<h1>次の漢字の読み仮名を記述せよ</h1>
<%-- <% for(KanjiQuiz kanji : readKanjiList){ %> --%>
<%-- <p><%= kanji.getName()%></p> --%>
<%-- <% } %> --%>
<%-- 漢字の読み仮名に関する問題 --%>
<div><%KanjiQuiz kanji =
       readKanjiList.get(readAnswerList.size()); %>
     <%= kanji.getName() %></div>

<form action="/Quiz/Kanji" method="post">
<%= readAnswerList.size() + 1 %>問目
	<div class="face">入力してね(`・ω・´)</div>
	<input type="text" name = "answer" ><br>
	<input type="submit" value="次へ">
</form>
</body>
</html>