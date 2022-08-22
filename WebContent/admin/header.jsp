<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<div align="center">
	<div>
		<img alt="" src="../images/Logo_bookstore.gif" />
	</div>
	<div>
		WellCome, <c:out value="${sessionScope.userEmail}"/> | <a href="logout">Logout</a> <br /> <br />
	</div>
	<div id="headermenu">

		<div>
			<a href="list_users"><img src="../images/users.png" />
			<br/>
			Users</a>
		</div>
		<div>
			<a href="list_category"><img src="../images/category.png" /><br/>Categories</a>
		</div>
		<div>
			<a href="list_books"><img src="../images/bookstack.png" /><br/>Books</a>
		</div>
		<div>
			<a href="customer"><img src="../images/customer.png" /><br/>Customers</a>
		</div>
		<div>
			<a href="reviews"><img src="../images/review.png" /><br/>Reviews</a>
		</div>
		<div>
			<a href="orders"><img src="../images/order.png" /><br/>Orders</a>
		</div>
	</div>
</div>