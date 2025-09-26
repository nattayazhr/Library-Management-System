<%@page import="com.dto.UserSessionDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dto.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    ArrayList<BookDTO> books = (ArrayList<BookDTO>) request.getAttribute("books"); 
    	Boolean isBookFound = (Boolean) request.getAttribute("isBookFound");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Management System</title>

<style type="text/css">
:root {
	--primary: #000000;
	--secondary: #FFFFFF;
	--accent: #8E54E9;
	--shadow: 8px 8px 0px var(--primary);
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Courier New', monospace;
}

body {
	background-color: var(--secondary);
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	padding: 20px;
}

<%@ include file="/WEB-INF/nav/navStyles.jsp" %>

table, th, td {
	font-size: 20px;
 	border: 2px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 7px 20px;
	text-align: center;
}

.tabledata {
	margin-top : 70px;
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

	<div class="tabledata">
		<h2 style="margin-bottom: 15px; text-align: center;">Books Details</h2>
	    <table border="1">
	        <tr style="background-color: #8E54E9; color: white">
	            <th>ID</th><th>Title</th><th>Author</th><th>Price</th>
	        </tr>
	        <%
	        if (books != null) {
	        	 for (BookDTO b : books) {
	        %>
	            <tr>
	                <td><%= b.getId() %></td>
	                <td><%= b.getTitle() %></td>
	                <td><%= b.getAuthor() %></td>
	                <td><%= b.getPrice() %></td>
	            </tr>
	        <% 
	            	}
	         	} else if (isBookFound != null && !isBookFound) {
	     	%>
	     	    <tr style="color:red; font-size:20px; font-weight:bold;">
	   		    	<td colspan="4">No book details found!</td>
	   		    </tr>
	     	<%
	     	    }
	     	%>
	    </table>
	
	</div>

</body>
</html>