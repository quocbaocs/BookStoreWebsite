<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Not Found Error</title>
</head>
<body>
	<div align="center">
		<div>
			<img alt="" src="${pageContext.request.contextPath}/images/Logo_bookstore.gif" />
		</div>
		<div>
			<h2>Sorry, the requested page cound not be not found.</h2>
		</div>
		<div>
			<a href="javascript:history.go(-1);">Go Back</a>
		</div>
	</div>
</body>
</html>