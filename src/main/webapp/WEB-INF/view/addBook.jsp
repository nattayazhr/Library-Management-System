<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Management System</title>

<style type="text/css">
<%@ include file="/WEB-INF/nav/navStyles.jsp" %>
<%@ include file="/WEB-INF/css/styles.jsp" %>
</style>
</head>
<body>

	<%@ include file="/WEB-INF/nav/adminNav.jsp"%>

	<form action="addBook" method="post">
		<div class="login-container">
			<h1>Book Details</h1>

			<div class="input-group">
				<label for="title">Book Name</label>
				<input type="text" name="title" id="title" placeholder="Enter title" required>
			</div>

			<div class="input-group">
				<label for="author">Author Name</label>
				<input type="text" name="author" id="author" placeholder="Enter author" required>
			</div>

			<div class="input-group">
				<label for="price">Book Price</label>
				<input type="text" name="price" id="price" placeholder="Enter price" required>
			</div>

			<button type="submit">Add Book</button>

			<div style="margin-top: 10px; text-align: center;">
		
				<%
				Boolean isBookAdded = (Boolean) session.getAttribute("isBookAdded");
				session.removeAttribute("isBookAdded");
				if (isBookAdded != null && isBookAdded) {
				%>
				<p style="color: green; font-size:19px; font-weight:bold;">Book added Successfully!</p>
				<%
				} else if (isBookAdded != null) {
				%>
				<p style="color: red; font-size:19px; font-weight:bold;">Error adding book!!</p>
				<%
				}
				%>
		
			</div>
		</div>
	</form>

</body>
</html>