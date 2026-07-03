<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String msg = (String) request.getAttribute("msg");
Integer com = (Integer) request.getAttribute("com");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>数当て</title>
</head
>
<body>
	<h1>数当てゲーム</h1>
	
	<form action="Kazuate" method="post">
	
		1～99の数字を入力してください:<br>
		<input type="text" name="kazu"><br>
		<input type="submit" value="送信">		
		<p><%= msg %> com<%= com %></p>
		
	</form>
</body>
</html>