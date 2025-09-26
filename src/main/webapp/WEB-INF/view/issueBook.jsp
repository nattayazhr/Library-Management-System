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

	<%@ include file="/WEB-INF/nav/userNav.jsp"%>

	<form action="#" method="post">
		<div class="login-container">
			<h1>Book Details</h1>

			<div class="input-group">
				<label for="id">Book Id</label> 
				<input type="text" name="id" id="id" placeholder="Enter Id" required>
			</div>

			<button type="submit">Issue Book</button>

			<div style="margin-top: 10px; text-align: center;">
		
				<%
				Boolean isBookIssued = (Boolean) session.getAttribute("isBookIssued");
				String id = (String) session.getAttribute("bookId");
				
				session.removeAttribute("isBookIssued");
				session.removeAttribute("bookId");
				if (isBookIssued != null && isBookIssued) {
				%>
				<p style="color: green; font-size:19px; font-weight:bold;">Book(Id = <%= id %>) issued Successfully!</p>
				<%
				} else if (isBookIssued != null) {
				%>
				<p style="color: red; font-size:19px; font-weight:bold;">Error issuing book(Id = <%= id %>)!!</p>
				<%
				}
				%>
		
			</div>
		</div>
	</form>

</body>
</html>