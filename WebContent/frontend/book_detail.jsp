<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${book.title}-OnlineBooksStore</title>
<link rel="stylesheet" href="css/style.css" />

</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div class="center">
		<table width="80%" style="border-style: none;">
			<tr height="30px">
				<td colspan="3" align="left">

					<h2>${book.title}</h2> by ${book.author}
				</td>
			</tr>
			<tr>
				<td rowspan="2"><a href="view_book?id=${book.bookId}"> <img
						src="data:image/jpg;base64,${book.base64Image}" width="228"
						height="264" />
				</a></td>
				<td valign="top" align="left"><jsp:directive.include
						file="book_rating.jsp" />
						<a href="#">${fn:length(book.reviews)} Reviews</a>
						 <br /> <br /> <br /></td>
				<td valign="top" rowspan="2" width="20%">$$${book.price} <br />
					<br /> <br />
					<button type="submit">Add to Cart</button></td>

			</tr>
			<tr>
				<td valign="top">${book.description }</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><h2>Customer Reviews</h2></td>
				<td colspan="2" class="center"><button>Write a
						Customer Review</button></td>
			</tr>
			<tr>
				<td colspan="3">
					<table border="0" style="border-style: none;">
						<c:forEach items="${book.reviews}" var="review">
							<tr>
								<td><c:forTokens items="${review.stars}" delims=","
										var="star">
										<c:if test="${star eq 'on'}">
											<img src="images/rating-on.png">
										</c:if>
										<c:if test="${star eq 'off'}">
											<img src="images/rating-off.png">
										</c:if>
									</c:forTokens> <b>-${review.headline } </b></td>
							</tr>
							<tr>
								<td>by ${review.customer.fullname } on ${review.reviewTime }
								</td>
							</tr>
							<tr>
								<td><i>${review.comment }</i></td>
							</tr>


						</c:forEach>
					</table>
				</td>
			</tr>
		</table>




	</div>


	<jsp:directive.include file="footer.jsp" />
</body>
</html>