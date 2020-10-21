<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="userModel.Student" %>
 <% Student student = (Student)session.getAttribute("student"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ようこそクイズプログラムへ</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/welcome.css">
</head>
<header>
	<span class="Project-name">Study Plus
	 	<a class="lank" href="#">今週のランキング</a>
	 	<a href="#">新着情報</a>
	 	<%if(student == null){ %>
	    <a href="login.jsp">ログイン画面</a>
	    <a href="#">新規会員登録</a>
	    <% }else{ %>
	    <a href = "WEB-INF/main.jsp">メイン画面へ</a>
	    <% } %>
	<span>
</header>
<body>
<div class="title">Practice Study</div>
<pre>
この
</pre>

</body>
</html>