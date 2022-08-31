<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div align="center">
	<div>
		<a href="${pageContext.request.contextPath}">
			<img alt="" src="images/Logo_bookstore.gif">
		</a>
	</div>
	<div>
		<form action="search" method="get">
			<input type="text" size="50" name="keyword" /> 
			<input type="submit" value="Search" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<c:if test="${loggedCustomer==null }">
		<a href="login">Sign In</a> | 
		<a href="register">Register</a> 
		</c:if>
		<c:if test="${loggedCustomer!=null }">
			<a href="view_profile">WelCome, ${loggedCustomer.fullname}</a>|
			<a href="view_orders">My Orders</a>|
			<a href="logout">Logout</a>
		</c:if>
		</form>
		
	</div>
	<div>&nbsp;</div>
	<div align="center">
		<c:forEach var="category" items="${listCategory}" varStatus="status">
			<font size="+1"><b> <a
					href="view_category?id=${category.categoryId}"> <c:out
							value="${category.name}" />
				</a></b></font>
			<c:if test="${not status.last}">
			&nbsp;|&nbsp;
		</c:if>

		</c:forEach>
	</div>

</div>