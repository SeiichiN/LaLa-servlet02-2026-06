<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Com" %>
<%
Com com = (Com)session.getAttribute("com");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>数あてゲーム</h1>
	<form action="Kazuate" method="post">
		1～99を入力:<br>
		<input type="text" name="kazu"><br>
		<input type="submit" value="送信">
	</form>
	<% if (com.getMsg() != null) { %>
		<p><%= com.getMsg() %></p>
	<% } %>
	<p><a href="Kazuate">新しくゲームを始める</a></p>

</body>
</html>