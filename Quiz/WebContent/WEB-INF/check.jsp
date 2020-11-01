<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="userModel.Regist" %>
<% Regist regist = (Regist)session.getAttribute("regist"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body{
  text-align:center;
}

data{
   margin:50px;
   font-size:30px;
   font-weight:600px;
}
</style>
<body>
<div class="title">以下の内容でよろしいですか?</div>
<div class="data"><%= regist.getUserName() %></div>
<div class="data"><%= regist.getEmail() %></div>
<div class="data"><%= regist.getPass() %></div>
<div class="data"><%= regist.getMorf() %></div>
<a href="/Quiz/Thanks">登録する</a>｜<a href="regist.jsp">書き直す</a>
</body>
</html>