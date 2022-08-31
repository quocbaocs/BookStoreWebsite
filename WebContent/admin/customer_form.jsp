<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Customer</title>
<link rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />


	<div align="center">
		<h2 class="pageheading">

			<c:if test="${customer!=null}">
			Edit Customer
		</c:if>
			<c:if test="${customer==null }">
			Create New Customer
		</c:if>
		</h2>
	</div>

	<div align="center">
		<c:if test="${customer!=null}">
			<form action="update_customer" method="post" id="customerForm">
				<input type="hidden" value="${customer.customerId}"
					name="customerId" />
		</c:if>
		<c:if test="${customer==null}">
			<form action="create_customer" method="post" id="customerForm">
		</c:if>
		<table class="form">
			<tr>
				<td align="right">Email:</td>
				<td align="left"><input type="text" id="email" name="email"
					size="20" value="${customer.email }" /></td>
			</tr>
			<tr>
				<td align="right">Full Name:</td>
				<td align="left"><input type="text" id="fullname"
					name="fullname" value="${customer.fullname }" size="20" /></td>
			</tr>
			<tr>
				<td align="right">Password:</td>
				<td align="left"><input type="password" id="password"
					name="password" value="${customer.password }" size="20" /></td>
			</tr>
			<tr>
				<td align="right">Confirm Password:</td>
				<td align="left"><input type="password" id="confirmPassword"
					name="confirmPassword" value="${customer.password }" size="20" /></td>
			</tr>
			<tr>
				<td align="right">Phone Number</td>
				<td align="left"><input type="text" id="phone" name="phone"
					value="${customer.phone }" size="20" /></td>
			</tr>
			<tr>
				<td align="right">Address:</td>
				<td align="left"><input type="text" id="address" name="address"
					size="20" value="${customer.address }" /></td>
			</tr>
			<tr>
				<td align="right">City:</td>
				<td align="left"><input type="text" id="city" name="city"
					size="20" value="${customer.city }" /></td>
			</tr>
			<tr>
				<td align="right">Zip Code:</td>
				<td align="left"><input type="text" id="zipCode" name="zipCode"
					size="20" value="${customer.zipcode }" /></td>
			</tr>
			<tr>
				<td align="right">Country:</td>
				<td align="left"><input type="text" id="country" name="country"
					size="20" value="${customer.country }" /></td>
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
	<div align="center"></div>
	<jsp:directive.include file="footer.jsp" />

</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#customerForm").validate({
			rules : {
				email:{
					required:true,
					email:true
				},
				fullname : "required",
				password: "required",
				confirmPassword : "required",
				phone : "required",
				address : "required",
				city : "required",
				zipCode : "required",
				country : "required",
			},
			messages : {
				email : {
					required : "Please enter e-mail address",
					email: "Please enter a valid e-mail address"
				},
				fullname: "Please enter full name",
				password: "Please enter password",
				confirmPassword : "Confirm password does not match password",
				phone :"Please enter phone number",
				address:"Please enter address",
				city:"Please enter city",
				zipCode:"Please enter city",
				country:"Please enter country"
			}
		});

		$("#buttonCancel").click(function() {
			history.go(-1);
		});

	});
</script>
</html>