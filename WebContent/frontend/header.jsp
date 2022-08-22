<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div align="center">
	<div>
		<img alt="" src="images/Logo_bookstore.gif">
	</div>
	<div>
	<input type="text" size="50" name="keyword"/>
	<input type="button" value="Search"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="login.jsp">Sign In</a> |
	<a href="register">Register</a> |
	<a href="view_cart">Cart</a>
	</div>
	<div>&nbsp;</div>
	<div align="center">
		<c:forEach var="category" items="${listCategory}" varStatus="status">
		<font size="+1"><b>
		<a href=""> 
			<c:out value="${category.name}" /> 
		</a></b></font>
		<c:if test="${not status.last}">
			&nbsp;|&nbsp;
		</c:if>
		
		</c:forEach>
	</div>
	
</div>