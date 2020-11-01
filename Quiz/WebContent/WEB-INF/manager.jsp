<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="managerModel.Teacher"%>
<% Teacher teacher = (Teacher)session.getAttribute("teacher"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><%= teacher.getName() %>さん</div>

	<form action="/Quiz/SelectAdmin" method="get">
		<button name="subject" value="1">国語</button>
		<button name="subject" value="2">算数</button>
		<button name="subject" value="3">理科</button>
		<button name="subject" value="4">社会</button>
	</form>
</body>
</html>