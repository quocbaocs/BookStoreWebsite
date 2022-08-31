<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Book</title>
<link rel="stylesheet" href="../css/style.css" />
<link rel="stylesheet" href="../css/jquery-ui.min.css" />
<link rel="stylesheet" href="../css/font-awesome.min.css">
<link rel="stylesheet" href="../css/richtext.min.css">

<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui.min.js"></script>

<script src="../js/jquery.richtext.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />


	<div align="center">
		<h2 class="pageheading">

			<c:if test="${book!=null}">
			Edit User
		</c:if>
			<c:if test="${book==null }">
			Create New Book
		</c:if>
		</h2>
	</div>

	<div align="center">
		<c:if test="${book!=null}">
			<form action="update_book" method="post" id="bookForm" enctype="multipart/form-data">
				<input type="hidden" value="${book.bookId}" name="bookId" />
		</c:if>
		<c:if test="${user==null}">
			<form action="create_book" method="post" id="bookForm" enctype="multipart/form-data">
		</c:if>
		<table class="form">
			<tr>
				<td align="right">Category:</td>
				<td align="left"><select name="category">
						<c:forEach var="category" items="${listCategory}"
							varStatus="status">
							<c:if test="${category.categoryId eq book.category.categoryId}">
								<option value="${category.categoryId}" selected="selected">
							</c:if>
							<c:if test="${category.categoryId ne book.category.categoryId}">
								<option value="${category.categoryId}">
							</c:if>
							${category.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td align="right">Title:</td>
				<td align="left"><input type="text" id="title" name="title"
					size="20" value="${book.title }" /></td>
			</tr>
			<tr>
				<td align="right">Author:</td>
				<td align="left"><input type="text" id="author" name="author"
					value="${book.author }" size="20" /></td>
			</tr>
			<tr>
				<td align="right">ISBN:</td>
				<td align="left"><input type="text" id="isbn" name="isbn"
					value="${book.isbn }" size="20" /></td>
			</tr>
			<tr>
				<td align="right">Publish Date:</td>
				<td align="left"><input type="text" id="publishDate" name="publishDate" size="20" value="<fmt:formatDate pattern='MM/dd/yyyy'  value='${book.publishDate }'/>" /></td>
			</tr>
			<tr>
				<td align="right">Book image:</td>
				<td align="left">
					<input type="file" id="bookImage" name="bookImage" size="20" /> <br/>
					<img alt="Image Preview" id="thumbnail" style="width: 20%; margin-top: 10px " src="data:image/jpg;base64,${book.base64Image}"/>
				</td>
			</tr>
			<tr>
				<td align="right">Price:</td>
				<td align="left"><input type="text" id="price" name="price"
					value="${book.price}" size="20" /></td>
			</tr>
			<tr>
				<td align="right">Description:</td>
				<td><textarea rows="5" cols="50" id="description"
						name="description">${book.description}
					</textarea></td>
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
		$("#publishDate").datepicker();
		$('#description').richText();
		$('#bookImage').change(function(){
			showImageThumbnail(this);
		});
		$("#bookForm").validate({
			rules : {
				category : "required",
				title : "required",
				author : "required",
				isbn : "required",
				publishDate : "required",
				//bookImage : "required",
				price : "required",
				description : "required",
			},
			messages : {
				category:"Please select a category for the book",
				title : "Please enter title of the book",
				author : "Please enter author of the book",
				isbn : "Please enter isbn of the book",
				publishDate : "Please enter publish date of the book",
				//bookImage : "Please choose an image of the book ",
				price : "Please enter price of the book",
				description : "Please enter description of the book"
			}
		});

		$("#buttonCancel").click(function() {
			history.go(-1);
		});

	});
	function showImageThumbnail(fileInput){
		var file = fileInput.files[0];
		var fileReader = new FileReader();
		fileReader.onload = function(e){
			$('#thumbnail').attr('src',e.target.result);
		};
		fileReader.readAsDataURL(file);
	}
</script>
</html>