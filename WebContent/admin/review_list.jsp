<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Review - Bookstore Administration</title>
<link rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">Reviews Management</h2>

	</div>
	<c:if test="${message !=null}">
		<div align="center"">
			<h4 class="message">${message}</h4>
		</div>
	</c:if>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Book</th>
				<th>Rating</th>
				<th>Headline</th>
				<th>Customer</th>
				<th>Review On</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="review" items="${listReviews}" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${review.reviewId}</td>
					<td>${review.book.title}</td>
					<td>${review.rating}</td>
					<td>${review.headline}</td>
					<td>${review.customer.fullname}</td>
					<td>${review.reviewTime}</td>
					<td><a href="edit_review?id=${review.reviewId}">Edit</a>
						&nbsp; <a href="javascript:confirmDelete(${review.reviewId})">Delete</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
	<div align="center"></div>
	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
		function confirmDelete(reviewId) {
			if (confirm('Are you sure you want to delete the Review with ID  '
					+ reviewId + '?')) {
				window.location = 'delete_review?id=' + reviewId;
			}
		}
	</script>
</body>
</html>