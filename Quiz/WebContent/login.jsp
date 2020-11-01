<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String emailError = (String)request.getAttribute("emailError");
   String passError = (String)request.getAttribute("passError");
   String accountError = (String)request.getAttribute("accountError");
   String email = (String)request.getAttribute("email");
   if(email == null){
	   email = "";
   }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
header {
	background-color: blue;
	border-bottom: solid;
	text-align:center;
}

header span {
	/*親要素で適用したCSSが継承される*/
	font-size: 30px;
	font-weight:200px;
	color: white;
}

body{
	text-align:center;
}

form{
    margin:100px;
}

.error{
  color:red;
  font-weight:600px;
}

</style>
<header>
	<span>ログイン画面</span>
</header>
<body>
<div>メールアドレスとパスワードを入力して下さい</div>
<form action="/Quiz/Login" method="post">
メールアドレス：<input type = "text" name = "email" value="<%= email%>"><br>
<% if(emailError != null){ %>
<p class = "error"><%= emailError %></p>
<% } %>
パスワード:<input type = "password" name = "pass"><br>
<% if(passError != null){ %>
<p class = "error"><%= passError %></p>
<% } %>
<% if(passError == null && emailError == null){ %>
  <% if(accountError != null ){ %>
	<p class = "error"><%= accountError %></p>
  <% } %>
<% } %>
<input type="submit" value="送信">
</form>
<a href="welcome.jsp">戻る</a>
</body>
</html>