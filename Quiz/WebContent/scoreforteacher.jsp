<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒の成績表</title>
<style>
.image_size_m{
	width: 300px;
	height: 200px;
}
</style>
</head>
<body>
<h1>生徒ごとの成績の棒グラフ</h1>
	<% String fileName = "C:\\workspace\\Quiz\\WebContent\\img\\score.jpg"; %>
<img src= <%= fileName %> >

</body>
</html>