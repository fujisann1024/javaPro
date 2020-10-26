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
<h3>こんにちは<%=student.getUserName() %></h3>
<body>
	<h1>勉強する科目を選んでください</h1>
	<table border = "1">
		<caption>勉強内容</caption>
	   <tr>
	     <th>漢字</th><th>社会</th>
	   </tr>
	   <tr>
	     <td><a href="/TestStudy/Kanji">読み仮名</a></td>
	     <td><a href="#">地図</a></td>
	   </tr>
	</table>
</body>
</html>