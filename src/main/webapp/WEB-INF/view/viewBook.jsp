<%@page import="com.dto.UserSessionDTO"%>
<%@page import="com.dto.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    BookDTO book = (BookDTO) request.getAttribute("book");
	Boolean isBookFound = (Boolean) request.getAttribute("isBookFound");
	String id = (String) request.getParameter("id");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Management System</title>

<style type="text/css">

<%@ include file="/WEB-INF/nav/navStyles.jsp" %>

<%@ include file="/WEB-INF/css/styles.jsp" %>

table, th, td {
	font-size: 20px;
 	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 7px 20px;
	text-align: center;
}

</style>

</head>
<body>
	
	<%
		UserSessionDTO user = (UserSessionDTO)session.getAttribute("user");
		if(user.getRole().equals("USER")) {
	%>
		<%@ include file="/WEB-INF/nav/userNav.jsp"%>
	<% 
		} else if(user.getRole().equals("ADMIN")) {
	%>
		<%@ include file="/WEB-INF/nav/adminNav.jsp"%>
	<%
		}
	%>

	<form action="viewBook" method="post">
		<div class="login-container">
			<h1>Book Id</h1>

			<div class="input-group">
				<label for="id">Book Id</label>
				<input type="text" name="id" id="id" placeholder="Enter id" required>
			</div>

			<button type="submit">Search Book</button>

		</div>
	</form>
	
	<div>
	
	<h2 style="margin-bottom: 15px; text-align: center">Book Details</h2>
	<table>
        <tr style="background-color: #8E54E9; color: white">
            <th>ID</th><th>Title</th><th>Author</th><th>Price</th>
        </tr>
		<%
	    	if (book != null) {
		%>
		    <tr>
                <td><%= book.getId() %></td>
                <td><%= book.getTitle() %></td>
                <td><%= book.getAuthor() %></td>
                <td><%= book.getPrice() %></td>
            </tr>
		<%
		    } else if (isBookFound != null && !isBookFound) {
		%>
		    <tr style="color:red; font-size:20px; font-weight:bold;">
		    	<td colspan="4">No book details found for Id = <%= id %>!</td>
		    </tr>
		<%
		    } else {
		%>
		    	<tr style="color: #FBB144; font-size:20px; font-weight:bold;">
		    	<td colspan="4">Please search for a book!</td>
		    </tr>
		<%
		    }
		%>
		</table>
	</div>

</body>
</html>