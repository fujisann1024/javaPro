<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Map,
				   java.util.HashMap" %>
<%--  <% Integer subject = (Integer)request.getAttribute(); %> --%>
<% Map<Integer,String> areaKind = (Map<Integer,String>)session.getAttribute("areaKind"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <% for(Map.Entry<Integer, String> entry : areaKind.entrySet()){%> --%>
<%-- <p><%= entry.getValue() %></p> --%>
<%-- <p><%= entry.getKey() %></p> --%>
<%-- <% } %> --%>
<form action="/Quiz/Kanji" method="get">
	<div>問題のジャンルを選択してください</div>
	<select name="area">
		<% for(Map.Entry<Integer, String> entry : areaKind.entrySet()){%>
		<option value="<%= entry.getKey() %>">
			<%=entry.getValue() %>
		</option>
		<% } %>
	</select>
	<input type="submit" value="選択">
</form>
</body>
</html>