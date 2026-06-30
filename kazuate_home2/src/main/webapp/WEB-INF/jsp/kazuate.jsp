<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String startmsg = (String) request.getAttribute("startmsg");
String msg = (String) request.getAttribute("msg");
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
	<% if (msg != null) { %>
		<p><%= msg %></p>
	<% } %>
	<p><a href="start">新しくゲームを始める</a></p>
	<% if (startmsg != null) { %>
	  <p><%= startmsg %></p>
	 <% } %>


</body>
</html>