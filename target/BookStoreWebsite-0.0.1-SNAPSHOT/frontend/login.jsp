<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%@include file="header.jsp" %>

	<div align="center">
		<h2>Please login:</h2>
		<form action="">
		Email: <input type="text" size="20"><br>
		Password: <input type="password" size="20">
		<input type="submit" value="Login"> 
		
		</form>
	</div>

	<%@include file="footer.jsp" %>
</body>
</html>