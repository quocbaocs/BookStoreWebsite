<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Customer</title>
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />


	<div align="center">
		<h2 class="pageheading">Edit My Profile</h2>
	</div>

	<div align="center">
		<form action="update_profile" method="post" id="customerForm">
			<table class="form">
				<tr>
					<td align="right">Email:</td>
					<td align="left">${loggedCustomer.email}(Cannot be changed)</td>
				</tr>
				<tr>
					<td align="right">Full Name:</td>
					<td align="left"><input type="text" id="fullname"
						name="fullname" size="20" value="${loggedCustomer.fullname}" /></td>
				</tr>

				<tr>
					<td align="right">Phone Number</td>
					<td align="left"><input type="text" id="phone" name="phone"
						size="20" value="${loggedCustomer.phone}" /></td>
				</tr>
				<tr>
					<td align="right">Address:</td>
					<td align="left"><input type="text" id="address"
						name="address" size="20" value="${loggedCustomer.address}" /></td>
				</tr>
				<tr>
					<td align="right">City:</td>
					<td align="left"><input type="text" id="city" name="city"
						size="20" value="${loggedCustomer.email}" /></td>
				</tr>
				<tr>
					<td align="right">Zip Code:</td>
					<td align="left"><input type="text" id="zipCode"
						name="zipCode" size="20" value="${loggedCustomer.zipcode}" /></td>
				</tr>
				<tr>
					<td align="right">Country:</td>
					<td align="left"><input type="text" id="country"
						name="country" size="20" value="${loggedCustomer.country}" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><i>(Leave password fields
							blank if you don't want to change password)</i></td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" id="password"
						name="password" size="20" /></td>
				</tr>
				<tr>
					<td align="right">Confirm Password:</td>
					<td align="left"><input type="password" id="confirmPassword"
						name="confirmPassword" size="20" /></td>
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
				email : {
					required : true,
					email : true
				},
				fullname : "required",
				confirmPassword : {
					equalTo : "#password"
				},
				phone : "required",
				address : "required",
				city : "required",
				zipCode : "required",
				country : "required",
			},
			messages : {
				email : {
					required : "Please enter e-mail address",
					email : "Please enter a valid e-mail address"
				},
				fullname : "Please enter full name",
				confirmPassword : {
					equalTo : "Confirm password does not match password"
				},
				phone : "Please enter phone number",
				address : "Please enter address",
				city : "Please enter city",
				zipCode : "Please enter city",
				country : "Please enter country"
			}
		});

		$("#buttonCancel").click(function() {
			history.go(-1);
		});

	});
</script>
</html>