<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New User</title>
<link rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />


	<div align="center">
		<h2 class="pageheading">Edit Review</h2>
	</div>

	<div align="center">

		<form action="update_review" method="post" id="reviewForm">
			<input type="hidden" value="${review.reviewId}" name="reviewId" />


			<table>

				<tr>
					<td align="right">Book:</td>
					<td align="left">${review.book.title}</td>
				</tr>
								<tr>
					<td align="right">Rating:</td>
					<td align="left">${review.rating}</td>
				</tr>
				<tr>
					<td align="right">Customer:</td>
					<td align="left">${review.customer.fullname}</td>
				</tr>
				<tr>
					<td align="right">Headline:</td>
					<td align="left"><input type="text" size="60" name="headline" value="${review.headline}"></td>
				</tr>
					<tr>
					<td align="right">Comment:</td>
					<td align="left"><textarea rows="5" cols="70" name="comment">${review.comment}</textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save" /> <input type="button" value="Cancel"
						id="buttonCancel" /></td>
				</tr>

			</table>
		</form>
	</div>
	<div align="center"></div>
	<jsp:directive.include file="footer.jsp" />

</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#reviewForm").validate({
			rules : {
				headline : "required",
				comment: "required"
			},
			messages : {
				headline : "Please enter headline",
				comment: "Please enter comment"

			}
		});

		$("#buttonCancel").click(function() {
			history.go(-1);
		});

	});
</script>
</html>