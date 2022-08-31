<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results For ${keyword} Books - Online Books Store</title>
<link rel="stylesheet" href="../css/style.css" />

</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<c:if test="${fn:length(result)==0}">
			<center><h2>NO Results for "${keyword}</h2></center>
		</c:if>
		<c:if test="${fn:length(result)>0}">
			<div align="left" style="width: 80%; margin: 0 auto;">
				<center><h2>Results For "${keyword}"</h2></center>
				<c:forEach var="book" items="${result}">
					<div>
						<div style="display: inline-block; margin: 20px; width: 10%">
							<div align="left">

								<a href="view_book?id=${book.bookId}"> <img
									src="data:image/jpg;base64,${book.base64Image}" width="128"
									height="164" />
								</a>
							</div>
						</div>

						<div
							style="display: inline-block; margin: 20px; vertical-align: top; width: 60%"
							align="left">
							<div>
								<h2>
									<a href="view_book?id=${book.bookId}"> <b>${book.title}</b>
									</a>
								</h2>
							</div>
							<div>Rating *****</div>
							<div>
								<i>by ${book.author }</i>
							</div>
							<div>
								<p>${fn:substring(book.description,0,100)}...</p>
							</div>

						</div>
						<div
							style="display: inline-block; margin: 20px; vertical-align: top;">
							<h3>
								<b>$${book.price }</b>
							</h3>
							<h3>
								<a href="">Add To Cart</a>
							</h3>

						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>

	</div>


	<jsp:directive.include file="footer.jsp" />
</body>
</html>