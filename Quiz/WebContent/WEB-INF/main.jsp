<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="userModel.Student" %>
<% Student student = (Student) session.getAttribute("student"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h3>こんにちは<%=student.getUserName() %>さん</h3>
<body>
	<h1>勉強する科目の分野を選んでください</h1>
	<form action="/Quiz/Select" method="get">
		<button name="subject" value="1">国語</button>
		<button name="subject" value="2">算数</button>
		<button name="subject" value="3">理科</button>
		<button name="subject" value="4">社会</button>
	</form>
	<a href="welcome.jsp">TOPへ</a>
	<a href="/Quiz/Logout">ログアウト</a>
</body>
</html>