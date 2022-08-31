<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Evergreen Bookstore Administration</title>
<link rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h1 class="pageheading">Customers Management</h1>
		<h2 class="pageheading">
			<a href="customer_form.jsp">Create New Customer</a>
		</h2>
	</div>
	<c:if test="${message !=null}">
		<div align="center"">
			<h4>
				<i style="color: blue;">${message}</i>
			</h4>
		</div>
	</c:if>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>E-Mail</th>
				<th>Full Name</th>
				<th>City</th>
				<th>Country</th>
				<th>Registered Date</th>
				<th>Actions</th>

			</tr>
			<c:forEach var="customer" items="${listCustomers}" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${customer.customerId}</td>
					<td>${customer.email }</td>
					<td>${customer.fullname }</td>
					<td>${customer.city}</td>
					<td>${customer.country}</td>
					<td>${customer.registerDate}</td>
					<td><a href="edit_customer?id=${customer.customerId}">Edit</a> &nbsp; <a
						href="javascript:void(0);" class="deleteLink" id="${customer.customerId}">Delete</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
	<div align="center"></div>
	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
		$(document).ready(function() {
			$(".deleteLink").each(function() {
				$(this).on(
																"click",
																function() {
																	bookId = $(
																			this)
																			.attr(
																					"id");
																	if (confirm('Are you sure you want to delete the Customer with ID  '
																			+ bookId
																			+ '?')) {
																		window.location = 'delete_customer?id='
																				+ bookId;
																	}
																});
											});
						});
	</script>
</body>
</html>