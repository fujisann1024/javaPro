<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="japaneseModel.KanjiQuiz,java.util.List" %>
<% List<KanjiQuiz> readKanjiList =
(List<KanjiQuiz>)session.getAttribute("readKanjiList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>次の漢字の読み仮名を記述せよ</h1>
<% for(KanjiQuiz kanji : readKanjiList){ %>
<p><%= kanji.getName()%></p>
<% } %>
</body>
</html>