<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Evergreen Bookstore Administration</title>
<link rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h1 class="pageheading">Users Management</h1>
		<h2 class="pageheading">
			<a href="user_form.jsp">Create New User</a>
		</h2>
	</div>
	<c:if test="${message !=null}">
		<div align="center"">
			<h4>
				<i >${message}</i>
			</h4>
		</div>
	</c:if>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Email</th>
				<th>Full Name</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="user" items="${listUsers}" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>${user.userId}</td>
					<td>${user.email}</td>
					<td>${user.fullName }</td>
					<td><a href="edit_user?id=${user.userId}">Edit</a> &nbsp; <a
						href="javascript:void(0);" class="deleteLink" id ="${user.userId}">Delete</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
	<div align="center"></div>
	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
		$(document).ready(function() {
			$(".deleteLink").each(function(){
				$(this).on("click", function() {
					userId = $(this).attr("id");
					if (confirm('Are you sure you want to delete the user with ID  '
							+ userId + '?')) {
						window.location = 'delete_user?id=' + userId;
					}
				});
			});
		});
	</script>
</body>
</html>