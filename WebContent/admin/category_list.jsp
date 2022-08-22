<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Evergreen Bookstore Administration</title>
<link rel="stylesheet" href="../css/style.css"/>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">Categories Management</h2>
		<h3 class="pageheading">
			<a href="category_form.jsp">Create New Category</a>
		</h3>
	</div>
	<c:if test="${message !=null}">
		<div align="center"">
			<h4 class="message">
				${message}
			</h4>
		</div>
	</c:if>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>name</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="cate" items="${listCategory}" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${cate.categoryId}</td>
					<td>${cate.name}</td>
					<td><a href="edit_category?id=${cate.categoryId}">Edit</a> &nbsp; 
					<a href="javascript:confirmDelete(${cate.categoryId})">Delete</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
	<div align="center"></div>
	<jsp:directive.include file="footer.jsp" />
<script type="text/javascript">
	function confirmDelete(categoryId) {
		if(confirm('Are you sure you want to delete the Category with ID  '+categoryId+ '?')){
			window.location = 'delete_category?id='+categoryId;
		}
	}
</script>
</body>
</html>