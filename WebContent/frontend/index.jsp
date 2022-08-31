<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Evergreen Books - Online Books Store</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />

</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h3>This is main content</h3>
		<h2>Mew Books:</h2>
		<c:forEach var="book" items="${listNewBooks}">
			<div style="display: inline-block; margin: 20px">

				<div>
					<a href="view_book?id=${book.bookId}"> <img
						src="data:image/jpg;base64,${book.base64Image}" width="128"
						height="164" />
					</a>
				</div>
				<div>
					<a href="view_book?id=${book.bookId}"> <b>${book.title}</b>
					</a>
				</div>
				<div>
					<jsp:directive.include file="book_rating.jsp" />



				</div>
				<div>by ${book.author }</div>
				<div>
					<b>$${book.price }</b>
				</div>
			</div>

		</c:forEach>
		<h2>Best-Selling Books:</h2>
		<h2>Most-favored Books:</h2>
	</div>


	<jsp:directive.include file="footer.jsp" />
</body>
</html>