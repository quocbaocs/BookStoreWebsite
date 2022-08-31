<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New User</title>
<link rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />


	<div align="center">
		<h2 class="pageheading">

			<c:if test="${user!=null}">
			Edit User
		</c:if>
			<c:if test="${user==null }">
			Create New User
		</c:if>
		</h2>
	</div>
		<div align="center">
			<c:if test="${user!=null}">
				<form action="update_user" method="post" id="userForm">
					<input type="hidden" value="${user.userId}" name="userId" />
			</c:if>
			<c:if test="${user==null}">
				<form action="create_user" method="post" id="userForm">
			</c:if>
			<table class="form">
				<tr>
					<td align="right">Email:</td>
					<td align="left"><input type="text" id="email" name="email"
						value="${user.email}" size="20" /></td>
				</tr>
				<tr>
					<td align="right">Full Name:</td>
					<td align="left"><input type="text" id="fullname"
						name="fullname" size="20" value="${user.fullName }" /></td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" id="password"
						name="password" value="${user.password }" size="20" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit">Save</button>&nbsp;&nbsp;&nbsp;&nbsp;
						<button id="buttonCancel">Cancel</button>
					</td>
				</tr>

			</table>
			</form>
		</div>
	<jsp:directive.include file="footer.jsp" />

</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#userForm").validate({
			rules : {
				email : {
					"required" : true,
					email : true,
				},
				fullname : "required",
				password : "required",
			},
			messages : {
				email : {
					required : "Please enter email",
					email : "Please enter an valid email address"
				},
				fullname : "Please enter full name",
				password : "Please enter password"
			}
		});

		$("#buttonCancel").click(function() {
			history.go(-1);
		});

	});
</script>
</html>