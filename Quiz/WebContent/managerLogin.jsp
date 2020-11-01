<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String errorMsg1 = (String)request.getAttribute("errorMsg1");
    	String errorMsg2 = (String)request.getAttribute("errorMsg2");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Quiz/Manager" method="post">
		名前<input type = "text" name="name"><br>
		パスワード<input type="text" name="pass"><br>

		<% if(errorMsg1 != null) {%>
			<p><%= errorMsg1 %></p>
		<% }else if(errorMsg2 != null){ %>
			<p><%= errorMsg2 %></p>
		<% } %>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>