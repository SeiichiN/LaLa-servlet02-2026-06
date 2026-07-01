<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Kazuate" %>
<%
String result = (String) request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>数当てゲーム</title>
</head>
<body>
<h2>数当てゲーム</h2>
<form action="kazuate" method="post">
	数字を入力<br>
	<input type="text" name="user" placeholder="1～9"><br>
	<input type="submit" value="送信">
</form>

<%if(result != null) {//最初はnullだから表示されない %>
<p><%= result %></p>
<p><a href="kazuate">新しい数でスタート</a></p>
<%} %>
</body>
</html>