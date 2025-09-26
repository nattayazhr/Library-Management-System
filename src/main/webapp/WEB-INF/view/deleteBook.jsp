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

	<form action="deleteBook" method="post">
		<div class="login-container">
			<h1>Book Details</h1>

			<div class="input-group">
				<label for="id">Book Id</label>
				<input type="text" name="id" id="id" placeholder="Enter id" required>
			</div>

			<button type="submit">Delete Book</button>
			
			<div style="margin-top: 10px; text-align: center;">
		
				<%
				Boolean isBookDeleted = (Boolean) session.getAttribute("isBookDeleted");
				String id = (String) session.getAttribute("bookId");
				
				session.removeAttribute("isBookDeleted");
				session.removeAttribute("bookId");
				if (isBookDeleted != null && isBookDeleted) {
				%>
				<p style="color: green; font-size:19px; font-weight:bold;">Book(Id = <%= id %>) deleted Successfully!</p>
				<%
				} else if (isBookDeleted != null) {
				%>
				<p style="color: red; font-size:18.5px; font-weight:bold;">Error deleting  book(Id = <%= id %>)!!</p>
				<%
				}
				%>
		
			</div>

		</div>
	</form>


</body>
</html>