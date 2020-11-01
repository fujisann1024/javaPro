<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String userNameError = (String)request.getAttribute("userNameError");
   String emailError = (String)request.getAttribute("emailError");
   String passError = (String)request.getAttribute("passError");
   String morfError = (String)request.getAttribute("morfError");
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
	<span>新規会員登録画面</span>
</header>
<body>

<div>フォームに必要事項を入力して下さい</div>

<form action="/Quiz/Check" method="post">
名前:<input type="text" name="userName"><br>
<% if(userNameError != null){ %>
	<p class="error"><%= userNameError %></p>
<% } %>
メールアドレス:<input type="text" name="email"><br>
<% if(emailError != null){ %>
	<p class="error"><%= emailError %></p>
<% } %>
パスワード:<input type="password" name="pass"><br>
<% if(passError != null){ %>
	<p class="error"><%= passError %></p>
<% } %>
男<input type="radio" name="morf" value="男">
女<input type="radio" name="morf" value="女"><br>
<% if(morfError != null){ %>
	<p class="error"><%= morfError %></p>
<% } %>
<input type="submit" value="確認画面へ">
</form>
<a href="welcome.jsp">戻る</a>
</body>
</html>