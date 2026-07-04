<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Com" %>
<%
Com c = (Com) session.getAttribute("com");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>数あてゲーム</h1>
	
	<%= c.getMsg() %><br>
	<% if (c.isAtari()) { %>	
		<a href="Kazuate">新しい数でスタート</a>
	<% } else { %>
		<form action="Kazuate" method="post">
			1～99を入力:<br>
			<input type="text" name="kazu"><br>
			<input type="submit" value="送信">
		</form>
	<% } %>	
	
<%--
	<% if (c.getMsg().equals("正解です")) { %>
		<%= c.getMsg() %><br>
		<a href="Kazuate">新しい数でスタート</a>
	<% } else { %>
		<form action="Kazuate" method="post">
			1～99を入力:<br>
			<input type="text" name="kazu"><br>
			<input type="submit" value="送信">
		</form>
		<%= c.getMsg() %><br>
	<% } %>
--%>

</body>

</html>